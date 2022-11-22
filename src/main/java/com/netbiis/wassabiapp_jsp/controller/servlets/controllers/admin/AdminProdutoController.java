package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.admin;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminProdutoEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminProdutoController", value = "/AdminProdutoController")
public class AdminProdutoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case AdminProdutoEvent.FINDALLPRODUTO:
                HandleGetIt.findAllProdutoHandle.handle(request, response);
                break;
            case AdminProdutoEvent.CREATEPRODUTO:
                HandleGetIt.createProdutoHandle.handle(request, response);
                break;
            case AdminProdutoEvent.UPDATEPRODUTO:
                HandleGetIt.updateProdutoHandle.handle(request, response);
                break;
            case AdminProdutoEvent.REMOVEPRODUTO:
                HandleGetIt.removeProdutoHandle.handle(request, response);
                break;
            default:
                break;
        }
    }
}
