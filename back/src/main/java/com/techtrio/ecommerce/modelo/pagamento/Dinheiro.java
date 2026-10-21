package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Dinheiro extends FormaPagamento implements ProcessadorPagamento {

    private BigDecimal valorRecebido;

    public Dinheiro(BigDecimal valor, BigDecimal valorRecebido) {
        super(valor);

        if (valorRecebido == null) {
            throw new IllegalArgumentException(
                    "O valor recebido é obrigatório."
            );
        }

        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean processar(BigDecimal valor) {

        if (valorRecebido.compareTo(valor) < 0) {
            return false;
        }

        setSituacao("PAGO");

        return true;
    }

    @Override
    public String getComprovante() {
        return "DINHEIRO-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Dinheiro - Recebido: R$ " + valorRecebido
                + " - Troco: R$ " + calcularTroco();
    }

    @Override
    public String getResumo() {
        return "Pagamento em Dinheiro"
                + " - Valor: R$ " + getValor()
                + " - Recebido: R$ " + valorRecebido
                + " - Troco: R$ " + calcularTroco()
                + " - Situação: " + getSituacao();
    }

    public BigDecimal calcularTroco() {
        return valorRecebido.subtract(getValor());
    }

    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }
}