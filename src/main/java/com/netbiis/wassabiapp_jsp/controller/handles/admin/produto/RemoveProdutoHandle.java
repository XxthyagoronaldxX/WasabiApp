package com.netbiis.wassabiapp_jsp.controller.handles.admin.produto;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IRemoveProdutoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class RemoveProdutoHandle implements IHandle {
    private final IRemoveProdutoUsecase removeProdutoUsecase;

    public RemoveProdutoHandle(IRemoveProdutoUsecase removeProdutoUsecase) {
        this.removeProdutoUsecase = removeProdutoUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleRemoveProdutoEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    private void handleRemoveProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        int produtoid = Integer.parseInt(request.getParameter("produtoid"));

        HttpSession session = request.getSession();
        List<ProdutoEntity> produtoEntityList = (List<ProdutoEntity>) session.getAttribute(AttributeUtil.PRODUTOLISTADMIN);
        ProdutoEntity produto = new ProdutoEntity();

        for (ProdutoEntity p: produtoEntityList) {
            if (p.getId() == produtoid) {
                produto = p;
            }
        }

        removeProdutoUsecase.execute(produto);
    }
}
