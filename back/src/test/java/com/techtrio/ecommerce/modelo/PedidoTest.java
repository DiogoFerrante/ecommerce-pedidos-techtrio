package com.techtrio.ecommerce.modelo;

import com.techtrio.ecommerce.excecao.EstoqueInsuficienteException;
import com.techtrio.ecommerce.excecao.PedidoInvalidoException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoTest {

    @Test
    void deveCalcularValorTotalComDoisItens()
            throws EstoqueInsuficienteException, PedidoInvalidoException {

        Cliente cliente = new Cliente(
                "Ana",
                "12345678900",
                "ana@email.com",
                "16999999999",
                "Rua Teste"
        );

        Produto notebook = new Produto(
                "P001",
                "Notebook",
                new BigDecimal("3000.00"),
                10
        );

        Produto mouse = new Produto(
                "P002",
                "Mouse",
                new BigDecimal("100.00"),
                10
        );

        Pedido pedido = new Pedido(
                "PED001",
                cliente,
                "07/10/2026",
                "ABERTO"
        );

        pedido.adicionarItem(notebook, 2);
        pedido.adicionarItem(mouse, 3);

        BigDecimal totalEsperado = new BigDecimal("6300.00");

        assertEquals(
                0,
                pedido.calcularValorTotal().compareTo(totalEsperado)
        );
    }
}