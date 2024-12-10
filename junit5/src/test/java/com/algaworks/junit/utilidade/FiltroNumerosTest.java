package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FiltroNumerosTest {

    @Test
    public void deveRetornarNumerosPares() {
        List<Integer> numeros = List.of(1, 2, 3, 4);
        List<Integer> resultado = FiltroNumeros.numerosPares(numeros);
        List<Integer> numerosParesEsperados = List.of(2, 4);
        // ele verifica a ordem também
        // List<Integer> numerosParesEsperados = List.of(4, 2);
        // é necessário que os itens tenham o método equals
        assertIterableEquals(numerosParesEsperados, resultado);
        // faz com array também
        assertArrayEquals(numerosParesEsperados.toArray(), resultado.toArray());
    }

}
