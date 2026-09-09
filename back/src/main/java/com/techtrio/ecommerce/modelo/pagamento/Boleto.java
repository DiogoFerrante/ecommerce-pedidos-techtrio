package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto extends FormaPagamento {

    private String codigoDeBarras;
    private LocalDate dataDeVencimento;

    public Boleto(BigDecimal valor,
                   String codigoDeBarras,
                   LocalDate dataDeVencimento) {

        super(valor);

        setCodigoDeBarras(codigoDeBarras);
        setDataDeVencimento(dataDeVencimento);
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        if (codigoDeBarras == null ||
                codigoDeBarras.isBlank()) {

            throw new IllegalArgumentException(
                    "Código de barras é obrigatório"
            );
        }

        this.codigoDeBarras = codigoDeBarras;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        if (dataDeVencimento == null) {
            throw new IllegalArgumentException(
                    "Data de vencimento é obrigatória"
            );
        }

        if (dataDeVencimento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Boleto não pode estar vencido"
            );
        }

        this.dataDeVencimento = dataDeVencimento;
    }

    @Override
    public boolean processar() {
        System.out.println(
                "Processando boleto " + codigoDeBarras
        );

        return true;
    }

    @Override
    public String getResumo() {
        return super.getResumo() +
                " (vencimento " + dataDeVencimento + ")";
    }
}