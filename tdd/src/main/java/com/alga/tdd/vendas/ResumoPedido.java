package com.alga.tdd.vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class ResumoPedido {

    private double valorTotal;
    private double desconto;

}
