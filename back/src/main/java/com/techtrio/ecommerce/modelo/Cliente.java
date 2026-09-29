package com.techtrio.ecommerce.modelo;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        this.nome = nome.trim();
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório");
        }

        this.cpf = cpf.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail é obrigatório");
        }

        this.email = email.trim();
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }

        this.telefone = telefone.trim();
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("Endereço é obrigatório");
        }

        this.endereco = endereco.trim();
    }

    public String getIdentificacao() {
        return nome + " - CPF: " + cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}