package com.alga.tdd.pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pedido
 */
@AllArgsConstructor
@NoArgsConstructor
public @Data class Pedido {

    private double valor;
    private Cliente cliente;
    private StatusPedido status;

}
