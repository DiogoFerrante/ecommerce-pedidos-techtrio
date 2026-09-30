package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;

public class TestePagamento {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Diogo",
                "12345678900",
                "diogo@email.com",
                "11999999999",
                "Rua Teste"
        );

        Produto produto = new Produto(
                "P001",
                "Teclado",
                new BigDecimal("100.00"),
                10
        );

        System.out.println("===== TESTE PIX =====");

        Pedido pedidoPix = new Pedido(
                "PED001",
                cliente,
                "29/09/2026",
                "ABERTO"
        );

        pedidoPix.adicionarItem(produto);

        ProcessadorPagamento pix = new Pix(
                new BigDecimal("100.00"),
                "diogo@pix.com"
        );

        pedidoPix.pagar(pix);

        System.out.println("Situação: " + pedidoPix.getSituacao());
        System.out.println("Descrição: " + pix.getDescricao());
        System.out.println("Comprovante: " + pix.getComprovante());


        System.out.println("\n===== TESTE BOLETO =====");

        Pedido pedidoBoleto = new Pedido(
                "PED002",
                cliente,
                "29/09/2026",
                "ABERTO"
        );

        pedidoBoleto.adicionarItem(produto);

        ProcessadorPagamento boleto = new Boleto(
                new BigDecimal("100.00"),
                "12345678901234567890123456789012345678901234567"
        );

        pedidoBoleto.pagar(boleto);

        System.out.println("Situação: " + pedidoBoleto.getSituacao());
        System.out.println("Descrição: " + boleto.getDescricao());


        System.out.println("\n===== TESTE CARTÃO =====");

        Pedido pedidoCartao = new Pedido(
                "PED003",
                cliente,
                "29/09/2026",
                "ABERTO"
        );

        pedidoCartao.adicionarItem(produto);

        ProcessadorPagamento cartao = new CartaoCredito(
                new BigDecimal("100.00"),
                "1111222233334444",
                "Diogo",
                "Visa",
                3
        );

        pedidoCartao.pagar(cartao);

        System.out.println("Situação: " + pedidoCartao.getSituacao());
        System.out.println("Descrição: " + cartao.getDescricao());
        System.out.println("Comprovante: " + cartao.getComprovante());


        System.out.println("\n===== TESTE DINHEIRO =====");

        Pedido pedidoDinheiro = new Pedido(
                "PED004",
                cliente,
                "29/09/2026",
                "ABERTO"
        );

        pedidoDinheiro.adicionarItem(produto);

        Dinheiro dinheiro = new Dinheiro(
                new BigDecimal("100.00"),
                new BigDecimal("150.00")
        );

        pedidoDinheiro.pagar(dinheiro);

        System.out.println("Situação: " + pedidoDinheiro.getSituacao());
        System.out.println("Descrição: " + dinheiro.getDescricao());
        System.out.println("Troco: R$ " + dinheiro.calcularTroco());


        System.out.println("\n===== TESTE CARTÃO 15 PARCELAS =====");

        try {

            new CartaoCredito(
                    new BigDecimal("300.00"),
                    "1111222233334444",
                    "Diogo",
                    "Visa",
                    15
            );

            System.out.println("ERRO: cartão de 15 parcelas foi aceito.");

        } catch (IllegalArgumentException e) {

            System.out.println("OK: " + e.getMessage());
        }


        System.out.println("\n===== TESTE PEDIDO SEM ITENS =====");

        try {

            Pedido pedidoVazio = new Pedido(
                    "PED005",
                    cliente,
                    "29/09/2026",
                    "ABERTO"
            );

            pedidoVazio.pagar(pix);

            System.out.println("ERRO: pedido vazio foi pago.");

        } catch (IllegalStateException e) {

            System.out.println("OK: " + e.getMessage());
        }


        System.out.println("\n===== TESTE PROCESSADOR NULL =====");

        try {

            Pedido pedidoNull = new Pedido(
                    "PED006",
                    cliente,
                    "29/09/2026",
                    "ABERTO"
            );

            pedidoNull.adicionarItem(produto);
            pedidoNull.pagar(null);

            System.out.println("ERRO: processador null foi aceito.");

        } catch (IllegalArgumentException e) {

            System.out.println("OK: " + e.getMessage());
        }
    }
}