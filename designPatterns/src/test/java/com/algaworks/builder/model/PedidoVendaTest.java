package com.algaworks.builder.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.algaworks.builder.model.builder.PedidoVendaBuilder;

class PedidoVendaTest {

    @Test
    public void deveCalcularValorTotalPedidoParaClienteVip() {
        PedidoVenda pedidoVenda = new PedidoVenda();

        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setVip(true);
        pedidoVenda.setCliente(cliente);

        ItemPedido item1 = new ItemPedido();
        item1.setNome("calculadora");
        item1.setValorUnitario(new BigDecimal("200"));
        item1.setQuantidade(2);

        ItemPedido item2 = new ItemPedido();
        item2.setNome("Mochila");
        item2.setValorUnitario(new BigDecimal("200"));
        item2.setQuantidade(1);

        List<ItemPedido> itensPedido = List.of(item1, item2);
        pedidoVenda.setItensPedido(itensPedido);

        BigDecimal valorTotal = pedidoVenda.getValorTotal();

        assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue());

    }

    @Test
    public void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
        PedidoVenda pedidoVenda = new PedidoVendaBuilder()
                .comClienteVip("João silva")
                .comItem("calculadora", 2, "200")
                .comItem("mochila", 1, "200")
                .comNumero("2")
                .construir();


        BigDecimal valorTotal = pedidoVenda.getValorTotal();

        assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue());
    }


}
