
package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {

    private String chavePix;

    public Pix(BigDecimal valor, String chavePix) {
        super(valor);

        if (chavePix == null || chavePix.isBlank()) {
            throw new IllegalArgumentException("A chave Pix não pode ser vazia.");
        }

        this.chavePix = chavePix;
    }

    @Override
    public void processar() {
        setSituacao("PAGO");
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