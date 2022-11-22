package com.netbiis.wassabiapp_jsp.controller.handles.admin.produto;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IIndexProdutoUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllProdutoHandle implements IHandle {
    private final IIndexProdutoUsecase indexProdutoUsecase;

    public FindAllProdutoHandle(IIndexProdutoUsecase indexProdutoUsecase) {
        this.indexProdutoUsecase = indexProdutoUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleFindAllProdutoEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            response.sendError(500, error.getMessage());
        }
    }

    public void handleFindAllProdutoEvent(HttpServletRequest request, HttpServletResponse response) {
        List<ProdutoEntity> produtoEntityList = indexProdutoUsecase.execute();
        String filter = request.getParameter("filter");

        if (filter != null) {
            switch (filter) {
                case "1":
                    String nome = request.getParameter("nome");

                    produtoEntityList = filterProdutoByName(produtoEntityList, nome);
                    break;
                case "2":
                    String lessThanString = request.getParameter("lessthan");
                    String higherThanString = request.getParameter("higherthan");

                    if (!lessThanString.isEmpty() && !higherThanString.isEmpty()) {
                        produtoEntityList = filterProdutoByLessThanAndHigherThan(produtoEntityList, lessThanString, higherThanString);
                    } else if (!lessThanString.isEmpty()) {
                        produtoEntityList = filterProdutoByLessThan(produtoEntityList, lessThanString);
                    } else if (!higherThanString.isEmpty()) {
                        produtoEntityList = filterProdutoByHigherThan(produtoEntityList, higherThanString);
                    }
                    break;
                case "3":
                    int categoriaId = Integer.parseInt(request.getParameter("categoriaid"));

                    if (categoriaId != -1)
                        produtoEntityList = filterProdutoByCategoria(produtoEntityList, categoriaId);
                    break;
            }
        }


        request.getSession().setAttribute(AttributeUtil.PRODUTOLISTADMIN, produtoEntityList);
    }

    public List<ProdutoEntity> filterProdutoByCategoria(List<ProdutoEntity> produtoEntityList, int categoriaId) {
        return produtoEntityList
                .stream()
                .filter(p -> p
                        .getProdutoHasCategoriasById()
                        .stream()
                        .map(phc -> phc.getCategoriaByCategoriaId().getId())
                        .anyMatch(id -> categoriaId == id)
                ).collect(Collectors.toList());
    }

    public List<ProdutoEntity> filterProdutoByHigherThan(List<ProdutoEntity> produtoEntityList, String higherThan) {
        double higherthan = Double.parseDouble(higherThan);

        return produtoEntityList
                .stream()
                .filter(p -> p.getPreco().doubleValue() > higherthan)
                .collect(Collectors.toList());
    }

    public List<ProdutoEntity> filterProdutoByLessThan(List<ProdutoEntity> produtoEntityList, String lessThan) {
        double lessthan = Double.parseDouble(lessThan);

        return produtoEntityList
                .stream()
                .filter(p -> p.getPreco().doubleValue() < lessthan)
                .collect(Collectors.toList());
    }

    public List<ProdutoEntity> filterProdutoByLessThanAndHigherThan(List<ProdutoEntity> produtoEntityList, String lessThan, String higherThan) {
        double lessthan = Double.parseDouble(lessThan);
        double higherthan = Double.parseDouble(higherThan);

        if (lessthan <= higherthan)
            throw new IllegalArgumentException("FILTRO: O valor MENOR QUE não pode ser menor que o valor MAIOR QUE!");

        return produtoEntityList
                .stream()
                .filter(p -> p.getPreco().doubleValue() > higherthan && p.getPreco().doubleValue() < lessthan)
                .collect(Collectors.toList());
    }

    public List<ProdutoEntity> filterProdutoByName(List<ProdutoEntity> produtoEntityList, String nome) {
        return produtoEntityList.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}
