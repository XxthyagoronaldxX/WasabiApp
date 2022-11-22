package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.admin;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.admin.AdminEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminController", value = "/AdminController")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case AdminEvent.LOGIN:
                HandleGetIt.loginAdminHandle.handle(request, response);
                break;
            case AdminEvent.LOGOUT:
                HandleGetIt.logoutAdminHandle.handle(request, response);
                break;
        }
    }
}
