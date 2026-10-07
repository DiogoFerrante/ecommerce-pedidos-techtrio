package com.techtrio.ecommerce;

import java.math.BigDecimal;

import com.techtrio.ecommerce.modelo.CadastroProdutos;
import com.techtrio.ecommerce.modelo.Produto;

public class TesteCadastroProdutos {

    public static void main(String[] args) {

        CadastroProdutos cadastro = new CadastroProdutos();

        Produto produto = new Produto(
                "P001",
                "Teclado",
                new BigDecimal("100.00"),
                10
        );

        System.out.println("===== TESTE CADASTRO DE PRODUTO =====");

        cadastro.cadastrar(produto);

        System.out.println(
                "Produto cadastrado: "
                + produto.getNome()
        );


        System.out.println("\n===== TESTE PRODUTO DUPLICADO =====");

        try {

            Produto produtoDuplicado = new Produto(
                    "P001",
                    "Mouse",
                    new BigDecimal("50.00"),
                    5
            );

            cadastro.cadastrar(produtoDuplicado);

            System.out.println(
                    "ERRO: produto duplicado foi cadastrado."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );
        }


        System.out.println("\n===== TESTE BUSCA DE PRODUTO =====");

        try {

            Produto encontrado =
                    cadastro.buscarPorCodigo("P001");

            System.out.println(
                    "Produto encontrado: "
                    + encontrado.getNome()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }


        System.out.println("\n===== TESTE PREÇO INVALIDO =====");

        try {

            Produto produtoInvalido = new Produto(
                    "P002",
                    "Monitor",
                    new BigDecimal("-100.00"),
                    5
            );

            System.out.println(
                    "ERRO: produto com preço inválido foi criado."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );
        }


        System.out.println("\n===== TESTE ESTOQUE NEGATIVO =====");

        try {

            Produto produtoInvalido = new Produto(
                    "P003",
                    "Mouse",
                    new BigDecimal("50.00"),
                    -5
            );

            System.out.println(
                    "ERRO: produto com estoque negativo foi criado."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("O programa continua funcionando.");
    }
}