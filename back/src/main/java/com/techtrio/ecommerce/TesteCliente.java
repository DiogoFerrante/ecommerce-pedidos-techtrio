package com.techtrio.ecommerce;

import com.techtrio.ecommerce.modelo.Cliente;

public class TesteCliente {

    public static void main(String[] args) {

        System.out.println("===== TESTE - EMAIL INVALIDO =====");

        try {

            Cliente cliente = new Cliente(
                    "Diogo",
                    "12345678900",
                    "email-invalido",
                    "16999999999",
                    "Rua Teste"
            );

            System.out.println(
                    "Cliente criado: " + cliente.getNome()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Cliente não criado: " + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("===== TESTE - DOCUMENTO INVALIDO =====");

        try {

            Cliente cliente = new Cliente(
                    "Diogo",
                    "123",
                    "diogo@email.com",
                    "16999999999",
                    "Rua Teste"
            );

            System.out.println(
                    "Cliente criado: " + cliente.getNome()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Cliente não criado: " + e.getMessage()
            );
        }


        System.out.println();
        System.out.println("O programa continua funcionando.");
    }
}