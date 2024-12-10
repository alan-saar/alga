package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SaudacaoTest {

  @Test
  public void saudar() {
    String saudacao = SaudacaoUtil.saudar(9);
    System.out.println(saudacao);

    assertTrue(saudacao.equals("Bom dia"));
  }

}
