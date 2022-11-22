package com.netbiis.wassabiapp_jsp.controller.handles.cliente;

import com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteCategoriaEvent;
import com.netbiis.wassabiapp_jsp.controller.events.cliente.ClientePedidoEvent;
import com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteProdutoEvent;
import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.ILoginClienteUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginClienteHandle implements IHandle {
    private final ILoginClienteUsecase loginClienteUsecase;

    public LoginClienteHandle(ILoginClienteUsecase createClienteUsecase) {
        this.loginClienteUsecase = createClienteUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleLoginEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            System.out.println(error.getMessage());
            response.sendError(500, error.getMessage());
        }
    }

    private void handleLoginEvent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");

        ClienteEntity result = this.loginClienteUsecase.execute(cpf, senha);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/ClienteProdutoController?event=" + ClienteProdutoEvent.INITPRODUTO);
        dispatcher.include(request, response);
        dispatcher = request.getRequestDispatcher("/ClienteCategoriaController?event=" + ClienteCategoriaEvent.INITCATEGORIA);
        dispatcher.include(request, response);
        dispatcher = request.getRequestDispatcher("/ClientePedidoController?event=" + ClientePedidoEvent.INITCARRINHO);
        dispatcher.include(request, response);

        HttpSession session = request.getSession();
        session.setAttribute(AttributeUtil.CLIENTE, result);
    }
}
