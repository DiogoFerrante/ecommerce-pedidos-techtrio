package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento implements ProcessadorPagamento {

    private String codigoBarras;

    public Boleto(BigDecimal valor, String codigoBarras) {
        super(valor);

        if (codigoBarras == null || codigoBarras.isBlank()) {
            throw new IllegalArgumentException(
                    "O código de barras não pode ser vazio."
            );
        }

        this.codigoBarras = codigoBarras;
    }

    @Override
    public boolean processar(BigDecimal valor) {
        System.out.println("Gerando boleto de R$ " + valor);
        return false;
    }

    @Override
    public String getComprovante() {
        return "BOLETO-" + codigoBarras;
    }

    @Override
    public String getDescricao() {
        return "Boleto - código " + codigoBarras;
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