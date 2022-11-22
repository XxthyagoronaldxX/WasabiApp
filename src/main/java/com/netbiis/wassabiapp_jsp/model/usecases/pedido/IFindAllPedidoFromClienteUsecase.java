package com.netbiis.wassabiapp_jsp.model.usecases.pedido;

import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;

import java.util.List;

public interface IFindAllPedidoFromClienteUsecase {
    List<PedidoEntity> execute(int clienteid);
}
