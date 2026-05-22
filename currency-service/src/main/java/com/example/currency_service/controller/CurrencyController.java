package com.example.currency_service.controller;

import com.example.currency_service.client.BCBClient;
import com.example.currency_service.model.CotacaoResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final BCBClient bcbClient;

    public CurrencyController(BCBClient bcbClient) {
        this.bcbClient = bcbClient;
    }

    @GetMapping("/{moeda}")
    @Cacheable(value = "cotacoes", key = "#moeda")
    @CircuitBreaker(name = "bcbClient", fallbackMethod = "cotacaoFallback")
    @Retry(name = "bcbClient")
    public CotacaoResponse getCotacao(@PathVariable String moeda) {
        return bcbClient.getCotacao("'" + moeda + "'", "'05-14-2025'", "json");
    }

    public CotacaoResponse cotacaoFallback(String moeda, Exception ex) {
        return new CotacaoResponse(java.util.List.of());
    }
}