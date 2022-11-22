package com.netbiis.wassabiapp_jsp.model.usecases.categoria;

import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;

import java.util.List;

public interface IFindAllCategoriaUsecase {
    List<CategoriaEntity> execute();
}
