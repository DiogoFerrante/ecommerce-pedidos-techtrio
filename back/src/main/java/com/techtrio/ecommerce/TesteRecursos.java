package com.techtrio.ecommerce;

import java.util.Scanner;

public class TesteRecursos {

    public static void main(String[] args) {

        System.out.println("=== TESTE 1 - FINALLY ===");

        Scanner entrada = new Scanner(System.in);

        try {

            System.out.print("Digite seu nome: ");
            String nome = entrada.nextLine();

            System.out.println(
                    "Olá, " + nome + "!"
            );

        } finally {

            entrada.close();

            System.out.println(
                    "Scanner fechado pelo finally."
            );
        }

        System.out.println();
        System.out.println("=== TESTE 2 - TRY-WITH-RESOURCES ===");

        try (Scanner entrada2 = new Scanner("São Carlos")) {

            String cidade = entrada2.nextLine();

            System.out.println(
                    "Cidade informada: " + cidade
            );
        }

        System.out.println(
                "Scanner fechado automaticamente."
        );

        System.out.println();
        System.out.println("O programa continua funcionando.");
    }
}