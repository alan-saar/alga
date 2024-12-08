package com.alga.tdd.passagens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Voo {

    private String origem;
    private String destino;
    private double preco;

}
