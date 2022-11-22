package com.netbiis.wassabiapp_jsp.model.daos;

import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;

import java.util.List;

public interface ICategoriaDAO {
    List<CategoriaEntity> findAll();

    void create(CategoriaEntity categoria);

    void update(CategoriaEntity categoria);

    void delete(CategoriaEntity categoria);
}
