package com.netbiis.wassabiapp_jsp.model.usecases.categoria.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.ICategoriaDAO;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.ICreateCategoriaUsecase;

import java.util.List;

public class CreateCategoriaUsecase implements ICreateCategoriaUsecase {
    private final ICategoriaDAO categoriaDAO;

    public CreateCategoriaUsecase(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void execute(CategoriaEntity data) throws IllegalArgumentException {
        List<CategoriaEntity> categoriaEntityList = categoriaDAO.findAll();

        for (CategoriaEntity categoria: categoriaEntityList) {
            if (categoria.getNome().equals(data.getNome())) {
                throw new IllegalArgumentException("NOME: Nome de categoria já existe!");
            }
        }

        categoriaDAO.create(data);
    }
}
