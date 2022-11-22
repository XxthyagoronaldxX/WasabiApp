package com.netbiis.wassabiapp_jsp.model.usecases.cliente;

import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;

import java.util.List;

public interface IFindAllClienteUsecase {
    List<ClienteEntity> execute();
}
