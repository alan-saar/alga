package com.algaworks.abstractFactory.moduloAcoplado.gestorderisco;

import java.math.BigDecimal;

public class FControl {

    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
        if (cartao.startsWith("7777")) {
            throw new AlertaDeRiscoException("Cartão suspeito.");
        }
    }

}
