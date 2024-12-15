package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Condition;

import static org.assertj.core.api.Assertions.*;
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

        // assertEquals("Bom dia", saudacao, "Saudação incorreta");

        // mesmo assert com o AssertJ
        // coloquei os outros is aqui para efeito de ver como são encadeadas
        assertThat(saudacao)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Bom dia");
        // .withFailMessage("Saudaçao incorreta");

        // outra maneira de fazer
        String saudacaoCorreta = "Bom dia";
        assertThat(saudacao)
                .as("Validando se a saudação é %s", saudacaoCorreta)
                .withFailMessage("Erro: Saudação incorreta! Resuldado: %s", saudacao)
                .isEqualTo(saudacaoCorreta);

        // terceira maneira de fazer
        Condition<String> bomDia = new Condition<>((s) -> s.equals(saudacaoCorreta), "igual a %s", saudacaoCorreta);
        assertThat(saudacao).is(bomDia);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "dev")
    public void deveLancarException() {
        int horaInvalida = -10;
        // Executable chamadaDoMetodoInvalida = () -> SaudacaoUtil.saudar(horaInvalida);

        // var exception = assertThrows(IllegalArgumentException.class, () -> {
        // SaudacaoUtil.saudar(horaInvalida);
        // });

        // @formatter:off
        // var exception = assertThrows(RuntimeException.class, chamadaDoMetodoInvalida);
        // assertEquals("Hora inválida", exception.getMessage(), "deve lançar a mensagem da exception corretamente");
        // @formatter:on

        // mesma asserção com o assertj
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> SaudacaoUtil.saudar(horaInvalida))
                .satisfies(e -> assertThat(e).hasMessage("Hora inválida"));
        // outro jeito de fazer
        assertThatThrownBy(() -> SaudacaoUtil.saudar(horaInvalida))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hora inválida");

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
