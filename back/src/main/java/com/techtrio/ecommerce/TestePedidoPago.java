package com.techtrio.ecommerce;

import java.math.BigDecimal;

import com.techtrio.ecommerce.excecao.EstoqueInsuficienteException;
import com.techtrio.ecommerce.excecao.PedidoInvalidoException;
import com.techtrio.ecommerce.excecao.PagamentoRecusadoException;
import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;
import com.techtrio.ecommerce.modelo.pagamento.Pix;

public class TestePedidoPago {

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

        Pedido pedido = new Pedido(
                "PED007",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        try {

            System.out.println("===== PAGANDO O PEDIDO =====");

            pedido.adicionarItem(produto);

            Pix pix = new Pix(
                    new BigDecimal("100.00"),
                    "diogo@pix.com"
            );

            pedido.pagar(pix);

            System.out.println(
                    "Situação após pagamento: "
                    + pedido.getSituacao()
            );

            System.out.println();
            System.out.println("===== TENTANDO ALTERAR PEDIDO PAGO =====");

            pedido.adicionarItem(produto);

            System.out.println(
                    "ERRO: foi possível adicionar item ao pedido pago."
            );

        } catch (PedidoInvalidoException e) {

            System.out.println("OK: " + e.getMessage());
            System.out.println(
                    "Situação do pedido: "
                    + pedido.getSituacao()
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Erro de estoque: " + e.getMessage()
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