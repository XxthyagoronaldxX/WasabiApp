package com.netbiis.wassabiapp_jsp.controller.handles.admin.produto;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoHasCategoriaEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.ICreateProdutoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateProdutoHandle implements IHandle {
    private final ICreateProdutoUsecase createProdutoUsecase;

    public CreateProdutoHandle(ICreateProdutoUsecase createProdutoUsecase) {
        this.createProdutoUsecase = createProdutoUsecase;
    }


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleCreateProdutoEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    private void handleCreateProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String preco = request.getParameter("preco");
        String quantidade = request.getParameter("quantidade");
        String image = request.getParameter("image");
        int categoriaid = Integer.parseInt(request.getParameter("categoriaid"));

        List<CategoriaEntity> categoriaEntityList = (List<CategoriaEntity>) request.getSession().getAttribute(AttributeUtil.CATEGORIALISTADMIN);
        ProdutoHasCategoriaEntity phasc = new ProdutoHasCategoriaEntity();
        List<ProdutoHasCategoriaEntity> phascList = new ArrayList<>();
        ProdutoEntity produto = new ProdutoEntity();

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
        phascList.add(phasc);
        produto.setProdutoHasCategoriasById(phascList);

        createProdutoUsecase.execute(produto);
    }
}
