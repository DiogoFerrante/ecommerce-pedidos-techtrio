package com.techtrio.ecommerce;

import com.techtrio.ecommerce.excecao.ClienteNaoEncontradoException;
import com.techtrio.ecommerce.modelo.CadastroClientes;
import com.techtrio.ecommerce.modelo.Cliente;

public class TesteCadastroClientes {

    public static void main(String[] args) {

        CadastroClientes cadastro = new CadastroClientes();

        Cliente cliente = new Cliente(
                "Diogo",
                "12345678900",
                "diogo@email.com",
                "16999999999",
                "Rua Teste"
        );

        System.out.println("===== TESTE CADASTRO DE CLIENTE =====");

        cadastro.cadastrar(cliente);

        System.out.println(
                "Cliente cadastrado: "
                + cliente.getNome()
        );


        System.out.println("\n===== TESTE CLIENTE DUPLICADO =====");

        try {

            Cliente clienteDuplicado = new Cliente(
                    "Outro Cliente",
                    "12345678900",
                    "outro@email.com",
                    "16988888888",
                    "Outra Rua"
            );

            cadastro.cadastrar(clienteDuplicado);

            System.out.println(
                    "ERRO: cliente duplicado foi cadastrado."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );
        }


        System.out.println("\n===== TESTE CLIENTE ENCONTRADO =====");

        try {

            Cliente encontrado =
                    cadastro.buscarPorDocumento("12345678900");

            System.out.println(
                    "Cliente encontrado: "
                    + encontrado.getNome()
            );

        } catch (ClienteNaoEncontradoException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }


        System.out.println("\n===== TESTE CLIENTE NÃO ENCONTRADO =====");

        try {

            cadastro.buscarPorDocumento("99999999999");

            System.out.println(
                    "ERRO: cliente inexistente foi encontrado."
            );

        } catch (ClienteNaoEncontradoException e) {

            System.out.println(
                    "OK: " + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("O programa continua funcionando.");
    }
}