package com.algaworks.factoryMethod.cliente.xml;

import java.net.URL;
import java.util.List;
import com.algaworks.factoryMethod.lib.contato.Contato;
import com.algaworks.factoryMethod.lib.contato.Contatos;
import com.thoughtworks.xstream.XStream;

/**
 * ContatosXML
 */
public class ContatosXML implements Contatos {

    private String nomeArquivo;


    public ContatosXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Contato> todos() {

        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[] {"com.algaworks.**",});

        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        URL arquivo = this.getClass().getResource("/" + nomeArquivo);
        return (List<Contato>) xstream.fromXML(arquivo);

    }


}
