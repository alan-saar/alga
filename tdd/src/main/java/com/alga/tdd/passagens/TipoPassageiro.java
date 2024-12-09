package com.alga.tdd.passagens;

public enum TipoPassageiro {
    GOLD(new PrecoPassagemGold()),
    SILVER(new PrecoPassagemSilver());

    CalculadoraPrecoPassagem calculadoraPrecoPassagem;

    TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
        this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
    }

    public CalculadoraPrecoPassagem getCalculadora() {
        return calculadoraPrecoPassagem;
    }
}
