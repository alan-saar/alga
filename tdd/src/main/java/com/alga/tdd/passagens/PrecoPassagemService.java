package com.alga.tdd.passagens;

import com.alga.tdd.exceptions.TipoPassageiroInvalidoException;

public class PrecoPassagemService {

    public double calcular(Passageiro passageiro, Voo voo) {
        if (passageiro.getTipo() == TipoPassageiro.GOLD) {
            if (voo.getPreco() > 500) {
                return voo.getPreco() * 0.85;
            }
            return voo.getPreco() * 0.9;
        } else if (passageiro.getTipo() == TipoPassageiro.SILVER) {
            if (voo.getPreco() > 700.00) {
                return voo.getPreco() * 0.9;
            }
            return voo.getPreco() * 0.94;
        }
        throw new TipoPassageiroInvalidoException();
    }
}
