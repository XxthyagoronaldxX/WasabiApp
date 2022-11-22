package com.netbiis.wassabiapp_jsp.model.usecases.categoria.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.ICategoriaDAO;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IInitCategoriaUsecase;

import java.util.List;
import java.util.stream.Collectors;

public class InitCategoriaUsecase implements IInitCategoriaUsecase {
    private final ICategoriaDAO categoriaDAO;

    public InitCategoriaUsecase(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public List<CategoriaEntity> execute() {
        List<CategoriaEntity> categorias = categoriaDAO.findAll();

        return filterAllCategoriasWithMoreThanZeroProdutos(categorias);
    }

    public List<CategoriaEntity> filterAllCategoriasWithMoreThanZeroProdutos(List<CategoriaEntity> categoriaEntityList) {
        return categoriaEntityList.stream().filter(categoria -> categoria.getProdutoHasCategoriasById().size() > 0).collect(Collectors.toList());
    }
}
