package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.cliente;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ClienteController", value = "/ClienteController")
public class ClienteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case ClienteEvent.LOGIN:
                HandleGetIt.loginClienteHandle.handle(request, response);
                break;
            case ClienteEvent.LOGOUT:
                HandleGetIt.logoutClienteHandle.handle(request, response);
                break;
            case ClienteEvent.REGISTER:
                HandleGetIt.registerClienteHandle.handle(request, response);
                break;
            case ClienteEvent.EDIT:
                HandleGetIt.editClienteHandle.handle(request, response);
                break;
        }
    }
}
