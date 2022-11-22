package com.netbiis.wassabiapp_jsp.controller.handles.cliente.produto;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import com.netbiis.wassabiapp_jsp.core.utils.RouteUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterByCategoriaProdutoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleFilterByCategoriaEvent(request, response);
        } catch (Exception error) {
            response.sendRedirect(RouteUtil.HOMEVIEW);
        }
    }

    private void handleFilterByCategoriaEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();

        List<ProdutoEntity> produtos = (List<ProdutoEntity>) session.getAttribute(AttributeUtil.PRODUTOLIST);
        List<PedidoEntity> pedidos = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);

        if (id != -1) {
            produtos = produtos
                    .stream()
                    .filter(
                            produto -> produto.getCategorias()
                                    .stream()
                                    .anyMatch(categoria -> categoria.getId() == id)
                    ).collect(Collectors.toList());
        }

        for (ProdutoEntity produto: produtos) {
            produto.setSelected(false);
            produto.setQuantidadeSelected(1);

            for (PedidoEntity pedido: pedidos) {
                if (pedido.getProdutoByProdutoId().equals(produto)) {
                    produto.setSelected(true);
                    produto.setQuantidadeSelected(pedido.getQuantidade());
                }
            }
        }

        session.setAttribute(AttributeUtil.PRODUTOLISTFILTERED, produtos);

        response.sendRedirect(RouteUtil.PRODUCTLISTCOMPONENT);
    }
}
