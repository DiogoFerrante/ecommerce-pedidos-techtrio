package com.techtrio.ecommerce.modelo;

import java.math.BigDecimal;

public class Produto {

    private String codigo;
    private String nome;
    private BigDecimal preco;
    private int quantidadeEmEstoque;

    public Produto(String codigo, String nome, BigDecimal preco, int quantidadeEmEstoque) {
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código é obrigatório");
        }

        this.codigo = codigo.trim();
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (!nome.equals(nome.trim())) {
            throw new IllegalArgumentException("Nome não pode ter espaços nas pontas");
        }

        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }

        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException(
                    "Quantidade em estoque não pode ser negativa"
            );
        }

        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public boolean temEstoqueDisponivel(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                    "Quantidade deve ser maior que zero"
            );
        }

        return quantidadeEmEstoque >= quantidade;
    }

    public void baixarEstoque(int quantidade) {
        if (!temEstoqueDisponivel(quantidade)) {
            throw new IllegalArgumentException(
                    "Estoque insuficiente"
            );
        }

        quantidadeEmEstoque -= quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }
}
