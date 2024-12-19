package com.algaworks.abstractFactory.moduloAbstractFactory.pagamento.paypal;

import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.GestorDeRisco;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.clearsale.ClearSale;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.Operadora;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.redecard.Redecard;
import com.algaworks.abstractFactory.moduloAbstractFactory.pagamento.ModuloPagamentoFactory;

public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new Redecard();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new ClearSale();
    }

}
