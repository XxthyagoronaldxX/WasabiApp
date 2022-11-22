package com.netbiis.wassabiapp_jsp.model.usecases.categoria.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.ICategoriaDAO;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IRemoveCategoriaUsecase;

public class RemoveCategoriaUsecase implements IRemoveCategoriaUsecase {
    private final ICategoriaDAO categoriaDAO;

    public RemoveCategoriaUsecase(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void execute(CategoriaEntity data) throws IllegalArgumentException {
        if (data.getProdutoHasCategoriasById() != null)
            if (data.getProdutoHasCategoriasById().size() > 0)
                throw new IllegalArgumentException("CATEGORIA: Não é possível apagar uma categoria com produtos relacionados!");


        categoriaDAO.delete(data);
    }
}
