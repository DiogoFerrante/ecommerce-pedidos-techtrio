package com.techtrio.ecommerce;

import java.math.BigDecimal;

import com.techtrio.ecommerce.excecao.EstoqueInsuficienteException;
import com.techtrio.ecommerce.excecao.PagamentoRecusadoException;
import com.techtrio.ecommerce.excecao.PedidoInvalidoException;
import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;
import com.techtrio.ecommerce.modelo.pagamento.CartaoCredito;

public class TesteValorPagamento {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Diogo",
                "12345678900",
                "diogo@email.com",
                "16999999999",
                "Rua Teste"
        );

        Produto produto = new Produto(
                "PROD001",
                "Produto Teste",
                new BigDecimal("100.00"),
                5
        );

        Pedido pedido = new Pedido(
                "004",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        try {

            pedido.adicionarItem(produto, 1);

            CartaoCredito cartao = new CartaoCredito(
                    new BigDecimal("50.00"),
                    "1234",
                    "Diogo",
                    "Visa",
                    1
            );

            pedido.pagar(cartao);

            System.out.println("Pagamento aprovado.");

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Estoque insuficiente: " + e.getMessage()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pagamento não realizado: " + e.getMessage()
            );

            System.out.println(
                    "Situação do pedido: "
                    + pedido.getSituacao()
            );

        } catch (PagamentoRecusadoException e) {

            System.out.println(
                    "Pagamento recusado: " + e.getMessage()
            );
        }

        System.out.println();
        System.out.println("O programa continua funcionando.");
    }
}