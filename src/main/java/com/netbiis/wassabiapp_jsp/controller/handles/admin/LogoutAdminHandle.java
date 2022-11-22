package com.netbiis.wassabiapp_jsp.controller.handles.admin;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogoutAdminHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleLogoutAdminEvent(request, response);
        } catch (Exception error) {
            response.sendRedirect(RouteUtil.ADMINHOMEVIEW);
        }
    }

    public void handleLogoutAdminEvent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();

        response.sendRedirect(RouteUtil.ADMINLOGINVIEW);
    }
}
