package com.example.currency_service.client;

import com.example.currency_service.model.CotacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "bcb-client",
        url = "https://olinda.bcb.gov.br",
        fallback = BCBClientFallback.class
)
public interface BCBClient {

    @GetMapping("/olinda/servico/PTAX/versao/v1/odata/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)")
    CotacaoResponse getCotacao(
            @RequestParam(value = "%40moeda") String moeda,
            @RequestParam(value = "%40dataCotacao") String dataCotacao,
            @RequestParam(value = "%24format") String format
    );
}