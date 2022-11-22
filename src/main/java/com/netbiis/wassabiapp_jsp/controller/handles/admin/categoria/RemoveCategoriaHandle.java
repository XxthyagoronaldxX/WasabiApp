package com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IRemoveCategoriaUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class RemoveCategoriaHandle implements IHandle {
    private final IRemoveCategoriaUsecase removeCategoriaUsecase;

    public RemoveCategoriaHandle(IRemoveCategoriaUsecase removeCategoriaUsecase) {
        this.removeCategoriaUsecase = removeCategoriaUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleCreateCategoriaEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            System.out.println(error.getMessage());
            response.sendError(500, error.getMessage());
        }
    }

    public void handleCreateCategoriaEvent(HttpServletRequest request, HttpServletResponse response) {
        int categoriaid = Integer.parseInt(request.getParameter("categoriaid"));

        List<CategoriaEntity> categoriaEntityList = (List<CategoriaEntity>) request.getSession().getAttribute(AttributeUtil.CATEGORIALISTADMIN);
        CategoriaEntity categoriaEntity = new CategoriaEntity();

        for (CategoriaEntity categoria: categoriaEntityList) {
            if (categoria.getId() == categoriaid) {
                categoriaEntity = categoria;
            }
        }

        removeCategoriaUsecase.execute(categoriaEntity);
    }
}
