package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.admin;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminClienteEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminClienteController", value = "/AdminClienteController")
public class AdminClienteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case AdminClienteEvent.FINDALLCLIENTEINFO:
                HandleGetIt.findAllClienteInfoHandle.handle(request, response);
                break;
        }
    }
}
