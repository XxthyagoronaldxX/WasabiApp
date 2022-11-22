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

public class RemoveProdutoFromCarrinhoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleRemoveProdutoCarrinhoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleRemoveProdutoCarrinhoEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));

        List<PedidoEntity> pedidos = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);

        pedidos = removeProdutoInPedidoList(pedidos, id);

        session.setAttribute(AttributeUtil.PEDIDOLIST, pedidos);
    }

    private List<PedidoEntity> removeProdutoInPedidoList(List<PedidoEntity> pedidos, int id) {
        return pedidos
                .stream()
                .filter(pedido -> pedido.getProdutoByProdutoId().getId() != id)
                .collect(Collectors.toList());
    }
}
