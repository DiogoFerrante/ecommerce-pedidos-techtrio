package com.techtrio.ecommerce.modelo;

import java.util.ArrayList;
import java.util.List;

public class CadastroProdutos {

    private final List<Produto> produtos;

    public CadastroProdutos() {
        produtos = new ArrayList<>();
    }

    public void cadastrar(Produto produto) {

        if (produto == null) {
            throw new IllegalArgumentException(
                    "Produto é obrigatório"
            );
        }

        for (Produto produtoExistente : produtos) {

            if (produtoExistente.getCodigo()
                    .equals(produto.getCodigo())) {

                throw new IllegalArgumentException(
                        "Já existe um produto com este código"
                );
            }
        }

        produtos.add(produto);
    }

    public Produto buscarPorCodigo(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                    "Código é obrigatório"
            );
        }

        for (Produto produto : produtos) {

            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }

        throw new IllegalArgumentException(
                "Produto não encontrado: " + codigo
        );
    }

    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }
}