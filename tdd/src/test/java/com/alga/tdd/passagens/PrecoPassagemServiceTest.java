package com.alga.tdd.passagens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Regras de negócio
 * calcular preço um um vôo para determinadas categorias de passageiros
 *
 * Regras para passageiros
 * passageiro gold:
 * desconto 15% se passagem possuir valor maior que R$500,00, senão desconto de
 * 10%
 *
 * passageiro silver:
 * desconto 10% se passagem possui valor maior que R$700,00, se não desconto de
 * 6%
 *
 */
public class PrecoPassagemServiceTest {

    private PrecoPassagemService pps;

    @BeforeEach
    public void setup() {
        pps = new PrecoPassagemService();
    }

    private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
        double valor = pps.calcular(passageiro, voo);
        assertEquals(esperado, valor);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
        assertValorPassagem(passageiro, voo, 90.0);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
        assertValorPassagem(passageiro, voo, 510.0);

    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilva_ComValorAbaixoDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
        assertValorPassagem(passageiro, voo, 94.0);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilva_ComValorAcimaDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
        assertValorPassagem(passageiro, voo, 720.0);
    }

}
