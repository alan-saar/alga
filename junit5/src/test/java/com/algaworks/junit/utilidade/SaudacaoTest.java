package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class SaudacaoTest {

    @Test
    public void saudar() {
        String saudacao = SaudacaoUtil.saudar(9);
        System.out.println(saudacao);

        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "dev")
    public void deveLancarException() {
        var exception = assertThrows(IllegalArgumentException.class, () -> {
            SaudacaoUtil.saudar(-10);
        });

        assertEquals("Hora inválida", exception.getMessage(), "deve lançar a mensagem da exception corretamente");

    }

    @Test
    public void naoDeveLancarException() {
        // assumptions = suposições
        // Faz esse teste somente em um caso específico, como por exemplo uma variavel
        // de ambiente estar setada
        Assumptions.assumeTrue("PROD" == System.getenv("ENV"),
                () -> "Abortando teste: Não deve ser executado em prod");
        assertDoesNotThrow(() -> {
            SaudacaoUtil.saudar(0);
        });
    }

}
