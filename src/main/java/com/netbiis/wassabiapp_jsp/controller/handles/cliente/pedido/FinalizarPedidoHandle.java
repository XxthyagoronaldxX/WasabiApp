package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.ICreatePedidoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FinalizarPedidoHandle implements IHandle {
    private final ICreatePedidoUsecase createPedidoUsecase;

    public FinalizarPedidoHandle(ICreatePedidoUsecase createPedidoUsecase) {
        this.createPedidoUsecase = createPedidoUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleFinalizarPedidoEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleFinalizarPedidoEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String senha = request.getParameter("senha");
        ClienteEntity cliente = (ClienteEntity) session.getAttribute(AttributeUtil.CLIENTE);

        if (cliente.getSenha().equals(senha)) {
            List<PedidoEntity> pedidos = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);
            Timestamp date = Timestamp.valueOf(LocalDateTime.now());

            pedidos.forEach(pedido -> {
                pedido.setCreatedAt(date);

                createPedidoUsecase.execute(pedido);
            });

            session.setAttribute(AttributeUtil.PEDIDOLIST, new ArrayList<PedidoEntity>());
        } else {
            throw new IllegalArgumentException("SENHA: Senha incorreta!");
        }
    }
}
