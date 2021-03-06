package com.example.config;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error("handleError: {} {}", response.getStatusCode(), response.getStatusText());
        super.handleError(response);
    }
}
