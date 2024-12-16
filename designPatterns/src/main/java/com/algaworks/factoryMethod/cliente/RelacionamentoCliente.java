package com.algaworks.factoryMethod.cliente;

import javax.swing.JOptionPane;
import com.algaworks.factoryMethod.cliente.csv.MalaDiretaCSV;
import com.algaworks.factoryMethod.lib.maladireta.MalaDireta;

/**
 * RelacionamentoCliente
 */
public class RelacionamentoCliente {

    public static void run() {

        MalaDireta malaDireta = new MalaDiretaCSV("contatos.csv");
        // MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
        String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do email:");

        boolean status = malaDireta.enviarEmail(mensagem);

        JOptionPane.showConfirmDialog(null, "Emails enviados: " + status);

    }


}
