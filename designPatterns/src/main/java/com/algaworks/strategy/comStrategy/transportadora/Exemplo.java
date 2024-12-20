package com.algaworks.strategy.comStrategy.transportadora;

import java.util.Scanner;

import com.algaworks.strategy.comStrategy.transportadora.service.Frete;
import com.algaworks.strategy.comStrategy.transportadora.service.TipoFrete;

public class Exemplo {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe a distância: ");
            int distancia = entrada.nextInt();
            System.out.print("Qual o tipo de frete (1) Normal, (2) Sedex: ");
            int opcaoFrete = entrada.nextInt();
            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete - 1];

            // aqui o padrão strategy é implementado
            // a função é retornada por um factory no enum
            Frete frete = tipoFrete.obterFrete();
            double preco = frete.calcularPreco(distancia);
            System.out.printf("O valor total é de R$%.2f", preco);
        }
    }

}
