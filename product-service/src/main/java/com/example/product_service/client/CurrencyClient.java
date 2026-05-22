package com.example.product_service.client;

import com.example.product_service.model.CotacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "currency-service",
    fallback = CurrencyClientFallback.class
)
public interface CurrencyClient {

    @GetMapping("/currency/{moeda}")
    CotacaoResponse getCotacao(@PathVariable("moeda") String moeda);
}
