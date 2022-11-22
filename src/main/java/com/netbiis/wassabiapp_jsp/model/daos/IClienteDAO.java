package com.netbiis.wassabiapp_jsp.model.daos;

import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface IClienteDAO {
	Optional<ClienteEntity> findByCpf(String cpf);

	void update(ClienteEntity cliente);
	
	void create(ClienteEntity cliente);

	List<ClienteEntity> findAll();
}
