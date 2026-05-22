package com.example.currency_service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public RequestInterceptor bcbRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                String queryLine = template.queryLine();
                if (queryLine != null && !queryLine.isEmpty()) {
                    String decoded = queryLine
                            .replace("%40", "@")
                            .replace("%27", "'")
                            .replace("%24", "$")
                            .replace("%7B", "{")
                            .replace("%7D", "}");

                    // Remove queries atuais e adiciona decoded
                    template.queries(null);
                    template.append(decoded);
                }
            }
        };
    }
}