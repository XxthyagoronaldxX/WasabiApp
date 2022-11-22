package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

public class CancelarPedidoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleCancelarPedidoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleCancelarPedidoEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute(AttributeUtil.PEDIDOLIST, new ArrayList<PedidoEntity>());
    }
}
