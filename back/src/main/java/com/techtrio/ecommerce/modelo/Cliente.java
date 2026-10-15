package com.techtrio.ecommerce.modelo;

public class Cliente extends Pessoa {

    private String telefone;
    private String endereco;

    public Cliente(String nome, String documento, String email,
                   String telefone, String endereco) {

        super(nome, documento, email);

        setTelefone(telefone);
        setEndereco(endereco);
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", documento='" + getDocumento() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}