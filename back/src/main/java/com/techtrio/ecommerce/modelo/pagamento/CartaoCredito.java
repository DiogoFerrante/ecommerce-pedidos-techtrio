
package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {

    private String numero;
    private String nomeTitular;

    public CartaoCredito(BigDecimal valor, String numero, String nomeTitular) {
        super(valor);

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("O número do cartão não pode ser vazio.");
        }

        if (nomeTitular == null || nomeTitular.isBlank()) {
            throw new IllegalArgumentException("O nome do titular não pode ser vazio.");
        }

        this.numero = numero;
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void processar() {
        setSituacao("PAGO");
    }

    @Override
    public String getResumo() {
        return "Pagamento via Cartão de Crédito - Valor: R$ " + getValor()
                + " - Titular: " + nomeTitular
                + " - Situação: " + getSituacao();
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }
}