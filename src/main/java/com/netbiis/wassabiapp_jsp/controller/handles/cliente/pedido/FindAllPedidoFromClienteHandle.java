package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.model.beans.PagamentoBean;
import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IFindAllPedidoFromClienteUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class FindAllPedidoFromClienteHandle implements IHandle {
    private final IFindAllPedidoFromClienteUsecase findAllPedidoFromClienteUsecase;

    public FindAllPedidoFromClienteHandle(IFindAllPedidoFromClienteUsecase findAllPedidoFromClienteUsecase) {
        this.findAllPedidoFromClienteUsecase = findAllPedidoFromClienteUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleGetAllPedidosEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleGetAllPedidosEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        ClienteEntity cliente = (ClienteEntity) session.getAttribute(AttributeUtil.CLIENTE);
        List<PedidoEntity> pedidos = findAllPedidoFromClienteUsecase.execute(cliente.getId());

        if (pedidos != null) {
            if (pedidos.size() != 0) {
                List<PagamentoBean> pagamentoBeanList = PagamentoBean.makeHistoricoFromPedidos(pedidos);

                session.setAttribute(AttributeUtil.HISTORICOLIST, pagamentoBeanList);

                return;
            }
        }

        throw new IllegalArgumentException("PAGAMENTO: Sem pagamentos realizados!");
    }
}
