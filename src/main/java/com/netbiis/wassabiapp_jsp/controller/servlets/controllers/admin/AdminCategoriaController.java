package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.admin;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminCategoriaEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminCategoriaController", value = "/AdminCategoriaController")
public class AdminCategoriaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case AdminCategoriaEvent.FINDALLCATEGORIA:
                HandleGetIt.findAllCategoriaHandle.handle(request, response);
                break;
            case AdminCategoriaEvent.CREATECATEGORIA:
                HandleGetIt.createCategoriaHandle.handle(request, response);
                break;
            case AdminCategoriaEvent.REMOVECATEGORIA:
                HandleGetIt.removeCategoriaHandle.handle(request, response);
                break;
            case AdminCategoriaEvent.UPDATECATEGORIA:
                HandleGetIt.updateCategoriaHandle.handle(request, response);
                break;
            default:
                break;
        }
    }
}
