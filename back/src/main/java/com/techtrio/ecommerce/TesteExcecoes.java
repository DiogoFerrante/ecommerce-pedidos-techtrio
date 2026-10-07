package com.techtrio.ecommerce;

import java.math.BigDecimal;

import com.techtrio.ecommerce.excecao.EstoqueInsuficienteException;
import com.techtrio.ecommerce.excecao.PagamentoRecusadoException;
import com.techtrio.ecommerce.excecao.PedidoInvalidoException;
import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;
import com.techtrio.ecommerce.modelo.pagamento.CartaoCredito;

public class TesteExcecoes {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Diogo",
                "12345678900",
                "diogo@email.com",
                "16999999999",
                "Rua Teste"
        );


        System.out.println("=== TESTE 1 - ESTOQUE INSUFICIENTE ===");

        Produto notebook = new Produto(
                "P001",
                "Notebook",
                new BigDecimal("3000.00"),
                3
        );

        Pedido pedido1 = new Pedido(
                "001",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        try {

            pedido1.adicionarItem(notebook, 50);

            System.out.println(
                    "ERRO: foi possível adicionar mais que o estoque."
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Não foi possível adicionar: "
                    + e.getMessage()
            );

            System.out.println(
                    "Disponível agora: "
                    + e.getProduto().getQuantidadeEmEstoque()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 2 - PAGAMENTO RECUSADO ===");

        Pedido pedido2 = new Pedido(
                "002",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        Produto produto2 = new Produto(
                "P002",
                "Mouse",
                new BigDecimal("100.00"),
                10
        );

        try {

            pedido2.adicionarItem(produto2);

            CartaoCredito cartao = new CartaoCredito(
                    new BigDecimal("100.00"),
                    "0000",
                    "Diogo",
                    "Visa",
                    1
            );

            pedido2.pagar(cartao);

            System.out.println(
                    "ERRO: pagamento recusado foi aprovado."
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Estoque insuficiente: "
                    + e.getMessage()
            );

        } catch (PagamentoRecusadoException e) {

            System.out.println(
                    "Pagamento não realizado: "
                    + e.getMessage()
            );

            System.out.println(
                    "Motivo: "
                    + e.getMotivo()
            );

            System.out.println(
                    "Situação do pedido: "
                    + pedido2.getSituacao()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 3 - PEDIDO SEM ITENS ===");

        Pedido pedido3 = new Pedido(
                "003",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        try {

            pedido3.pagar(
                    new CartaoCredito(
                            new BigDecimal("100.00"),
                            "1234",
                            "Diogo",
                            "Visa",
                            1
                    )
            );

            System.out.println(
                    "ERRO: pedido vazio foi pago."
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );

            System.out.println(
                    "Situação do pedido: "
                    + pedido3.getSituacao()
            );

        } catch (PagamentoRecusadoException e) {

            System.out.println(
                    "Pagamento recusado: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 4 - PROCESSADOR NULO ===");

        Pedido pedido4 = new Pedido(
                "004",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        Produto produto4 = new Produto(
                "P004",
                "Mouse",
                new BigDecimal("100.00"),
                10
        );

        try {

            pedido4.adicionarItem(produto4);

            pedido4.pagar(null);

            System.out.println(
                    "ERRO: processador nulo foi aceito."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Dado inválido: "
                    + e.getMessage()
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Estoque insuficiente: "
                    + e.getMessage()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );

        } catch (PagamentoRecusadoException e) {

            System.out.println(
                    "Pagamento recusado: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 5 - PAGAMENTO APROVADO ===");

        Pedido pedido5 = new Pedido(
                "005",
                cliente,
                "06/10/2026",
                "ABERTO"
        );

        Produto produto5 = new Produto(
                "P005",
                "Teclado",
                new BigDecimal("200.00"),
                10
        );

        try {

            pedido5.adicionarItem(produto5);

            CartaoCredito cartao = new CartaoCredito(
                    new BigDecimal("200.00"),
                    "1234",
                    "Diogo",
                    "Visa",
                    1
            );

            pedido5.pagar(cartao);

            System.out.println(
                    "Pagamento aprovado."
            );

            System.out.println(
                    "Situação do pedido: "
                    + pedido5.getSituacao()
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Estoque insuficiente: "
                    + e.getMessage()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );

        } catch (PagamentoRecusadoException e) {

            System.out.println(
                    "Pagamento recusado: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 6 - PEDIDO JÁ PAGO ===");

        try {

            pedido5.pagar(
                    new CartaoCredito(
                            new BigDecimal("200.00"),
                            "1234",
                            "Diogo",
                            "Visa",
                            1
                    )
            );

            System.out.println(
                    "ERRO: pedido pago foi pago novamente."
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );

            System.out.println(
                    "Situação do pedido: "
                    + pedido5.getSituacao()
            );

        } catch (PagamentoRecusadoException e) {

            System.out.println(
                    "Pagamento recusado: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 7 - QUANTIDADE ZERO ===");

        try {

            Produto produto7 = new Produto(
                    "P007",
                    "Mouse",
                    new BigDecimal("50.00"),
                    10
            );

            Pedido pedido7 = new Pedido(
                    "007",
                    cliente,
                    "06/10/2026",
                    "ABERTO"
            );

            pedido7.adicionarItem(produto7, 0);

            System.out.println(
                    "ERRO: quantidade zero foi aceita."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Estoque insuficiente: "
                    + e.getMessage()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("=== TESTE 8 - QUANTIDADE NEGATIVA ===");

        try {

            Produto produto8 = new Produto(
                    "P008",
                    "Teclado",
                    new BigDecimal("100.00"),
                    10
            );

            Pedido pedido8 = new Pedido(
                    "008",
                    cliente,
                    "06/10/2026",
                    "ABERTO"
            );

            pedido8.adicionarItem(produto8, -5);

            System.out.println(
                    "ERRO: quantidade negativa foi aceita."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );

        } catch (EstoqueInsuficienteException e) {

            System.out.println(
                    "Estoque insuficiente: "
                    + e.getMessage()
            );

        } catch (PedidoInvalidoException e) {

            System.out.println(
                    "Pedido inválido: "
                    + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("O programa continua funcionando.");
    }
}