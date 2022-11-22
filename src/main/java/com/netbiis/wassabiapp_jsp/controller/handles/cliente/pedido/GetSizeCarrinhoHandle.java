package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class GetSizeCarrinhoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleGetSizeCarrinhoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleGetSizeCarrinhoEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        List<PedidoEntity> pedidos = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);

        response.getWriter().print(pedidos.size());
    }
}
