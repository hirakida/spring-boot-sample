package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Builder builder) {
        Map<String, Object> details = new HashMap<>();
        details.put("info1", new Detail(new Random().nextInt(), new Random().nextInt()));
        details.put("info2", new Detail(new Random().nextInt(), new Random().nextInt()));
        details.put("info3", new Detail(new Random().nextInt(), new Random().nextInt()));
        builder.withDetails(details);
    }

    @Data
    @AllArgsConstructor
    private static class Detail {
        private int key1;
        private int key2;
    }
}
