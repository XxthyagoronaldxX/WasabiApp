package com.netbiis.wassabiapp_jsp.model.usecases.cliente;

import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;

public interface ILoginClienteUsecase {
    ClienteEntity execute(String cpf, String senha) throws IllegalArgumentException;
}
