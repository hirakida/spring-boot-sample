package com.example.config;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryListenerImpl implements RetryListener {

    @Override
    public <T, E extends Throwable> void close(RetryContext context,
                                               RetryCallback<T, E> callback,
                                               Throwable throwable) {
        if (throwable != null) {
            log.info("close {} {}", context, throwable.getClass().getCanonicalName());
        }
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context,
                                                 RetryCallback<T, E> callback,
                                                 Throwable throwable) {
        if (throwable != null) {
            log.error("onError context={} callback={}", context, callback, throwable);
        }
    }

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context,
                                                 RetryCallback<T, E> callback) {
        log.info("open {}", context);
        return true;
    }
}
