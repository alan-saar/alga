package com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco;

import java.math.BigDecimal;

public interface GestorDeRisco {

    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException;

}
