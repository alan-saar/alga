package com.alga.tdd.pedidos.email;

import com.alga.tdd.pedidos.Pedido;
import com.alga.tdd.pedidos.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviando email...");
    }
}
