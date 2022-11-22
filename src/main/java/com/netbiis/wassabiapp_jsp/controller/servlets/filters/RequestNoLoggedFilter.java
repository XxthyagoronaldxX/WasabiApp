package com.netbiis.wassabiapp_jsp.controller.servlets.filters;

import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebFilter(filterName = "RequestNoLoggedFilter")
public class RequestNoLoggedFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        context = config.getServletContext();
        context.log("Iniciando Filter [RequestNoLoggedFilter]");
    }

    @Override
    public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) requestServlet;
        HttpServletResponse response = (HttpServletResponse) responseServlet;

        ClienteEntity cliente = (ClienteEntity) request.getSession().getAttribute(AttributeUtil.CLIENTE);
        LocalDate date = LocalDate.now();

        if (cliente != null) {
            context.log("User already logged access request! [" + date + "]");

            response.sendRedirect( request.getContextPath() + "/" + RouteUtil.HOMEVIEW);
        } else {
            chain.doFilter(request, response);
        }
    }
}
