package com.alga.tdd.pedidos.service;

import com.alga.tdd.pedidos.Pedido;
import com.alga.tdd.pedidos.email.NotificadorEmail;
import com.alga.tdd.pedidos.repository.PedidosRepository;
import com.alga.tdd.pedidos.sms.NotificadorSms;

public class PedidoService {

    private PedidosRepository pedidos;
    private NotificadorEmail notificadorEmail;
    private NotificadorSms notificadorSms;

    public PedidoService(PedidosRepository pedidos, NotificadorEmail notificadorEmail, NotificadorSms notificadorSms) {
        this.pedidos = pedidos;
        this.notificadorEmail = notificadorEmail;
        this.notificadorSms = notificadorSms;
    }

    public double lancar(Pedido pedido) {
        double imposto = pedido.getValor() * 0.1;

        pedidos.guardar(pedido);
        notificadorEmail.enviar(pedido);
        notificadorSms.notificar(pedido);

        return imposto;
    }
}
