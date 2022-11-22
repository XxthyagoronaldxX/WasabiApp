package com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations;

import java.util.List;
import com.netbiis.wassabiapp_jsp.model.daos.IProdutoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IIndexProdutoUsecase;

public class IndexProdutoUsecase implements IIndexProdutoUsecase {
	private final IProdutoDAO produtoDAO;

	public IndexProdutoUsecase(IProdutoDAO produtoDAO) {
		super();
		this.produtoDAO = produtoDAO;
	}

	@Override
	public List<ProdutoEntity> execute() {
		return this.produtoDAO.findAll();
	}

}
