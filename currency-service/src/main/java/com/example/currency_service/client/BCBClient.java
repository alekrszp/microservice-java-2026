package com.example.currency_service.client;

import com.example.currency_service.model.CotacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "bcb-client",
    url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata",
    fallback = BCBClientFallback.class
)
public interface BCBClient {

    @GetMapping(value = "/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)", produces = "application/json")
    CotacaoResponse getCotacao(
        @RequestParam("@moeda") String moeda,
        @RequestParam("@dataCotacao") String dataCotacao,
        @RequestParam("$format") String format
    );
}