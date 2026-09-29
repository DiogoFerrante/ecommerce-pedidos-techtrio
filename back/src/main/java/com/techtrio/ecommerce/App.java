package com.techtrio.ecommerce;

import java.math.BigDecimal;

import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;
import com.techtrio.ecommerce.modelo.pagamento.FormaPagamento;
import com.techtrio.ecommerce.modelo.pagamento.Pix;

public class App {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     TESTES DA AULA 07");
        System.out.println("======================================");

        Cliente cliente = new Cliente(
                "Ana Silva",
                "12345678900",
                "ana@email.com",
                "16999999999",
                "Rua A"
        );

        Produto produto = new Produto(
                "P001",
                "Produto Teste",
                new BigDecimal("50.00"),
                10
        );

        Pedido pedido = new Pedido(
                "PED001",
                cliente,
                "16/09/2026",
                "ABERTO"
        );

        // Composição: o Pedido cria o ItemPedido
        pedido.adicionarItem(produto, 2);

        System.out.println();
        System.out.println("=== PEDIDO CRIADO ===");
        System.out.println("Pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Quantidade de itens: " + pedido.getItens().size());
        System.out.println("Valor total: R$ " + pedido.calcularValorTotal());

        // Teste: produto nulo
        System.out.println();
        System.out.println("=== TESTE: PRODUTO NULO ===");

        try {
            pedido.adicionarItem(null, 2);
            System.out.println("ERRO: produto nulo foi aceito.");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: produto nulo foi recusado.");
        }

        // Teste: quantidade zero
        System.out.println();
        System.out.println("=== TESTE: QUANTIDADE ZERO ===");

        try {
            pedido.adicionarItem(produto, 0);
            System.out.println("ERRO: quantidade zero foi aceita.");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: quantidade zero foi recusada.");
        }

        // Teste: quantidade negativa
        System.out.println();
        System.out.println("=== TESTE: QUANTIDADE NEGATIVA ===");

        try {
            pedido.adicionarItem(produto, -1);
            System.out.println("ERRO: quantidade negativa foi aceita.");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: quantidade negativa foi recusada.");
        }

        // Teste: estoque insuficiente
        System.out.println();
        System.out.println("=== TESTE: ESTOQUE INSUFICIENTE ===");

        try {
            pedido.adicionarItem(produto, 999);
            System.out.println("ERRO: estoque insuficiente foi aceito.");
        } catch (IllegalStateException e) {
            System.out.println("OK: estoque insuficiente foi recusado.");
        }

        // Teste: lista protegida
        System.out.println();
        System.out.println("=== TESTE: LISTA PROTEGIDA ===");

        try {
            pedido.getItens().clear();
            System.out.println("ERRO: a lista pôde ser alterada.");
        } catch (UnsupportedOperationException e) {
            System.out.println("OK: a lista está protegida.");
        }

        // Teste: pedido sem cliente
        System.out.println();
        System.out.println("=== TESTE: PEDIDO SEM CLIENTE ===");

        try {
            new Pedido(
                    "PED002",
                    null,
                    "16/09/2026",
                    "ABERTO"
            );

            System.out.println("ERRO: pedido sem cliente foi aceito.");

        } catch (IllegalArgumentException e) {
            System.out.println("OK: pedido sem cliente foi recusado.");
        }

        // Teste: pagamento sem itens
        System.out.println();
        System.out.println("=== TESTE: PAGAMENTO SEM ITENS ===");

        Pedido pedidoVazio = new Pedido(
                "PED003",
                cliente,
                "16/09/2026",
                "ABERTO"
        );

        FormaPagamento pagamentoTeste = new Pix(
                new BigDecimal("50.00"),
                "ana@email.com"
        );

        try {
            pedidoVazio.pagarCom(pagamentoTeste);
            System.out.println("ERRO: pedido vazio foi aceito para pagamento.");
        } catch (IllegalStateException e) {
            System.out.println("OK: pedido vazio não pode ser pago.");
        }

        // Pagamento do pedido normal
        System.out.println();
        System.out.println("=== PAGAMENTO DO PEDIDO ===");

        FormaPagamento pagamento = new Pix(
                new BigDecimal("100.00"),
                "ana@email.com"
        );

        pedido.pagarCom(pagamento);

        System.out.println(
                "Pagamento: " + pedido.getFormaPagamento().getResumo()
        );

        // Resultado
        System.out.println();
        System.out.println("======================================");
        System.out.println("       RESULTADO FINAL");
        System.out.println("======================================");

        System.out.println("Pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Itens: " + pedido.getItens().size());
        System.out.println("Valor total: R$ " + pedido.calcularValorTotal());
        System.out.println(
                "Pagamento: " + pedido.getFormaPagamento().getResumo()
        );
        System.out.println("Status: " + pedido.getSituacao());

        System.out.println("======================================");
        System.out.println("       TESTES FINALIZADOS");
        System.out.println("======================================");
    }
}