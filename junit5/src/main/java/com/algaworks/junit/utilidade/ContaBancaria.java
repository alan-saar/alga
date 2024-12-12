package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        // TODO: 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma
        // IllegalArgumentException
        if (saldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("saldo deve ser maior que zero");
        }
        this.saldo = saldo;
        // TODO: 2 - pode ser zero ou negativo
    }

    public void saque(BigDecimal valor) {
        // TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja,
        // deve lançar uma IllegalArgumentException
        if (!(valor.compareTo(BigDecimal.ZERO) > 0)) {
            throw new IllegalArgumentException("saque deve ser maior que zero");
        }
        // TODO 2 - Deve subtrair o valor do saldo
        // TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
        if (saldo.subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("saque deve ser maior que o saldo");
        }
        saldo = saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor) {
        if (!(valor.compareTo(BigDecimal.ZERO) > 0)) {
            throw new IllegalArgumentException("depósito deve ser maior que zero");
        }
        // TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja,
        // deve lançar uma IllegalArgumentException
        // TODO 2 - Deve adicionar o valor ao saldo
        saldo = saldo.add(valor);
    }

    public BigDecimal saldo() {
        // TODO 1 - retornar saldo
        return saldo;
    }
}
