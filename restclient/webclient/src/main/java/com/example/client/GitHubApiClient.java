package com.example.client;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.GitHubProperties;
import com.example.model.Key;
import com.example.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
public class GitHubApiClient {
    private final WebClient webClient;

    public GitHubApiClient(WebClient.Builder builder,
                           GitHubProperties properties) {
        webClient = builder.baseUrl(properties.getBaseUrl()).build();
    }

    public Mono<User> getUser(String username) {
        return webClient.get()
                        .uri("/users/{username}", username)
                        .retrieve()
                        .bodyToMono(User.class)
                        .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)));
    }

    public Flux<Key> getKeys(String username) {
        return webClient.get()
                        .uri("/users/{username}/keys", username)
                        .retrieve()
                        .bodyToFlux(Key.class);
    }
}
