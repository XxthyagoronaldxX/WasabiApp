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

public class DecrementProdutoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleDecrementProdutoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleDecrementProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));

        List<PedidoEntity> pedidos = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);

        pedidos = decrementProdutoInPedidoList(pedidos, id);

        session.setAttribute(AttributeUtil.PEDIDOLIST, pedidos);
    }

    private List<PedidoEntity> decrementProdutoInPedidoList(List<PedidoEntity> pedidos, int produtoid) {
        return pedidos.stream().peek(p -> {
            if (p.getProdutoByProdutoId().getId() == produtoid)
                p.decrementQuantidade();
        }).collect(Collectors.toList());
    }
}
