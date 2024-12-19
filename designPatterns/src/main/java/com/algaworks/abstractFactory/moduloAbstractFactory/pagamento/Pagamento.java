package com.algaworks.abstractFactory.moduloAbstractFactory.pagamento;

import java.math.BigDecimal;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.AlertaDeRiscoException;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.GestorDeRisco;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.CapturaNaoAutorizadaException;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.Operadora;


public class Pagamento {

    private Operadora operadora;
    private GestorDeRisco gestorDeRisco;

    public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {
        this.operadora = moduloPagamentoFactory.criarOperadora();
        this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor)
            throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }

}
