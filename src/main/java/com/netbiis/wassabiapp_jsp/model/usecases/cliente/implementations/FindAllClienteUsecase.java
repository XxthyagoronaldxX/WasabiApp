package com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IClienteDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.IFindAllClienteUsecase;

import java.util.List;

public class FindAllClienteUsecase implements IFindAllClienteUsecase {
    private final IClienteDAO clienteDAO;

    public FindAllClienteUsecase(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public List<ClienteEntity> execute() {
        return clienteDAO.findAll();
    }
}
