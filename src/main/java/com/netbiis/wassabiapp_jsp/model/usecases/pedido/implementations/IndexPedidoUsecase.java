package com.netbiis.wassabiapp_jsp.model.usecases.pedido.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IPedidoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IIndexPedidoUsecase;

import java.util.List;

public class IndexPedidoUsecase implements IIndexPedidoUsecase {
    private final IPedidoDAO pedidoDAO;

    public IndexPedidoUsecase(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public List<PedidoEntity> execute() {
        return this.pedidoDAO.findAll();
    }
}
