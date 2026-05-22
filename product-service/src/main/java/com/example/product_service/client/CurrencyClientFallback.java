package com.example.product_service.client;

import com.example.product_service.model.CotacaoResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CurrencyClientFallback implements CurrencyClient {

    @Override
    public CotacaoResponse getCotacao(String moeda) {
        return new CotacaoResponse(List.of());
    }
}