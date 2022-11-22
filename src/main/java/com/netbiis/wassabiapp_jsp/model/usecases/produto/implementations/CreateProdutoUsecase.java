package com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IProdutoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.ICreateProdutoUsecase;

public class CreateProdutoUsecase implements ICreateProdutoUsecase {
    private final IProdutoDAO produtoDAO;

    public CreateProdutoUsecase(IProdutoDAO produtoDAO) {
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
            produtoDAO.create(produto);
        } else {
            throw new IllegalArgumentException("VALOR: Valor inválido!");
        }
    }
}
