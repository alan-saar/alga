package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SimuladorEsperaTest {

    @Test
    @Disabled("Testes podem ser desabilitados quando não são mais aplicáveis")
    void deveEsperarENaoDarTimeout() {
        // esse aqui espera a função terminar totalmente mesmo passando da duração
        // estipulada no teste
        assertTimeout(Duration.ofSeconds(1), () -> {
            SimuladorEspera.esperar(Duration.ofMillis(100));
        });
        // esse aqui fica esperando só o tempo determinado
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            SimuladorEspera.esperar(Duration.ofMillis(200));
        });

    }

}
