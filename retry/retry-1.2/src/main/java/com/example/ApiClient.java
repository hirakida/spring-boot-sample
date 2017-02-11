package com.example;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiClient {

    private static final String API_URL = "http://localhost:8080/api/{code}";
    final RestOperations restOperations;
    final RetryTemplate retryTemplate;

    /**
     * use @Retryable
     */
    @Retryable(value = HttpServerErrorException.class,
               maxAttempts = 4,
               backoff = @Backoff(delay = 500))
    public String useRetryable(int code) {
        log.info("@Retryable start code={}", code);
        String response = restOperations.getForObject(getApiUrl(code), String.class);
        log.info("@Retryable end code={}, response={}", code, response);
        return response;
    }

    /**
     * use @Retryable exceptionExpression
     * <p>
     * exceptionExpression is evaluated against the thrown exception as the #root object.
     * maxAttemptsExpression and the @BackOff expression attributes are evaluated once, during
     * initialization; there is no root object for the evaluation but they can reference other beans in the
     * context.
     */
    @Retryable(exceptionExpression = "#{@retryExpressionHelper.shouldRetry(#root)}",
               maxAttemptsExpression = "#{${app.retry.max-attempt}}",
               backoff = @Backoff(delayExpression = "#{${app.retry.delay}}"))
    public String useExceptionExpression(int code) {
        log.info("@Retryable exceptionExpression start code={}", code);
        String response = restOperations.getForObject(getApiUrl(code), String.class);
        log.info("@Retryable exceptionExpression end code={}, response={}", code, response);
        return response;
    }

    @Recover
    public String recover(int code) {
        log.info("@Retryable recover code={}", code);
        return "retry out";
    }

    /**
     * use RetryTemplate
     */
    public String useRetryTemplate(int code) {

        return retryTemplate.execute(
                context -> {
                    log.info("retryTemplate start code={} {}", code, context);
                    String response = restOperations.getForObject(getApiUrl(code), String.class);
                    log.info("retryTemplate end code={}, response={}", code, response);
                    return response;
                },
                context -> {
                    log.info("retryTemplate recover {}", context);
                    return "recover";
                });
    }

    private static String getApiUrl(int code) {
        return UriComponentsBuilder.fromHttpUrl(API_URL)
                                   .buildAndExpand(code)
                                   .toUriString();
    }
}