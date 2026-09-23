
package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {

    private String codigoBarras;

    public Boleto(BigDecimal valor, String codigoBarras) {
        super(valor);

        if (codigoBarras == null || codigoBarras.isBlank()) {
            throw new IllegalArgumentException("O código de barras não pode ser vazio.");
        }

        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processar() {
        setSituacao("PAGO");
    }

    @Override
    public String getResumo() {
        return "Pagamento via Boleto - Valor: R$ " + getValor()
                + " - Código: " + codigoBarras
                + " - Situação: " + getSituacao();
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
}