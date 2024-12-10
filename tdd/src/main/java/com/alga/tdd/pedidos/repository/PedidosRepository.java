package com.alga.tdd.pedidos.repository;

import com.alga.tdd.pedidos.Pedido;

public class PedidosRepository {

    public void guardar(Pedido pedido) {
        System.out.println("Salvando no banco de dados...");
    }

    public Pedido buscarPeloCodigo(Long codigo) {
        // intenção do código de produção é ir no banco de dados buscar pelo código
        return new Pedido();
    }
}
