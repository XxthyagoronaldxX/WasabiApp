package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class IncrementProdutoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleIncrementProdutoEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleIncrementProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));

        List<PedidoEntity> pedidos = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);

        List<PedidoEntity> updatedList = pedidos.parallelStream().peek(pedido -> {
            if (pedido.getProdutoByProdutoId().getId() == id) {
                if (pedido.getProdutoByProdutoId().getQuantidade() >= pedido.getQuantidade() + 1) {
                    pedido.setQuantidade(pedido.getQuantidade() + 1);
                } else {
                    throw new IllegalArgumentException("Limite de estoque!");
                }
            }
        }).collect(Collectors.toList());

        session.setAttribute(AttributeUtil.PEDIDOLIST, updatedList);
    }
}
