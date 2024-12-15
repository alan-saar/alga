package com.algaworks;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsApplication {

  public static void main(String[] args) {
    // SpringApplication.run(DesignPatternsApplication.class, args);

    // MalaDireta malaDireta = new MalaDireta();
    // String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem para
    // o email");
    //
    // boolean status = malaDireta.enviarEmail("contatos.csv", mensagem);
    com.algaworks.maladireta.Principal.run();

  }

}
