package com.alga.tdd.vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode // já vem no @Data, mas coloquei aqui para enfatizar pois o asserts estão
                   // utilizando o equals
public @Data class ResumoPedido {

    private double valorTotal;
    private double desconto;

}
