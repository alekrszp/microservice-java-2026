package com.example.product_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CotacaoItem {

    @JsonProperty("cotacaoCompra")
    private Double cotacaoCompra;

    @JsonProperty("cotacaoVenda")
    private Double cotacaoVenda;

    @JsonProperty("dataHoraCotacao")
    private String dataHoraCotacao;

    public Double getCotacaoCompra() { return cotacaoCompra; }
    public void setCotacaoCompra(Double cotacaoCompra) { this.cotacaoCompra = cotacaoCompra; }

    public Double getCotacaoVenda() { return cotacaoVenda; }
    public void setCotacaoVenda(Double cotacaoVenda) { this.cotacaoVenda = cotacaoVenda; }

    public String getDataHoraCotacao() { return dataHoraCotacao; }
    public void setDataHoraCotacao(String dataHoraCotacao) { this.dataHoraCotacao = dataHoraCotacao; }
}