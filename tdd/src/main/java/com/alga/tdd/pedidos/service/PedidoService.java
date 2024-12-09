package com.alga.tdd.pedidos.service;

import java.util.List;

import com.alga.tdd.pedidos.Pedido;
import com.alga.tdd.pedidos.repository.PedidosRepository;

public class PedidoService {

    private PedidosRepository pedidos;
    private List<AcaoLancamentoPedido> acoes;

    public PedidoService(PedidosRepository pedidos, List<AcaoLancamentoPedido> acoes) {
        this.pedidos = pedidos;
        this.acoes = acoes;
    }

    public double lancar(Pedido pedido) {
        double imposto = pedido.getValor() * 0.1;

        pedidos.guardar(pedido);
        // for (AcaoLancamentoPedido acao : acoes) {
        // acao.executar(pedido);
        // }
        acoes.forEach(a -> a.executar(pedido));

        return imposto;
    }
}
