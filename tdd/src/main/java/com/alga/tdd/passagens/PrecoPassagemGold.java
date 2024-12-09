package com.alga.tdd.passagens;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

    @Override
    public double calcular(Voo voo) {
        if (voo.getPreco() > 500) {
            return calculaValorAcimaDoLimite(voo);
        }
        return calculaValorAbaixoDoLimite(voo);
    }

    private double calculaValorAcimaDoLimite(Voo voo) {
        return voo.getPreco() * 0.85;
    }

    private double calculaValorAbaixoDoLimite(Voo voo) {
        return voo.getPreco() * 0.9;
    }

}
