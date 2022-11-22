package com.netbiis.wassabiapp_jsp.controller.handles.cliente;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogoutClienteHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleLogoutEvent(request, response);
        } catch (Exception error) {
            response.sendRedirect(RouteUtil.HOMEVIEW);
        }
    }

    private void handleLogoutEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        session.invalidate();

        response.sendRedirect(RouteUtil.LOGINVIEW);
    }
}
