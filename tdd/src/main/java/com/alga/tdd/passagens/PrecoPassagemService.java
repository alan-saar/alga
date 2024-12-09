package com.alga.tdd.passagens;

public class PrecoPassagemService {

    public double calcular(Passageiro passageiro, Voo voo) {

        return passageiro.getTipo().getCalculadora().calcular(voo);
    }
}
