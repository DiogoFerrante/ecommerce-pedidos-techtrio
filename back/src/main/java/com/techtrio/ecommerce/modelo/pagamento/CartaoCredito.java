package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

import com.techtrio.ecommerce.excecao.PagamentoRecusadoException;

public class CartaoCredito extends FormaPagamento implements ProcessadorPagamento {

    private String numero;
    private String nomeTitular;
    private String bandeira;
    private int parcelas;

    public CartaoCredito(BigDecimal valor, String numero, String nomeTitular,
                         String bandeira, int parcelas) {
        super(valor);

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("O número do cartão não pode ser vazio.");
        }

        if (nomeTitular == null || nomeTitular.isBlank()) {
            throw new IllegalArgumentException("O nome do titular não pode ser vazio.");
        }

        if (bandeira == null || bandeira.isBlank()) {
            throw new IllegalArgumentException("A bandeira do cartão é obrigatória.");
        }

        if (parcelas <= 0) {
            throw new IllegalArgumentException("A quantidade de parcelas deve ser maior que zero.");
        }

        if (parcelas > 12) {
            throw new IllegalArgumentException("O cartão permite no máximo 12 parcelas.");
        }

        BigDecimal valorParcela = valor.divide(
                BigDecimal.valueOf(parcelas),
                2,
                java.math.RoundingMode.HALF_UP
        );

        if (valorParcela.compareTo(new BigDecimal("10.00")) < 0) {
            throw new IllegalArgumentException(
                    "O valor mínimo da parcela é R$ 10,00."
            );
        }

        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.bandeira = bandeira;
        this.parcelas = parcelas;
    }

    @Override
    public boolean processar(BigDecimal valor)
            throws PagamentoRecusadoException {

        if ("0000".equals(numero)) {
            throw new PagamentoRecusadoException(
                    "Cartão de Crédito",
                    "Cartão recusado pela operadora."
            );
        }

        setSituacao("PAGO");

        System.out.println(
                "Processando cartão " + bandeira +
                " em " + parcelas + "x."
        );

        return true;
    }

    @Override
    public String getComprovante() {
        return "CARTAO-" + bandeira + "-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Cartão de Crédito - " + bandeira
                + " - " + parcelas + "x";
    }

    @Override
    public String getResumo() {
        return "Pagamento via Cartão de Crédito"
                + " - Valor: R$ " + getValor()
                + " - Bandeira: " + bandeira
                + " - Parcelas: " + parcelas
                + " - Situação: " + getSituacao();
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getBandeira() {
        return bandeira;
    }

    public int getParcelas() {
        return parcelas;
    }
}