package com.techtrio.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.techtrio.ecommerce.modelo.Cliente;
import com.techtrio.ecommerce.modelo.ItemPedido;
import com.techtrio.ecommerce.modelo.Pedido;
import com.techtrio.ecommerce.modelo.Produto;
import com.techtrio.ecommerce.modelo.pagamento.FormaPagamento;
import com.techtrio.ecommerce.modelo.pagamento.Pix;

public class AppTest {

    private Cliente criarCliente() {
        return new Cliente(
                "Ana Silva",
                "12345678900",
                "ana@email.com",
                "16999999999",
                "Rua A"
        );
    }

    private Produto criarProduto() {
        return new Produto(
                "P001",
                "Produto Teste",
                new BigDecimal("50.00"),
                10
        );
    }

    private Pedido criarPedido() {
        return new Pedido(
                "PED001",
                criarCliente(),
                "16/09/2026",
                "ABERTO"
        );
    }

    @Test
    public void pedidoSemClienteDeveGerarErro() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pedido(
                        "PED001",
                        null,
                        "16/09/2026",
                        "ABERTO"
                )
        );
    }

    @Test
    public void itemComProdutoNuloDeveGerarErro() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(
                        null,
                        2,
                        new BigDecimal("50.00")
                )
        );
    }

    @Test
    public void quantidadeZeroDeveGerarErro() {
        Produto produto = criarProduto();

        assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(
                        produto,
                        0,
                        produto.getPreco()
                )
        );
    }

    @Test
    public void quantidadeNegativaDeveGerarErro() {
        Produto produto = criarProduto();

        assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(
                        produto,
                        -1,
                        produto.getPreco()
                )
        );
    }

    @Test
    public void quantidadeMaiorQueEstoqueDeveGerarErro() {
        Pedido pedido = criarPedido();
        Produto produto = criarProduto();

        assertThrows(
                IllegalStateException.class,
                () -> pedido.adicionarItem(produto, 11)
        );
    }

    @Test
    public void pedidoSemItensNaoPodeSerPago() {
        Pedido pedido = criarPedido();

        FormaPagamento pagamento = new Pix(
                new BigDecimal("50.00"),
                "ana@email.com"
        );

        assertThrows(
                IllegalStateException.class,
                () -> pedido.pagarCom(pagamento)
        );
    }

    @Test
    public void listaDeItensNaoPodeSerAlteradaExternamente() {
        Pedido pedido = criarPedido();
        Produto produto = criarProduto();

        pedido.adicionarItem(produto, 2);

        assertThrows(
                UnsupportedOperationException.class,
                () -> pedido.getItens().clear()
        );
    }

    @Test
    public void deveCalcularValorTotalDoPedido() {
        Pedido pedido = criarPedido();
        Produto produto = criarProduto();

        pedido.adicionarItem(produto, 2);

        assertEquals(
                new BigDecimal("100.00"),
                pedido.calcularValorTotal()
        );
    }

    @Test
    public void deveAssociarFormaDePagamentoAoPedido() {
        Pedido pedido = criarPedido();
        Produto produto = criarProduto();

        pedido.adicionarItem(produto, 2);

        FormaPagamento pagamento = new Pix(
                new BigDecimal("100.00"),
                "ana@email.com"
        );

        pedido.pagarCom(pagamento);

        assertEquals(
                pagamento,
                pedido.getFormaPagamento()
        );
    }
}       