package com.techtrio.ecommerce.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String numero;
    private Cliente cliente;
    private String data;
    private String situacao;
    private List<ItemPedido> itens;

    public Pedido(String numero, Cliente cliente, String data, String situacao) {
        this.numero = numero;
        this.cliente = cliente;
        this.data = data;
        this.situacao = situacao;
        this.itens = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total = total + item.calcularSubtotal();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero='" + numero + '\'' +
                ", cliente=" + cliente.getIdentificacao() +
                ", data='" + data + '\'' +
                ", situacao='" + situacao + '\'' +
                ", itens=" + itens.size() +
                ", valorTotal=" + calcularValorTotal() +
                '}';
    }
}