package com.alga.tdd.vendas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    public void setup() {
        pedido = new Pedido();
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        assertEquals(valorTotal, pedido.valorTotal());
        assertEquals(desconto, pedido.desconto());
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() throws Exception {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
        pedido.adicionarItem(new ItemPedido("sabonete", 5.0, 5));
        assertResumoPedido(25.0, 0.0);
    }

}
