package com.netbiis.wassabiapp_jsp.model.usecases.pedido.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IPedidoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.ICreatePedidoUsecase;

public class CreatePedidoUsecase implements ICreatePedidoUsecase {
	private final IPedidoDAO pedidoDAO;

	public CreatePedidoUsecase(IPedidoDAO pedidoDAO) {
		super();
		this.pedidoDAO = pedidoDAO;
	}

	@Override
	public void execute(PedidoEntity data) {
		pedidoDAO.create(data);
	}

}
