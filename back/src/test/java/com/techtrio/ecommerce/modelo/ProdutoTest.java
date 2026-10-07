package com.techtrio.ecommerce.modelo;

import com.techtrio.ecommerce.excecao.EstoqueInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProdutoTest {

    @Test
    void deveBaixarEstoqueComQuantidadeDisponivel()
            throws EstoqueInsuficienteException {

        Produto produto = new Produto(
                "P001",
                "Notebook",
                new BigDecimal("3000.00"),
                5
        );

        produto.baixarEstoque(2);

        assertEquals(3, produto.getQuantidadeEmEstoque());
    }

    @Test
    void deveLancarExcecaoQuandoEstoqueForInsuficiente() {

        Produto produto = new Produto(
                "P001",
                "Notebook",
                new BigDecimal("3000.00"),
                5
        );

        EstoqueInsuficienteException excecao =
                assertThrows(
                        EstoqueInsuficienteException.class,
                        () -> produto.baixarEstoque(10)
                );

        assertTrue(excecao.getMessage().contains("Notebook"));
        assertEquals(5, produto.getQuantidadeEmEstoque());
    }
}