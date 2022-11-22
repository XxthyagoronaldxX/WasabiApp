package com.netbiis.wassabiapp_jsp.model.usecases.categoria.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.ICategoriaDAO;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IUpdateCategoriaUsecase;

import java.util.List;

public class UpdateCategoriaUsecase implements IUpdateCategoriaUsecase {
    private final ICategoriaDAO categoriaDAO;

    public UpdateCategoriaUsecase(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void execute(CategoriaEntity data) throws IllegalArgumentException {
        List<CategoriaEntity> categoriaEntityList = categoriaDAO.findAll();

        for (CategoriaEntity categoria: categoriaEntityList) {
            if (categoria.getNome().equals(data.getNome()) && data.getId() != categoria.getId()) {
                throw new IllegalArgumentException("NOME: Nome de categoria já existe!");
            }
        }

        categoriaDAO.update(data);
    }
}
