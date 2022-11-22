package com.netbiis.wassabiapp_jsp.controller.handles.admin;

import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminCategoriaEvent;
import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminClienteEvent;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminProdutoEvent;
import com.netbiis.wassabiapp_jsp.model.usecases.admin.ILoginAdminUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginAdminHandle implements IHandle {
    private final ILoginAdminUsecase loginAdminUsecase;

    public LoginAdminHandle(ILoginAdminUsecase loginAdminUsecase) {
        this.loginAdminUsecase = loginAdminUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleLoginAdminEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    public void handleLoginAdminEvent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        AdminEntity adminEntity = loginAdminUsecase.execute(username, senha);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminProdutoController?event=" + AdminProdutoEvent.FINDALLPRODUTO);
        dispatcher.include(request, response);
        dispatcher = request.getRequestDispatcher("/AdminCategoriaController?event=" + AdminCategoriaEvent.FINDALLCATEGORIA);
        dispatcher.include(request, response);
        dispatcher = request.getRequestDispatcher("/AdminClienteController?event=" + AdminClienteEvent.FINDALLCLIENTEINFO);
        dispatcher.include(request, response);

        request.getSession().setAttribute(AttributeUtil.ADMIN, adminEntity);
    }
}
