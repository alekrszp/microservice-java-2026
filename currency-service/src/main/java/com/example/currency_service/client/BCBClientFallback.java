package com.example.currency_service.client;

import com.example.currency_service.model.CotacaoResponse;
import com.example.currency_service.model.CotacaoItem;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BCBClientFallback implements BCBClient {

    @Override
    public CotacaoResponse getCotacao(String moeda, String dataCotacao, String format) {
        CotacaoItem item = new CotacaoItem();
        item.setCotacaoCompra(0.0);
        item.setCotacaoVenda(0.0);
        item.setDataHoraCotacao("N/A - Fallback ativo");
        return new CotacaoResponse(List.of(item));
    }
}