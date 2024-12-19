package com.algaworks.observer.semObserver.senders;

import java.util.List;

import com.algaworks.observer.semObserver.model.Lancamento;

public class EnviadorSMS {

    public void enviar(List<Lancamento> lancamentosVencidos) {
        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
        }
    }

}
