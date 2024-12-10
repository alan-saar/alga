package com.alga.tdd.exceptions;

public class StatusPedidoInvalidoException extends RuntimeException {

    public StatusPedidoInvalidoException() {
        super("Status pedido inválido para pagamento");
    }
}
