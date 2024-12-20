package com.algaworks.strategy.comStrategy.transportadora.service;

import com.algaworks.strategy.comStrategy.transportadora.service.frete.Normal;
import com.algaworks.strategy.comStrategy.transportadora.service.frete.Sedex;

public enum TipoFrete {

    NORMAL {
        @Override
        public Frete obterFrete() {
            return new Normal();
        }
    },
    SEDEX {
        @Override
        public Frete obterFrete() {
            return new Sedex();
        }
    };

    // ao colocar um abstract no enum significa que cada enum terá que implementar esse método
    public abstract Frete obterFrete();

}
