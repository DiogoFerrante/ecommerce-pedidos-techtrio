package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {

    private String numeroMascarado;
    private String bandeira;
    private int quantidadeDeParcelas;

    public CartaoCredito(BigDecimal valor,
                         String numeroMascarado,
                         String bandeira,
                         int quantidadeDeParcelas) {

        super(valor);

        setNumeroMascarado(numeroMascarado);
        setBandeira(bandeira);
        setQuantidadeDeParcelas(quantidadeDeParcelas);
    }

    public String getNumeroMascarado() {
        return numeroMascarado;
    }

    public String getBandeira() {
        return bandeira;
    }

    public int getQuantidadeDeParcelas() {
        return quantidadeDeParcelas;
    }

    public void setNumeroMascarado(String numeroMascarado) {
        if (numeroMascarado == null ||
                numeroMascarado.isBlank()) {

            throw new IllegalArgumentException(
                    "Número do cartão é obrigatório"
            );
        }

        this.numeroMascarado = numeroMascarado;
    }

    public void setBandeira(String bandeira) {
        if (bandeira == null || bandeira.isBlank()) {
            throw new IllegalArgumentException(
                    "Bandeira do cartão é obrigatória"
            );
        }

        this.bandeira = bandeira;
    }

    public void setQuantidadeDeParcelas(int quantidadeDeParcelas) {

        if (quantidadeDeParcelas <= 0) {
            throw new IllegalArgumentException(
                    "Quantidade de parcelas deve ser positiva"
            );
        }

        if (quantidadeDeParcelas > 12) {
            throw new IllegalArgumentException(
                    "Cartão não pode ter mais de 12 parcelas"
            );
        }

        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }

    @Override
    public boolean processar() {
        System.out.println(
                "Processando cartão " +
                numeroMascarado +
                " em " +
                quantidadeDeParcelas +
                " parcelas"
        );

        return true;
    }

    @Override
    public String getResumo() {
        return super.getResumo() +
                " (" + bandeira +
                ", " + quantidadeDeParcelas +
                " parcelas)";
    }
}