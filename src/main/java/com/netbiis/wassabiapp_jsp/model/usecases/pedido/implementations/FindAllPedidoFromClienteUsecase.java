package com.netbiis.wassabiapp_jsp.model.usecases.pedido.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IPedidoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IFindAllPedidoFromClienteUsecase;

import java.util.List;

public class FindAllPedidoFromClienteUsecase implements IFindAllPedidoFromClienteUsecase {
    private final IPedidoDAO pedidoDAO;

    public FindAllPedidoFromClienteUsecase(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public List<PedidoEntity> execute(int clienteid) {
        return pedidoDAO.findAllByClienteId(clienteid);
    }
}
