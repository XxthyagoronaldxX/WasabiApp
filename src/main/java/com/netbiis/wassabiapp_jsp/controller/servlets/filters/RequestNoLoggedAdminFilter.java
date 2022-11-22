package com.netbiis.wassabiapp_jsp.controller.servlets.filters;

import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebFilter(filterName = "RequestNoLoggedAdminFilter")
public class RequestNoLoggedAdminFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        context = config.getServletContext();
        context.log("Iniciando Filter [RequestNoLoggedAdminFilter]");
    }

    @Override
    public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) requestServlet;
        HttpServletResponse response = (HttpServletResponse) responseServlet;

        AdminEntity admin = (AdminEntity) request.getSession().getAttribute(AttributeUtil.ADMIN);
        LocalDate date = LocalDate.now();

        if (admin != null) {
            context.log("Admin already logged access request! [" + date + "]");

            response.sendRedirect( request.getContextPath() + "/" + RouteUtil.ADMINHOMEVIEW);
        } else {
            chain.doFilter(request, response);
        }
    }
}
