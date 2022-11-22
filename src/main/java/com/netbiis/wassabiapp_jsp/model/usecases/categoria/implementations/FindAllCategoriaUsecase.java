package com.netbiis.wassabiapp_jsp.model.usecases.categoria.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.ICategoriaDAO;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IFindAllCategoriaUsecase;

import java.util.List;

public class FindAllCategoriaUsecase implements IFindAllCategoriaUsecase {
    private final ICategoriaDAO categoriaDAO;

    public FindAllCategoriaUsecase(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public List<CategoriaEntity> execute() {
        return categoriaDAO.findAll();
    }
}
