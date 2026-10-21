package com.techtrio.ecommerce.modelo.pagamento;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PixTest {

    @Test
    void deveProcessarPagamentoViaPix() {

        Pix pix = new Pix(
                new BigDecimal("100.00"),
                "ana@email.com"
        );

        boolean resultado = pix.processar(
                new BigDecimal("100.00")
        );

        assertTrue(resultado);
        assertEquals("PAGO", pix.getSituacao());
    }

    @Test
    void deveRetornarDescricaoDoPix() {

        Pix pix = new Pix(
                new BigDecimal("100.00"),
                "ana@email.com"
        );

        assertEquals(
                "Pix - chave ana@email.com",
                pix.getDescricao()
        );
    }
}