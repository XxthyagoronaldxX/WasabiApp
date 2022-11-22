package com.netbiis.wassabiapp_jsp.controller.servlets.controllers.cliente;

import com.netbiis.wassabiapp_jsp.core.getit.HandleGetIt;
import com.netbiis.wassabiapp_jsp.controller.events.cliente.ClientePedidoEvent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ClientePedidoController", value = "/ClientePedidoController")
public class ClientePedidoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        switch (event) {
            case ClientePedidoEvent.INITCARRINHO:
                HandleGetIt.initCarrinhoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.ADDPRODUTOTOCARRINHO:
                HandleGetIt.addProdutoToCarrinhoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.GETSIZECARRINHO:
                HandleGetIt.getSizeCarrinhoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.INCREMENTPRODUTO:
                HandleGetIt.incrementProdutoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.DECREMENTPRODUTO:
                HandleGetIt.decrementProdutoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.REMOVEPRODUTOFROMCARRINHO:
                HandleGetIt.removeProdutoFromCarrinhoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.CANCELARPEDIDO:
                HandleGetIt.cancelarPedidoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.FINALIZARPEDIDO:
                HandleGetIt.finalizarPedidoHandle.handle(request, response);
                break;
            case ClientePedidoEvent.FINDALLPEDIDO:
                HandleGetIt.findAllPedidoFromClienteHandle.handle(request, response);
                break;
        }
    }
}
