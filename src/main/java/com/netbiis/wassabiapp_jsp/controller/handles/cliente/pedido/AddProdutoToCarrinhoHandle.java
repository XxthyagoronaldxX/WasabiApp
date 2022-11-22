package com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AddProdutoToCarrinhoHandle implements IHandle {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleAddProdutoToCarrinhoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleAddProdutoToCarrinhoEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        int produtoid = Integer.parseInt(request.getParameter("produtoid"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        List<ProdutoEntity> produtoList = (List<ProdutoEntity>) session.getAttribute(AttributeUtil.PRODUTOLIST);
        List<PedidoEntity> pedidoList = (List<PedidoEntity>) session.getAttribute(AttributeUtil.PEDIDOLIST);
        ClienteEntity cliente = (ClienteEntity) session.getAttribute(AttributeUtil.CLIENTE);

        boolean isAlreadyAddedToCart = produtoList.stream()
                .filter(p -> p.getId() == produtoid)
                .anyMatch(ProdutoEntity::isSelected);

        if (isAlreadyAddedToCart) {
            pedidoList = updateProdutoInPedidoList(pedidoList, produtoid, quantidade);
        } else {
            PedidoEntity pedido = new PedidoEntity();

            for (ProdutoEntity produto : produtoList)
                if (produto.getId() == produtoid)
                    pedido.setProdutoByProdutoId(produto);

            pedido.setClienteByClienteId(cliente);
            pedido.setQuantidade(quantidade);

            pedidoList.add(pedido);
        }

        session.setAttribute(AttributeUtil.PEDIDOLIST, pedidoList);
    }

    private List<PedidoEntity> updateProdutoInPedidoList(List<PedidoEntity> pedidos, int produtoid, int quantidade) {
        return pedidos.stream().peek(p -> {
            ProdutoEntity produto = p.getProdutoByProdutoId();

            if (produto.getId() == produtoid)
                p.setQuantidade(quantidade);
        }).collect(Collectors.toList());
    }
}
