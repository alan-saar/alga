package com.algaworks.maladireta;

import javax.swing.JOptionPane;

/**
 * Principal
 */
public class Principal {

  public static void run() {

    MalaDireta malaDireta = new MalaDireta();
    String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem para o email");

    boolean status = malaDireta.enviarEmail("contatos.csv", mensagem);
    System.out.println(status);

  }
}
