package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

// Gera os display names a partir do nome da classe
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FiltroNumerosTest {

    // Aplicando a nomenclatura BDD (Behavior Driven Development)
    //
    // é composta de três palavaras principais:
    // Given, When, Then
    // Dado, Quando, Então

    @Test
    // public void deve_Retornar_Numeros_Pares() {
    public void Dado_uma_lista_de_numeros_Quando_filtrar_por_pares_Então_deve_retornar_apenas_numeros_pares() {
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

    @Test
    public void Dado_uma_lista_de_numeros_Quando_filtrar_por_impares_Então_deve_retornar_apenas_numeros_impares() {
        List<Integer> numeros = List.of(1, 2, 3, 4);
        List<Integer> resultado = FiltroNumeros.numerosImpares(numeros);
        List<Integer> numerosImparesEsperados = List.of(1, 3);
        assertIterableEquals(numerosImparesEsperados, resultado);
        // faz com array também
        assertArrayEquals(numerosImparesEsperados.toArray(), resultado.toArray());
    }

}
