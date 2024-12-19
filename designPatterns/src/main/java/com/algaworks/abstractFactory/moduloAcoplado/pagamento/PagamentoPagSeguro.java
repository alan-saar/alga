package com.algaworks.abstractFactory.moduloAcoplado.pagamento;

import java.math.BigDecimal;
import com.algaworks.abstractFactory.moduloAcoplado.gestorderisco.AlertaDeRiscoException;
import com.algaworks.abstractFactory.moduloAcoplado.gestorderisco.FControl;
import com.algaworks.abstractFactory.moduloAcoplado.operadora.CapturaNaoAutorizadaException;
import com.algaworks.abstractFactory.moduloAcoplado.operadora.Cielo;


public class PagamentoPagSeguro {

    private Cielo operadora;
    private FControl gestorDeRisco;

    public PagamentoPagSeguro(Cielo operadora, FControl gestorDeRisco) {
        this.operadora = operadora;
        this.gestorDeRisco = gestorDeRisco;
    }

    public Long autorizar(String cartao, BigDecimal valor)
            throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }

}
