package com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.ICreateCategoriaUsecase;

import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreateCategoriaHandle implements IHandle {
    private final ICreateCategoriaUsecase createCategoriaUsecase;

    public CreateCategoriaHandle(ICreateCategoriaUsecase createCategoriaUsecase) {
        this.createCategoriaUsecase = createCategoriaUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AdminEntity admin = (AdminEntity) request.getSession().getAttribute(AttributeUtil.ADMIN);

        try {
            handleCreateCategoriaEvent(request, response);

        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    public void handleCreateCategoriaEvent(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String image = request.getParameter("image");

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setNome(nome);
        categoriaEntity.setImage(image);

        createCategoriaUsecase.execute(categoriaEntity);
    }
}
