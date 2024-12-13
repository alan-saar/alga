package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * ContaBancariaBDDTest
 */
@DisplayName("Conta bancária")
public class ContaBancariaBDDTest {

    @Nested
    @DisplayName("Dado uma conta bancária com saldo de R$10,00")
    class ContaBancariaComSaldo {
        private ContaBancaria conta;

        @BeforeEach
        void setup() {
            conta = new ContaBancaria(BigDecimal.TEN);
        }

        @Nested
        @DisplayName("Quando efetuar o saque com valor menor")
        class SaqueValorMenor {
            private BigDecimal valorSaque = new BigDecimal("9.0");

            @Test
            @DisplayName("Então não deve lançar exception")
            void nadoDeveLancarExceptionNoSaque() {
                assertDoesNotThrow(() -> conta.saque(valorSaque));
            }

            @Test
            @DisplayName("E deve subtrair do saldo")
            void deveSubtrairDoSaldo() {
                conta.saque(valorSaque);
                assertEquals(new BigDecimal("1.0"), conta.saldo());
            }
        }

        @Nested
        @DisplayName("Quando efetuar o saque com valor maior")
        class SaqueComValorMaior {

            private BigDecimal valorSaque = new BigDecimal("20.0");

            @Test
            @DisplayName("Então deve lançar exception")
            void deveFalhar() {
                assertThrows(RuntimeException.class, () -> conta.saque(valorSaque));
            }

            @Test
            @DisplayName("Então não deve alterar saldo")
            void naoDeveAlterarSaldo() {
                try {
                    conta.saque(valorSaque);
                } catch (Exception e) {
                }

                assertEquals(BigDecimal.TEN, conta.saldo());
            }

        }

    }

    @Nested
    @DisplayName("Dado uma conta bancária com saldo de R$10,00")
    class ContaBancariaSemSaldo {
        private ContaBancaria conta;

        @BeforeEach
        void setup() {
            conta = new ContaBancaria(BigDecimal.ZERO);
        }

        @Nested
        @DisplayName("Quando efetuar o saque com valor maior")
        class SaqueComValorMaior {

            private BigDecimal valorSaque = new BigDecimal("1.0");

            @Test
            @DisplayName("Então deve lançar exception")
            void deveFalhar() {
                assertThrows(RuntimeException.class, () -> conta.saque(valorSaque));
            }

        }

    }

}
