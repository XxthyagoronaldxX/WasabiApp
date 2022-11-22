package com.netbiis.wassabiapp_jsp.controller.handles.admin.produto;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoHasCategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IUpdateProdutoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class UpdateProdutoHandle implements IHandle {
    private final IUpdateProdutoUsecase updateProdutoUsecase;

    public UpdateProdutoHandle(IUpdateProdutoUsecase updateProdutoUsecase) {
        this.updateProdutoUsecase = updateProdutoUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleUpdateProdutoEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    private void handleUpdateProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String preco = request.getParameter("preco");
        String quantidade = request.getParameter("quantidade");
        String image = request.getParameter("image");
        int produtoid = Integer.parseInt(request.getParameter("produtoid"));
        int categoriaid = Integer.parseInt(request.getParameter("categoriaid"));

        HttpSession session = request.getSession();
        List<ProdutoEntity> produtoEntityList = (List<ProdutoEntity>) session.getAttribute(AttributeUtil.PRODUTOLISTADMIN);
        List<CategoriaEntity> categoriaEntityList = (List<CategoriaEntity>) session.getAttribute(AttributeUtil.CATEGORIALISTADMIN);
        ProdutoEntity produto = new ProdutoEntity();

        for (ProdutoEntity p: produtoEntityList) {
            if (p.getId() == produtoid) {
                produto = p;
            }
        }

        ProdutoHasCategoriaEntity phasc = ((List<ProdutoHasCategoriaEntity>) produto.getProdutoHasCategoriasById()).get(0);

        produto.setQuantidade(Integer.parseInt(quantidade));
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(BigDecimal.valueOf(Double.parseDouble(preco)));
        produto.setImage(image);
        for (CategoriaEntity categoria: categoriaEntityList) {
            if (categoria.getId() == categoriaid) {
                phasc.setProdutoByProdutoId(produto);
                phasc.setCategoriaByCategoriaId(categoria);
            }
        }

        updateProdutoUsecase.execute(produto);
    }
}
