package com.alga.tdd.passagens;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

    @Override
    public double calcular(Voo voo) {
        if (voo.getPreco() > 700.00) {
            return calculaValorAcimaDoLimite(voo);
        }
        return calculaValorAbaixoDoLimite(voo);

    }

    private double calculaValorAcimaDoLimite(Voo voo) {
        return voo.getPreco() * 0.9;
    }

    private double calculaValorAbaixoDoLimite(Voo voo) {
        return voo.getPreco() * 0.94;
    }

}
