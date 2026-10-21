package com.techtrio.ecommerce.modelo;

import java.util.ArrayList;
import java.util.List;

import com.techtrio.ecommerce.excecao.ClienteNaoEncontradoException;

public class CadastroClientes {

    private final List<Cliente> clientes;

    public CadastroClientes() {
        clientes = new ArrayList<>();
    }

    public void cadastrar(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                    "Cliente é obrigatório"
            );
        }

        for (Cliente clienteExistente : clientes) {

            if (clienteExistente.getDocumento()
                    .equals(cliente.getDocumento())) {

                throw new IllegalArgumentException(
                        "Já existe um cliente com este documento"
                );
            }
        }

        clientes.add(cliente);
    }

    public Cliente buscarPorDocumento(String documento)
            throws ClienteNaoEncontradoException {

        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException(
                    "Documento é obrigatório"
            );
        }

        for (Cliente cliente : clientes) {

            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException(
                "Cliente não encontrado: " + documento
        );
    }

    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }
}