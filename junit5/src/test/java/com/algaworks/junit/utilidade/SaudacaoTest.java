package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Testes no utilitário Saudação")
public class SaudacaoTest {

    // Padrão triple A
    // Arrange
    // Act
    // Assert

    @Test
    @DisplayName("Deve saudar com bom dia")
    public void saudar() {
        // arrange (as variáveis que voce quem que declarar)
        int horaValida = 9;

        // act
        String saudacao = SaudacaoUtil.saudar(horaValida);

        // assert
        System.out.println(saudacao);

        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "dev")
    public void deveLancarException() {
        int horaInvalida = -10;
        Executable chamadaDoMetodoInvalida = () -> SaudacaoUtil.saudar(horaInvalida);

        // var exception = assertThrows(IllegalArgumentException.class, () -> {
        // SaudacaoUtil.saudar(horaInvalida);
        // });

        var exception = assertThrows(RuntimeException.class, chamadaDoMetodoInvalida);
        assertEquals("Hora inválida", exception.getMessage(), "deve lançar a mensagem da exception corretamente");

    }

    @Test
    public void dadoUmaHoraValidaQuandoSaudarEntaoNaoDeveLancarException() {
        // assumptions = suposições
        // Faz esse teste somente em um caso específico, como por exemplo uma variavel
        // de ambiente estar setada
        Assumptions.assumeTrue("PROD" == System.getenv("ENV"),
                () -> "Abortando teste: Não deve ser executado em prod");
        assertDoesNotThrow(() -> {
            SaudacaoUtil.saudar(0);
        });
    }

    // vai rodar um teste para cada valor
    @ParameterizedTest
    @ValueSource(ints = { 5, 6, 7, 8, 9, 10, 11 })
    public void DadoHorarioMatinalEntaoDeveRetornarBomDia(int hora) {
        String saudacao = SaudacaoUtil.saudar(hora);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

}
