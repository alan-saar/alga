package com.alga.tdd.vendas.desconto;

public class CalculadoraDesconto1aFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDesconto1aFaixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 300.0 && valorTotal <= 800.0) {
            return valorTotal * 0.04;
        }
        // se fosse um objeto retornaria null, como é um double retorna -1
        return -1;
    }

}
