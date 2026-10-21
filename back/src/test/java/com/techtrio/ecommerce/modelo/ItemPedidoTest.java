package com.techtrio.ecommerce.modelo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemPedidoTest {

    @Test
    void deveCalcularSubtotalDoItem() {

        Produto produto = new Produto(
                "P001",
                "Notebook",
                new BigDecimal("3000.00"),
                10
        );

        ItemPedido item = new ItemPedido(
                produto,
                2,
                new BigDecimal("3000.00")
        );

        BigDecimal subtotalEsperado = new BigDecimal("6000.00");

        assertEquals(
                0,
                item.calcularSubtotal().compareTo(subtotalEsperado)
        );
    }
}