package com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IProdutoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IUpdateProdutoUsecase;

public class UpdateProdutoUsecase implements IUpdateProdutoUsecase {
    private final IProdutoDAO produtoDAO;

    public UpdateProdutoUsecase(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void execute(ProdutoEntity produto) {
        if (produto.getPreco().doubleValue() > 0
                && !produto.getNome().isEmpty()
                && produto.getQuantidade() > 0
                && !produto.getDescricao().isEmpty()
                && !produto.getImage().isEmpty()
        ) {
            produtoDAO.update(produto);
        } else {
            throw new IllegalArgumentException("VALOR: Valor inválido!");
        }
    }
}
