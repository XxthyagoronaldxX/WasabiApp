package com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IUpdateCategoriaUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UpdateCategoriaHandle implements IHandle {
    private final IUpdateCategoriaUsecase updateCategoriaUsecase;

    public UpdateCategoriaHandle(IUpdateCategoriaUsecase updateCategoriaUsecase) {
        this.updateCategoriaUsecase = updateCategoriaUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleUpdateCategoriaEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    public void handleUpdateCategoriaEvent(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String image = request.getParameter("image");
        int categoriaid = Integer.parseInt(request.getParameter("categoriaid"));

        List<CategoriaEntity> categoriaEntityList = (List<CategoriaEntity>) request.getSession().getAttribute(AttributeUtil.CATEGORIALISTADMIN);
        CategoriaEntity categoriaEntity = new CategoriaEntity();

        for (CategoriaEntity categoria: categoriaEntityList) {
            if (categoria.getId() == categoriaid) {
                categoriaEntity = categoria;
            }
        }

        categoriaEntity.setNome(nome);
        categoriaEntity.setImage(image);

        updateCategoriaUsecase.execute(categoriaEntity);
    }
}
