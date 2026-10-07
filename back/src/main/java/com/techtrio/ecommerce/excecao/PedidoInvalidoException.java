package com.techtrio.ecommerce.excecao;

public class PedidoInvalidoException extends ECommerceException {

    public PedidoInvalidoException(String mensagem) {
        super(mensagem);
    }
}