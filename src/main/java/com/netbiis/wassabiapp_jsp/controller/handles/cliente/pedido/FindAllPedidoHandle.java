package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.model.beans.PagamentoBean;
import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IIndexPedidoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class FindAllPedidoHandle implements IHandle {
    private final IIndexPedidoUsecase indexPedidoUsecase;

    public FindAllPedidoHandle(IIndexPedidoUsecase indexPedidoUsecase) {
        this.indexPedidoUsecase = indexPedidoUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleGetAllPedidosEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleGetAllPedidosEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        List<PedidoEntity> pedidos = indexPedidoUsecase.execute();

        if (pedidos != null) {
            if (pedidos.size() != 0) {
                List<PagamentoBean> pagamentoBeanList = PagamentoBean.makeHistoricoFromPedidos(pedidos);

                session.setAttribute(AttributeUtil.HISTORICOLIST, pagamentoBeanList);
            }
        }
    }
}
