package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class App implements CommandLineRunner {

    final ApiClient apiClient;

    @Override
    public void run(String... var1) throws Exception {

        apiClient.useRetryable(400);
        apiClient.useRetryable(500);

        apiClient.useRetryTemplate1(400);
        apiClient.useRetryTemplate1(500);
        apiClient.useRetryTemplate1(504);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}