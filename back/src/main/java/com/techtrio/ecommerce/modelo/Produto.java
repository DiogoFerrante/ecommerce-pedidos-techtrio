package com.techtrio.ecommerce.modelo;


public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;
    private boolean ativo;

    public Produto(){
        this.ativo = true;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public boolean isAtivo(){
        return ativo;
    }

    public boolean temEstoqueDisponivel(int quantidadeDesejada){
        return ativo && quantidadeEmEstoque >= quantidadeDesejada;
    }

    @Override
    public String toString(){
        return String.format("[%s] %s %s - R$ %.2f (%d em estoque)", this.codigo, this.nome, this.descricao, this.preco, this.quantidadeEmEstoque);
    }   

    public void baixarEstoque(int quantidade){
        this.quantidadeEmEstoque = this.quantidadeEmEstoque - quantidade;
    }

    public Produto( String codigo, String nome, String descricao, double preco, int quantidadeEmEstoque){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.ativo = true;
    }
}
