package com.techtrio.ecommerce.modelo;

public abstract class Pessoa {

    private String nome;
    private String documento;
    private String email;

    public Pessoa(String nome, String documento, String email) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome não pode ser vazio."
            );
        }

        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException(
                    "O documento não pode ser vazio."
            );
        }

        if (!documento.matches("\\d{11}")) {
            throw new IllegalArgumentException(
                    "O documento deve ter 11 números."
            );
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "O email não pode ser vazio."
            );
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException(
                    "O email é inválido."
            );
        }

        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }
}