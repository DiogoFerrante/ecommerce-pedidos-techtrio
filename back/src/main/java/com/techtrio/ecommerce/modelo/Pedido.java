package com.techtrio.ecommerce.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private String numero;
    private Cliente cliente;
    private String data;
    private String situacao;
    private List<ItemPedido> itens;

    public Pedido(String numero, Cliente cliente, String data, String situacao) {
        setNumero(numero);
        setCliente(cliente);
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
        return Collections.unmodifiableList(itens);
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número do pedido é obrigatório");
        }

        this.numero = numero.trim();
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório");
        }

        this.cliente = cliente;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            throw new IllegalArgumentException("Item do pedido não pode ser nulo");
        }

        itens.add(item);
    }

    public double calcularValorTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
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
