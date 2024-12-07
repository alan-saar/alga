package com.alga.tdd.vendas;

import java.util.ArrayList;
import java.util.List;

import com.alga.tdd.vendas.desconto.CalculadoraFaixaDesconto;

public class Pedido {

    private List<ItemPedido> itens = new ArrayList<>();

    private CalculadoraFaixaDesconto calculadoraFaixaDesconto;

    public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public ResumoPedido resumo() {
        double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
        // if (valorTotal > 300.0 && valorTotal <= 800.00) {
        // desconto = valorTotal * 0.04;
        // } else if (valorTotal > 800.00 && valorTotal <= 1000.00) {
        // desconto = valorTotal * 0.06;
        // } else if (valorTotal > 1000.00) {
        // desconto = valorTotal * 0.08;
        // }

        return new ResumoPedido(valorTotal, desconto);
    }

}
