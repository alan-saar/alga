package com.algaworks.strategy.comStrategy.transportadora.service.frete;

import com.algaworks.strategy.comStrategy.transportadora.service.Frete;

public class Normal implements Frete {

    public double calcularPreco(int distancia) {
        return distancia * 1.25 + 10;
    }

}
