package com.netbiis.wassabiapp_jsp.model.usecases.produto;

import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;

import java.util.List;

public interface IIndexProdutoUsecase {
	List<ProdutoEntity> execute();
}
