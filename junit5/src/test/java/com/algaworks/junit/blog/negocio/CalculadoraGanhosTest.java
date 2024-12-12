package com.algaworks.junit.blog.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;

/**
 * CalculadoraGanhosTest
 */
public class CalculadoraGanhosTest {

    static CalculadoraGanhos calculadora;
    Editor autor;
    Post post;

    // beforeall prcisa ser estático
    @BeforeAll
    static void initAll() {
        System.out.println("Antes de todos os testes");
        calculadora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
    }

    @BeforeEach
    void init() {
        System.out.println("Antes de cada teste");
        autor = new Editor(1L, "Alan", "fulando@detal", new BigDecimal(5), true);

        post = new Post(1L, "Ecossistema JAva", "O ecossistema do Java é muito maduro", autor,
                "ecossistma-java-abc123", null, false, false);
    }

    @AfterEach
    void afterEach() {
        System.out.println("depois de cada teste");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Depois de todos os testes");
    }

    @Test
    public void deveCalcularGanhos() {

        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    public void deveCalcularGanhosSemPremium() {
        autor.setPremium(false);

        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal("35"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }
}
