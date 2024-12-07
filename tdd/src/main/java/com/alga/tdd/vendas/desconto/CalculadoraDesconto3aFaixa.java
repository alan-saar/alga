package com.alga.tdd.vendas.desconto;

public class CalculadoraDesconto3aFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDesconto3aFaixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 1000.0) {
            return valorTotal * 0.08;
        }
        // se fosse um objeto retornaria null, como é um double retorna -1
        return -1;
    }

}
