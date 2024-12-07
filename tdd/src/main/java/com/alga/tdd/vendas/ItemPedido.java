package com.alga.tdd.vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
public @Data class ItemPedido {

    @NonNull
    private String descricao;
    private double valorUnitario;
    private int quantidade;

}
