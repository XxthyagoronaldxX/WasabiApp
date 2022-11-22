package com.netbiis.wassabiapp_jsp.model.usecases.produto;

import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;

public interface IRemoveProdutoUsecase {
    void execute(ProdutoEntity produto);
}
