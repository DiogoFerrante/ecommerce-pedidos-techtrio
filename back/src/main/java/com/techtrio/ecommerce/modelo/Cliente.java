package com.techtrio.ecommerce.modelo;

public class Cliente extends Pessoa {

    private String telefone;
    private String endereco;

    public Cliente(String nome, String documento, String email,
                   String telefone, String endereco) {
        super(nome, documento, email);

        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("O telefone não pode ser vazio.");
        }

        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("O endereço não pode ser vazio.");
        }

        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getIdentificacao() {
        return getNome() + " - " + getDocumento();
    }
}