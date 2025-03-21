package com.algaworks.observer.comObserver.listeners;

import java.util.List;

import com.algaworks.observer.comObserver.model.Lancamento;
import com.algaworks.observer.comObserver.notifier.Notificador;

public class EmailListener implements Listener {

    private Notificador notificador;

    public EmailListener(Notificador notificador) {
        this.notificador = notificador;
        this.notificador.registrarListener(this);
    }

    @Override
    public void atualizar() {
        List<Lancamento> lancamentosVencidos = this.notificador.getLancamentosVencidos();

        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando e-mail para " + lancamento.getPessoa().getEmail());
        }

        // this.notificador.removerListener(this);
    }

}
