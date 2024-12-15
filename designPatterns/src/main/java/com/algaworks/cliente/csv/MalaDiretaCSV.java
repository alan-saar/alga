package com.algaworks.cliente.csv;

import com.algaworks.lib.contato.Contatos;
import com.algaworks.lib.maladireta.MalaDireta;

/**
 * MalaDiretaCSV
 */
public class MalaDiretaCSV extends MalaDireta {

  private String nomeArquivo;

  public MalaDiretaCSV(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }


  @Override
  protected Contatos criarContatos() {
    return new ContatosCSV(nomeArquivo);
  }


}
