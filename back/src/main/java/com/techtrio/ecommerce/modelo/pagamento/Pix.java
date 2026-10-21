package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Pix extends FormaPagamento implements ProcessadorPagamento {

    private String chavePix;

    public Pix(BigDecimal valor, String chavePix) {
        super(valor);

        if (chavePix == null || chavePix.isBlank()) {
            throw new IllegalArgumentException("A chave Pix não pode ser vazia.");
        }

        this.chavePix = chavePix;
    }

    @Override
    public boolean processar(BigDecimal valor) {
        setSituacao("PAGO");

        System.out.println(
                "Enviando cobrança Pix para a chave " + chavePix
        );

        return true;
    }

    @Override
    public String getComprovante() {
        return "PIX-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Pix - chave " + chavePix;
    }

    @Override
    public String getResumo() {
        return "Pagamento via Pix - Valor: R$ " + getValor()
                + " - Chave: " + chavePix
                + " - Situação: " + getSituacao();
    }

    public String getChavePix() {
        return chavePix;
    }
}