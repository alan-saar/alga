package com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.fcontrol;

import java.math.BigDecimal;

import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.AlertaDeRiscoException;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.GestorDeRisco;

public class FControl implements GestorDeRisco {

    @Override
    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
        if (cartao.startsWith("7777")) {
            throw new AlertaDeRiscoException("Cartão suspeito.");
        }
    }

}
