package com.example.product_service.service;

import com.example.product_service.client.CurrencyClient;
import com.example.product_service.model.CotacaoResponse;
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
    public CotacaoResponse getProducts(String moeda) {
        return currencyClient.getCotacao(moeda);
    }

    public CotacaoResponse fallback(String moeda, Exception ex) {
        return new CotacaoResponse(java.util.List.of());
    }
}