package com.algaworks.observer.comObserver.notifier;

import java.util.List;

import com.algaworks.observer.comObserver.listeners.Listener;
import com.algaworks.observer.comObserver.model.Lancamento;

public interface Notificador {

    public void registrarListener(Listener listener);

    public void removerListener(Listener listener);

    public void notificarListeners();

    public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos);

    public List<Lancamento> getLancamentosVencidos();

}
