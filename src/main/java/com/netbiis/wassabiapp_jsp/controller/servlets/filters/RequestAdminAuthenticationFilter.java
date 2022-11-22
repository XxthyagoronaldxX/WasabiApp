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

@WebFilter(filterName = "RequestAdminAuthenticationFilter")
public class RequestAdminAuthenticationFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig filter) throws ServletException {
        Filter.super.init(filter);
        context = filter.getServletContext();
        context.log("Iniciando Filter [RequestAuthenticationFilter]");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        AdminEntity admin = (AdminEntity) request.getSession().getAttribute(AttributeUtil.ADMIN);
        LocalDate date = LocalDate.now();

        if (admin == null) {
            context.log("Unauthorized admin access request! [" + date + "]");

            response.sendRedirect(request.getContextPath() + "/" + RouteUtil.ADMINLOGINVIEW);
        } else {
            context.log("Authorized admin access request! [" + date + "]");

            chain.doFilter(request, response);
        }
    }
}
