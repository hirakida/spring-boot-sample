package com.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver {

    @JmsListener(destination = AppConfig.TEXT_QUEUE)
    public void receiveText(String text) {
        log.info("receive text {}", text);
    }

    // 受信側のスレッド数はconcurrencyで設定できる
    @JmsListener(destination = AppConfig.MESSAGE_QUEUE, concurrency = "1-5")
    public void receiveMessage(Message<String> message) {
        log.info("receive message payload={} headers={}", message.getPayload(), message.getHeaders());
    }
}