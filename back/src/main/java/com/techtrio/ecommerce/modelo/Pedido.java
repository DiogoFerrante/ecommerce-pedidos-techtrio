package com.techtrio.ecommerce.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.techtrio.ecommerce.excecao.EstoqueInsuficienteException;
import com.techtrio.ecommerce.excecao.PagamentoRecusadoException;
import com.techtrio.ecommerce.excecao.PedidoInvalidoException;
import com.techtrio.ecommerce.modelo.pagamento.FormaPagamento;
import com.techtrio.ecommerce.modelo.pagamento.ProcessadorPagamento;

public class Pedido {

    private String numero;
    private final Cliente cliente;
    private String data;
    private String situacao;

    private final List<ItemPedido> itens;

    private FormaPagamento formaPagamento;

    public Pedido(String numero, Cliente cliente, String data, String situacao) {

        setNumero(numero);

        if (cliente == null) {
            throw new IllegalArgumentException(
                    "Pedido exige um cliente"
            );
        }

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

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void setNumero(String numero) {

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException(
                    "Número do pedido é obrigatório"
            );
        }

        this.numero = numero.trim();
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void adicionarItem(Produto produto, int quantidade)
            throws EstoqueInsuficienteException, PedidoInvalidoException {

        if ("PAGO".equals(situacao)) {
            throw new PedidoInvalidoException(
                    "Não é possível adicionar itens a um pedido já pago"
            );
        }

        if (produto == null) {
            throw new IllegalArgumentException(
                    "Produto é obrigatório"
            );
        }

        produto.baixarEstoque(quantidade);

        ItemPedido item = new ItemPedido(
                produto,
                quantidade,
                produto.getPreco()
        );

        itens.add(item);
    }

    public void adicionarItem(Produto produto)
            throws EstoqueInsuficienteException, PedidoInvalidoException {

        adicionarItem(produto, 1);
    }

    public void pagar(ProcessadorPagamento processador)
            throws PagamentoRecusadoException, PedidoInvalidoException {

        if ("PAGO".equals(situacao)) {
            throw new PedidoInvalidoException(
                    "Pedido já está pago"
            );
        }

        if (itens.isEmpty()) {
            throw new PedidoInvalidoException(
                    "Pedido sem itens não pode ser pago"
            );
        }

        if (processador == null) {
            throw new IllegalArgumentException(
                    "Processador de pagamento é obrigatório"
            );
        }

        BigDecimal valorTotal = calcularValorTotal();

        if (processador instanceof FormaPagamento) {

            FormaPagamento pagamento =
                    (FormaPagamento) processador;

            if (pagamento.getValor().compareTo(valorTotal) != 0) {
                throw new PedidoInvalidoException(
                        "Valor do pagamento é diferente do total do pedido"
                );
            }
        }

        boolean aprovado = processador.processar(valorTotal);

        if (aprovado) {
            formaPagamento = (FormaPagamento) processador;
            setSituacao("PAGO");
        }
    }

    public BigDecimal calcularValorTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
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