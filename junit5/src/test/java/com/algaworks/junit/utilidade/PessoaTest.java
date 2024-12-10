package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * PessoaTest
 */
public class PessoaTest {

    @Test
    void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Ras", "Tafari");

        // se colocar essas duas asserções separadas ele vai parar na primeira que
        // falhar e não vai fazer a próxima
        assertAll("Asserções de pessoa",
                () -> assertEquals("Ras", pessoa.getNome()),
                () -> assertEquals("Tafari", pessoa.getSobrenome()));

    }
}
