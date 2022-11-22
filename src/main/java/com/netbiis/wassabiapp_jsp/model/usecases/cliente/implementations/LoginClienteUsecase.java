package com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IClienteDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.ILoginClienteUsecase;

import java.util.Optional;

public class LoginClienteUsecase implements ILoginClienteUsecase {
    private final IClienteDAO clienteDAO;

    public LoginClienteUsecase(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public ClienteEntity execute(String cpf, String senha) throws IllegalArgumentException {
        Optional<ClienteEntity> clienteOptional = clienteDAO.findByCpf(cpf);

        if (clienteOptional.isPresent()) {
            ClienteEntity cliente = clienteOptional.get();

            if (cliente.getSenha().equals(senha)) {
                return cliente;
            } else {
                throw new IllegalArgumentException("SENHA: Senha incorreta!");
            }
        } else {
            throw new IllegalArgumentException("CPF: Cpf não encontrado!");
        }
    }
}
