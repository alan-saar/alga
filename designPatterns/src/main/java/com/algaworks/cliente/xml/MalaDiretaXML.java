package com.algaworks.cliente.xml;

import com.algaworks.lib.contato.Contatos;
import com.algaworks.lib.maladireta.MalaDireta;

/**
 * MalaDiretaCSV
 */
public class MalaDiretaXML extends MalaDireta {

    private String nomeArquivo;

    public MalaDiretaXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }


    @Override
    protected Contatos criarContatos() {
        return new ContatosXML(nomeArquivo);
    }


}
