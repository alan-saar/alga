package com.algaworks.proxy.semProxy;


import com.algaworks.proxy.semProxy.contatos.ContatosXML;
import com.algaworks.proxy.semProxy.repository.Contatos;

public class BuscaContato {

    public static void main(String[] args) {
        Contatos contatos = new ContatosXML("contatos1.xml", "contatos2.xml");
        String nome = contatos.buscarPor("jose@email.com");

        System.out.println(nome);
    }

}
