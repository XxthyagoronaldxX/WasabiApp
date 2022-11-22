package com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IProdutoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IRemoveProdutoUsecase;

public class RemoveProdutoUsecase implements IRemoveProdutoUsecase {
    private final IProdutoDAO produtoDAO;

    public RemoveProdutoUsecase(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void execute(ProdutoEntity produto) {
        produtoDAO.remove(produto);
    }
}
