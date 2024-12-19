package com.algaworks.abstractFactory.moduloAbstractFactory.pagamento;

import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.GestorDeRisco;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.Operadora;

public interface ModuloPagamentoFactory {

    public Operadora criarOperadora();

    public GestorDeRisco criarGestorDeRisco();

}
