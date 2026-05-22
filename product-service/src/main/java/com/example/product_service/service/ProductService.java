package com.example.product_service.service;

import com.example.product_service.client.CurrencyClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final CurrencyClient currencyClient;

    public ProductService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    @Cacheable(value = "products", key = "#moeda")
    @CircuitBreaker(name = "currencyClient", fallbackMethod = "fallback")
    @Retry(name = "currencyClient")
    public String getProducts(String moeda) {

        return currencyClient.getCurrency(moeda);
    }

    public String fallback(String moeda, Exception ex) {
        return "Fallback product-service";
    }
}