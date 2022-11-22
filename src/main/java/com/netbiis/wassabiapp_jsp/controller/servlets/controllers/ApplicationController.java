package com.netbiis.wassabiapp_jsp.controller.servlets.controllers;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ApplicationController", value = "/ApplicationController")
public class ApplicationController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HandleGetIt.init();
            response.sendRedirect(RouteUtil.LOGINVIEW);
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }
}
