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

    public abstract Frete obterFrete();

}
