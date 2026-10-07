package com.techtrio.ecommerce.modelo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PedidoQuantidadeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50})
    void deveLancarExcecaoParaQuantidadeNaoPositiva(int quantidade) {

        Cliente cliente = new Cliente(
                "Ana",
                "12345678900",
                "ana@email.com",
                "16999999999",
                "Rua Teste"
        );

        Produto produto = new Produto(
                "P001",
                "Notebook",
                new BigDecimal("3000.00"),
                10
        );

        Pedido pedido = new Pedido(
                "PED001",
                cliente,
                "07/10/2026",
                "ABERTO"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> pedido.adicionarItem(produto, quantidade)
        );
    }
}