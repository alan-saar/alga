package com.algaworks.junit.blog.utilidade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

/**
 * ConversorSlugTest
 */
public class ConversorSlugTest {

    @Test
    void deveConverterJuntoComCodigo() {
        // o mocked static deve estar dentro de um contexto try with resources
        // mas consegui fazer funcionar fora
        // @formatter:off
        // try (MockedStatic<GeradorCodigo> mockEstatico = Mockito.mockStatic(GeradorCodigo.class)) {
        // }
        // @formatter:on
        MockedStatic<GeradorCodigo> mockEstatico = Mockito.mockStatic(GeradorCodigo.class);
        mockEstatico.when(GeradorCodigo::gerar)
                .thenReturn("123456");
        String slug = ConversorSlug.converterJuntoComCodigo("hello world");

        assertEquals("hello-world-123456", slug);

    }
}
