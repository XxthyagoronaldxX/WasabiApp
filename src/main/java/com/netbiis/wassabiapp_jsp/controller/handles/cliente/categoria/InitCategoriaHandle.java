package com.netbiis.wassabiapp_jsp.controller.handles.cliente.categoria;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.IInitCategoriaUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class InitCategoriaHandle implements IHandle {
    private final IInitCategoriaUsecase initCategoriaUsecase;

    public InitCategoriaHandle(IInitCategoriaUsecase initCategoriaUsecase) {
        this.initCategoriaUsecase = initCategoriaUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleInitCategoriaEvent(request, response);
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    private void handleInitCategoriaEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        List<CategoriaEntity> categorias = this.initCategoriaUsecase.execute();

        session.setAttribute(AttributeUtil.CATEGORIALIST, categorias);
    }
}
