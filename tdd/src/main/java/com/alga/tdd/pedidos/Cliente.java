package com.alga.tdd.pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Cliente {

    private String nome;
    private String email;
    private String telefone;
}
