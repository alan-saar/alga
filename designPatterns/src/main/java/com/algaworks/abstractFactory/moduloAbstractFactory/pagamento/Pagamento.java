package com.algaworks.abstractFactory.moduloAbstractFactory.pagamento;

import java.math.BigDecimal;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.AlertaDeRiscoException;
import com.algaworks.abstractFactory.moduloAbstractFactory.gestorderisco.GestorDeRisco;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.CapturaNaoAutorizadaException;
import com.algaworks.abstractFactory.moduloAbstractFactory.operadora.Operadora;


public class Pagamento {

    private Operadora operadora;
    private GestorDeRisco gestorDeRisco;

    // aqui que é o pulo do gato
    // No lugar de inserir os objetos que eu quero, eu coloco a fabrica que eu quero
    // e a fábrica que vai instanciiar os objetos
    // a idéia é: agrupar uma família de objetos
    // definição:
    // O padrão abstractFactory fornece uma interface para criar famílias de objetos relacionados ou dependentes sem
    // especificar suas classes concretas
    public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {
        this.operadora = moduloPagamentoFactory.criarOperadora();
        this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor)
            throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }

}
