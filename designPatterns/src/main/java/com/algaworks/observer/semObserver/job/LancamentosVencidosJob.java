package com.algaworks.observer.semObserver.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.algaworks.observer.semObserver.model.Lancamento;
import com.algaworks.observer.semObserver.repository.Lancamentos;
import com.algaworks.observer.semObserver.senders.EnviadorEmail;
import com.algaworks.observer.semObserver.senders.EnviadorSMS;

public class LancamentosVencidosJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        Lancamentos lancamentos = (Lancamentos) jobDataMap.get("lancamentos");
        List<Lancamento> lancamentosVencidos = lancamentos.todosVencidos();

        EnviadorEmail enviadorEmail = (EnviadorEmail) jobDataMap.get("enviadorEmail");
        EnviadorSMS enviadorSms = (EnviadorSMS) jobDataMap.get("enviadorSms");
        enviadorEmail.enviar(lancamentosVencidos);
        enviadorSms.enviar(lancamentosVencidos);
    }

}
