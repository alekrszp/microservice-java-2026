package com.example.currency_service.controller;

import com.example.currency_service.client.BCBClient;
import com.example.currency_service.model.CotacaoResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {

    private final BCBClient bcbClient;

    public CurrencyController(BCBClient bcbClient) {
        this.bcbClient = bcbClient;
    }

    @GetMapping("/currency")
    @Cacheable(value = "cotacoes", key = "#moeda")
    @CircuitBreaker(name = "bcbClient", fallbackMethod = "cotacaoFallback")
    @Retry(name = "bcbClient")
    public CotacaoResponse getCotacao(
            @RequestParam(defaultValue = "USD") String moeda
    ) {
        return bcbClient.getCotacao(
                "%27" + moeda + "%27",
                "%2705-14-2025%27",
                "json"
        );
    }

    public CotacaoResponse cotacaoFallback(String moeda, Exception ex) {
        System.out.println("FALLBACK ATIVADO: " + ex.getMessage());
        return new CotacaoResponse(java.util.List.of());
    }
}