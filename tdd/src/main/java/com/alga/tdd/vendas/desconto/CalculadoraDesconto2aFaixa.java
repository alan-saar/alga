package com.alga.tdd.vendas.desconto;

public class CalculadoraDesconto2aFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDesconto2aFaixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 800.0 && valorTotal <= 1000.0) {
            return valorTotal * 0.06;
        }
        // se fosse um objeto retornaria null, como é um double retorna -1
        return -1;
    }

}
