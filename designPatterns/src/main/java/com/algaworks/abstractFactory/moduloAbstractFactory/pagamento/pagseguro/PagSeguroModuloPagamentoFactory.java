package com.algaworks.abstractFactory.moduloAbstractFactory.pagamento.pagseguro;

import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.GestorDeRisco;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.fcontrol.FControl;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.Operadora;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.cielo.Cielo;
import com.algaworks.abstractFactory.moduloAbstractFactory.pagamento.ModuloPagamentoFactory;

public class PagSeguroModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new Cielo();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new FControl();
    }

}
