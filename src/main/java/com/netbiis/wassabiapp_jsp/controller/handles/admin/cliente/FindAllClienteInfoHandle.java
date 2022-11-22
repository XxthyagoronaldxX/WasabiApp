package com.netbiis.wassabiapp_jsp.controller.handles.admin.cliente;

import com.netbiis.wassabiapp_jsp.model.beans.ClienteInfoBean;
import com.netbiis.wassabiapp_jsp.model.beans.PagamentoBean;
import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.IFindAllClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IFindAllPedidoFromClienteUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllClienteInfoHandle implements IHandle {
    private final IFindAllClienteUsecase findAllClienteUsecase;
    private final IFindAllPedidoFromClienteUsecase findAllPedidoFromClienteUsecase;

    public FindAllClienteInfoHandle(IFindAllClienteUsecase findAllClienteUsecase, IFindAllPedidoFromClienteUsecase findAllPedidoFromClienteUsecase) {
        this.findAllClienteUsecase = findAllClienteUsecase;
        this.findAllPedidoFromClienteUsecase = findAllPedidoFromClienteUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleFindAllClienteEvent(request, response);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            response.sendError(500, error.getMessage());
        }
    }

    private void handleFindAllClienteEvent(HttpServletRequest request, HttpServletResponse response) {
        List<ClienteEntity> clienteEntityList = findAllClienteUsecase.execute();
        List<ClienteInfoBean> clienteInfoBeanList = new ArrayList<>();

        for (ClienteEntity cliente: clienteEntityList) {
            ClienteInfoBean clienteInfoBean = new ClienteInfoBean();

            clienteInfoBean.setCliente(cliente);

            List<PedidoEntity> pedidoEntityList = findAllPedidoFromClienteUsecase.execute(cliente.getId());

            if (!pedidoEntityList.isEmpty()) {
                clienteInfoBean.setHistorico(PagamentoBean.makeHistoricoFromPedidos(pedidoEntityList));
            }

            clienteInfoBeanList.add(clienteInfoBean);
        }

        clienteInfoBeanList = clienteInfoBeanList.stream().sorted().collect(Collectors.toList());

        request.getSession().setAttribute(AttributeUtil.CLIENTEINFOLIST, clienteInfoBeanList);
    }
}
