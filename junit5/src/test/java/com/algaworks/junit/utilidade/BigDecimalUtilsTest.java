package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * BigDecimalUtilsTest
 */
public class BigDecimalUtilsTest {

    @Test
    @ParameterizedTest
    @CsvSource({
            // as linhas são separadas pela virgula do java
            "10.00,10",
            "9.00,9.00"
    })
    void iguais(BigDecimal x, BigDecimal y) {
        assertTrue(BigDecimalUtils.iguais(x, y));

    }

    @ParameterizedTest
    // arquivo dentro da pasta test/resources
    @CsvFileSource(resources = "/numeros.csv")
    @Test
    void diferentes(BigDecimal x, BigDecimal y) {
        assertFalse(BigDecimalUtils.iguais(x, y));
    }

}
