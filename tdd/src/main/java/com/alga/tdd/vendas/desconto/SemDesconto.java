
package com.alga.tdd.vendas.desconto;

public class SemDesconto extends CalculadoraFaixaDesconto {

    public SemDesconto(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        return 0;
    }

}
