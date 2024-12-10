package com.alga.tdd.pedidos.sms;

import com.alga.tdd.pedidos.Pedido;
import com.alga.tdd.pedidos.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviando sms");
    }
}
