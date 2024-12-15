package com.algaworks.cliente;

import javax.swing.JOptionPane;
import com.algaworks.cliente.csv.MalaDiretaCSV;
import com.algaworks.lib.maladireta.MalaDireta;

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
