package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitCarrinhoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleInitCarrinhoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleInitCarrinhoEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        List<PedidoEntity> pedido = new ArrayList<>();

        session.setAttribute(AttributeUtil.PEDIDOLIST, pedido);
    }
}
