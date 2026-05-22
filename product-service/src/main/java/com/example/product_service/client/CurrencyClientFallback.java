package com.example.product_service.client;

import org.springframework.stereotype.Component;

@Component
public class CurrencyClientFallback implements CurrencyClient {

    @Override
    public String getCurrency(String moeda) {
        return "Currency service indisponível";
    }
}