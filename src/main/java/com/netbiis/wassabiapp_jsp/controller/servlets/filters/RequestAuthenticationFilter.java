package com.netbiis.wassabiapp_jsp.controller.servlets.filters;

import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebFilter("/RequestAuthenticationFilter")
public class RequestAuthenticationFilter implements Filter{
    private ServletContext context;

    @Override
    public void init(FilterConfig filter) throws ServletException {
        Filter.super.init(filter);
        context = filter.getServletContext();
        context.log("Iniciando Filter [RequestAuthenticationFilter]");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        ClienteEntity cliente = (ClienteEntity) request.getSession().getAttribute(AttributeUtil.CLIENTE);
        LocalDate date = LocalDate.now();

        if (cliente == null) {
            context.log("Unauthorized access request! [" + date + "]");

            response.sendRedirect(request.getContextPath() + "/" + RouteUtil.LOGINVIEW);
        } else {
            context.log("Authorized access request! [" + date + "]");
            chain.doFilter(request, response);
        }
    }
}
