package com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IClienteDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.core.utils.ValidatorUtil;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.IUpdateClienteUsecase;

import java.util.Optional;

public class UpdateClienteUsecase implements IUpdateClienteUsecase {
    private final IClienteDAO clienteDAO;

    public UpdateClienteUsecase(IClienteDAO clienteDAO) {
        super();
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void execute(ClienteEntity data) throws IllegalArgumentException {
        Optional<ClienteEntity> clienteByCpf = clienteDAO.findByCpf(data.getCpf());

        if (data.getNome().trim().isEmpty() || data.getTelefone().length() < 13 || data.getCpf().length() < 13
                || data.getEndereco().trim().isEmpty() || data.getCartao().trim().length() < 16)
            throw new IllegalArgumentException("Dados: Dados inválidos!");

        if (clienteByCpf.isPresent() && clienteByCpf.get().getId() != data.getId())
            throw new IllegalArgumentException("CPF: Já existe um cadastro com este CPF!");

        if (!ValidatorUtil.cpf.test(data.getCpf()))
            throw new IllegalArgumentException("CPF: Formato inválido!");

        if (!ValidatorUtil.telefone.test(data.getTelefone()))
            throw new IllegalArgumentException("Telefone: Formato inválido!");

        clienteDAO.update(data);
    }

}
