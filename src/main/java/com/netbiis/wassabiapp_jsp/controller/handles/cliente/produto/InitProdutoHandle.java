package com.netbiis.wassabiapp_jsp.controller.handles.cliente.produto;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IIndexProdutoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class InitProdutoHandle implements IHandle {
    private final IIndexProdutoUsecase indexProdutoUsecase;

    public InitProdutoHandle(IIndexProdutoUsecase indexProdutoUsecase) {
        this.indexProdutoUsecase = indexProdutoUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleInitProdutoEvent(request, response);
        } catch (Exception error) {
            response.sendError(500);
        }
    }

    private void handleInitProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        List<ProdutoEntity> produtos = this.indexProdutoUsecase.execute();

        List<ProdutoEntity> topBestSellers = produtos
                .stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        session.setAttribute(AttributeUtil.TOPTHREEBESTSELLERS, topBestSellers);
        session.setAttribute(AttributeUtil.PRODUTOLIST, produtos);
        session.setAttribute(AttributeUtil.PRODUTOLISTFILTERED, produtos);
    }
}
