package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.admin;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminPedidoEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminPedidoController", value = "/AdminPedidoController")
public class AdminPedidoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case AdminPedidoEvent.FINDALLPEDIDO:
                HandleGetIt.findAllPedidoHandle.handle(request, response);
                break;
        }
    }
}
