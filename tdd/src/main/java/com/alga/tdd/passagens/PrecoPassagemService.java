package com.alga.tdd.passagens;

import com.alga.tdd.exceptions.TipoPassageiroInvalidoException;

public class PrecoPassagemService {

    public double calcular(Passageiro passageiro, Voo voo) {

        return passageiro.getTipo().getCalculadora().calcular(voo);
    }
}
