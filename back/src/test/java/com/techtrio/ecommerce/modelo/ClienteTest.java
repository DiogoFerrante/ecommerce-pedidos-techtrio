package com.techtrio.ecommerce.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    @Test
    void deveCriarClienteComDadosValidos() {

        Cliente cliente = new Cliente(
                "Ana",
                "12345678900",
                "ana@email.com",
                "16999999999",
                "Rua Teste"
        );

        assertEquals("Ana", cliente.getNome());
        assertEquals("12345678900", cliente.getDocumento());
        assertEquals("ana@email.com", cliente.getEmail());
        assertEquals("16999999999", cliente.getTelefone());
        assertEquals("Rua Teste", cliente.getEndereco());
    }
}