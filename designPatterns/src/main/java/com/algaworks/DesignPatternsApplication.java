package com.algaworks;

// import org.springframework.boot.SpringApplication;
import com.algaworks.factoryMethod.cliente.RelacionamentoCliente;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DesignPatternsApplication.class, args);

        // mala direta sem o desig pattern
        // com.algaworks.factoryMethod.maladireta.Principal.run();

        // com factory method
        RelacionamentoCliente.run();
    }

}
