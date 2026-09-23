
package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class FormaPagamento {

    private BigDecimal valor;
    private LocalDate dataDoPagamento;
    private String situacao;

    public FormaPagamento(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        this.valor = valor;
        this.dataDoPagamento = LocalDate.now();
        this.situacao = "PENDENTE";
    }

    public abstract void processar();

    public abstract String getResumo();

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataDoPagamento() {
        return dataDoPagamento;
    }

    public String getSituacao() {
        return situacao;
    }

    protected void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}