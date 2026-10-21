package com.techtrio.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

import com.techtrio.ecommerce.excecao.PagamentoRecusadoException;

public interface ProcessadorPagamento {

    boolean processar(BigDecimal valor) throws PagamentoRecusadoException;

    String getComprovante();

    String getDescricao();
}