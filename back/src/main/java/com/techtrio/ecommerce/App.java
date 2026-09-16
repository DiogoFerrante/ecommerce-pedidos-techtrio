package com.techtrio.ecommerce;

import java.math.BigDecimal;

import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;
import com.techtrio.ecommerce.modelo.pagamento.FormaPagamento;
import com.techtrio.ecommerce.modelo.pagamento.Pix;

public class App {

    public static void main(String[] args) {

        // Criação do cliente
        Cliente cliente = new Cliente(
                "Ana Silva",
                "12345678900",
                "ana@email.com",
                "16999999999",
                "Rua A"
        );

        // Criação do produto
        Produto produto = new Produto(
                "P001",
                "Produto Teste",
                new BigDecimal("50.00"),
                10
        );

        // Criação do pedido associado ao cliente
        Pedido pedido = new Pedido(
                "PED001",
                cliente,
                "16/09/2026",
                "ABERTO"
        );

        // O Pedido cria e controla seus ItemPedido
        pedido.adicionarItem(produto, 2);

        // Criação da forma de pagamento
        FormaPagamento pagamento = new Pix(
                new BigDecimal("100.00"),
                "ana@email.com"
        );

        // Associação do pagamento ao pedido
        pedido.pagarCom(pagamento);

        // Exibição dos resultados
        System.out.println("=== SISTEMA DE PEDIDOS ===");
        System.out.println("Pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Itens: " + pedido.getItens().size());
        System.out.println("Valor total: R$ " + pedido.calcularValorTotal());
        System.out.println("Pagamento: " + pedido.getFormaPagamento().getResumo());
        System.out.println("Status: " + pedido.getSituacao());
    }
}