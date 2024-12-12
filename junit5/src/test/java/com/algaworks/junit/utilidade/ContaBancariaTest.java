package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ContaBancariaTest
 */
public class ContaBancariaTest {

    ContaBancaria cb;

    @BeforeEach
    void setup() {
        cb = new ContaBancaria(BigDecimal.valueOf(100l));
    }

    @Test
    void deveCriarUmaContaBancariaComSaldoPositivo() {
        cb = new ContaBancaria(BigDecimal.valueOf(100l));

    }

    @Test
    void deveLancarUmaExecaoAoCriarUmaContaComSaldoNegativo() {
        assertThrows(RuntimeException.class, () -> {
            cb = new ContaBancaria(new BigDecimal(-99l));
        });

    }

    @Test
    void deveLancarUmaExcecaoaoAoSacarValorNegativo() {
        assertAll("Asserções negativas saque",
                () -> assertThrows(RuntimeException.class, () -> {
                    cb.saque(BigDecimal.valueOf(-0l));
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    cb.saque(BigDecimal.valueOf(-10l));
                }));
    }

    @Test
    void deveLancarUmaExcecaoaoAoDepositarValorNegativo() {
        assertAll("Asserções negativas deposito",
                () -> assertThrows(RuntimeException.class, () -> {
                    cb.deposito(BigDecimal.valueOf(-0l));
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    cb.deposito(BigDecimal.valueOf(-10l));
                }));
    }

    @Test
    void deveSubtrairValorDoSaldoAoSacar() {
        cb.saque(BigDecimal.valueOf(10l));
        assertEquals(BigDecimal.valueOf(90l), cb.saldo());
    }

    @Test
    void deveAdicionarValorDoSaldoAoDepositar() {
        cb.deposito(BigDecimal.valueOf(10l));
        assertEquals(BigDecimal.valueOf(110l), cb.saldo());
    }

}
