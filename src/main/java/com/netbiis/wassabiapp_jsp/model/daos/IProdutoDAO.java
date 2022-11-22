package com.netbiis.wassabiapp_jsp.model.daos;

import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;

import java.util.List;

public interface IProdutoDAO {
	List<ProdutoEntity> findAll();

	void create(ProdutoEntity produto);

	void update(ProdutoEntity produto);

	void remove(ProdutoEntity produto);
}
