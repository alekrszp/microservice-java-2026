package com.example.product_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CotacaoResponse {

    @JsonProperty("value")
    private List<CotacaoItem> value;

    public CotacaoResponse() {}

    public CotacaoResponse(List<CotacaoItem> value) {
        this.value = value;
    }

    public List<CotacaoItem> getValue() { return value; }
    public void setValue(List<CotacaoItem> value) { this.value = value; }
}