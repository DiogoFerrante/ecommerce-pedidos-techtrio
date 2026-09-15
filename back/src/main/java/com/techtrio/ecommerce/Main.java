package com.techtrio.ecommerce;

import com.techtrio.ecommerce.modelo.pagamento.Boleto;
import com.techtrio.ecommerce.modelo.pagamento.CartaoCredito;
import com.techtrio.ecommerce.modelo.pagamento.FormaPagamento;
import com.techtrio.ecommerce.modelo.pagamento.Pix;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        FormaPagamento[] pagamentos = {
                new Pix(
                        new BigDecimal("150.00"),
                        "cliente@email.com"
                ),

                new Boleto(
                        new BigDecimal("300.00"),
                        "12345678901234567890",
                        LocalDate.now().plusDays(3)
                ),

                new CartaoCredito(
                        new BigDecimal("899.90"),
                        "**** 1234",
                        "Visa",
                        3
                )
        };

        for (FormaPagamento pagamento : pagamentos) {

            System.out.println(pagamento.getResumo());

            pagamento.processar();

            System.out.println();
        }
    }
}