package com.techtrio.ecommerce.modelo;

public class Cliente {

    private String nome;
    private String documento;
    private String email;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String documento, String email,
                   String telefone, String endereco) {
        setNome(nome);
        setDocumento(documento);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
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

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (!nome.equals(nome.trim())) {
            throw new IllegalArgumentException(
                    "Nome não pode ter espaços nas pontas"
            );
        }

        this.nome = nome;
    }

    public void setDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Documento é obrigatório"
            );
        }

        if (!documento.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "Documento deve conter somente dígitos"
            );
        }

        this.documento = documento;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "E-mail é obrigatório"
            );
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException(
                    "E-mail deve conter @"
            );
        }

        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getIdentificacao() {
        return nome + " (" + documento + ")";
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
