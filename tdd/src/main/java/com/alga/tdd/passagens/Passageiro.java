package com.alga.tdd.passagens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Passageiro {

    private String nome;
    private TipoPassageiro tipo;

}
