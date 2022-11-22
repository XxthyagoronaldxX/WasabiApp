package com.netbiis.wassabiapp_jsp.model.daos;

import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;

import java.util.List;

public interface IPedidoDAO {
	void create(PedidoEntity pedido);
	List<PedidoEntity> findAll();
	List<PedidoEntity> findAllByClienteId(int clienteid);
}
