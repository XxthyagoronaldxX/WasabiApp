package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.cliente;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteCategoriaEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ClienteCategoriaController", value = "/ClienteCategoriaController")
public class ClienteCategoriaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case ClienteCategoriaEvent.INITCATEGORIA:
                HandleGetIt.initCategoriaHandle.handle(request, response);
                break;
            default:
                break;
        }
    }
}
