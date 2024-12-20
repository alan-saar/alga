package com.algaworks.decorator.cobranca.service;

import com.algaworks.decorator.cobranca.model.CartaoCredito;
import com.algaworks.decorator.cobranca.model.Cliente;

public interface AutorizadorCartaoCredito {

    public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor);

}

