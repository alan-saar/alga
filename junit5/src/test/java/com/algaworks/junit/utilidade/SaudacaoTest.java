package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SaudacaoTest {

  @Test
  public void saudar() {
    String saudacao = SaudacaoUtil.saudar(9);
    System.out.println(saudacao);

    assertEquals("Bom dia", saudacao, "Saudação incorreta");
  }

  @Test
  public void deveLancarException() {
    var exception = assertThrows(IllegalArgumentException.class, () -> {
      SaudacaoUtil.saudar(-10);
    });

    assertEquals("Hora inválida", exception.getMessage(), "deve lançar a mensagem da exception corretamente");

  }

  public void naoDeveLancarException() {
    assertDoesNotThrow(() -> {
      SaudacaoUtil.saudar(0);
    });
  }

}
