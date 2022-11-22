package com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IFindAllCategoriaUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class FindAllCategoriaHandle implements IHandle {
    private final IFindAllCategoriaUsecase indexCategoriaUsecase;

    public FindAllCategoriaHandle(IFindAllCategoriaUsecase indexCategoriaUsecase) {
        this.indexCategoriaUsecase = indexCategoriaUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleFindAllCategoriaEvent(request, response);
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    public void handleFindAllCategoriaEvent(HttpServletRequest request, HttpServletResponse response) {
        List<CategoriaEntity> categoriaEntityList = indexCategoriaUsecase.execute();

        request.getSession().setAttribute(AttributeUtil.CATEGORIALISTADMIN, categoriaEntityList);
    }
}
