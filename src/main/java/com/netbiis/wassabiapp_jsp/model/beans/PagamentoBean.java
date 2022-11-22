package com.netbiis.wassabiapp_jsp.model.beans;

import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PagamentoBean implements Serializable {
    private Timestamp date;
    private List<ProdutoEntity> produtos;

    public PagamentoBean() {
        produtos = new ArrayList<>();
    }

    public double getTotal() {
        return produtos.stream().map(produto -> produto.getPreco().doubleValue() * produto.getQuantidadeSelected()).reduce(0.0, (acc, value) -> acc + value);
    }

    public Timestamp getDate() {
        return date;
    }

    public String getDateFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.date.toLocalDateTime().format(dtf);
    }

    public static List<PagamentoBean> makeHistoricoFromPedidos(List<PedidoEntity> pedidos) {
        pedidos = sortPedidosByCreatedAtDesc(pedidos);

        List<PagamentoBean> pagamentoBeanList = new ArrayList<>();

        PagamentoBean pagamentoBean = new PagamentoBean();

        Timestamp time_aux = pedidos.get(0).getCreatedAt();
        for (int i = 0; i < pedidos.size(); i++) {
            PedidoEntity pedido = pedidos.get(i);

            if (time_aux.equals(pedido.getCreatedAt())) {
                ProdutoEntity produto = pedido.getProdutoByProdutoId().clone();
                produto.setQuantidadeSelected(pedido.getQuantidade());

                pagamentoBean.addProduto(produto);

                if ((i + 1) == pedidos.size()) {
                    pagamentoBean.setDate(time_aux);
                    pagamentoBeanList.add(pagamentoBean);
                }
            } else {
                pagamentoBean.setDate(time_aux);
                pagamentoBeanList.add(pagamentoBean);
                time_aux = pedido.getCreatedAt();
                pagamentoBean = new PagamentoBean();

                ProdutoEntity produto = pedido.getProdutoByProdutoId().clone();
                produto.setQuantidadeSelected(pedido.getQuantidade());

                pagamentoBean.addProduto(produto);
            }
        }

        return pagamentoBeanList;
    }

    private static List<PedidoEntity> sortPedidosByCreatedAtDesc(List<PedidoEntity> pedidos) {
        return pedidos.stream().sorted((p1, p2) -> {
            if (p1.getCreatedAt().before(p2.getCreatedAt())) {
                return 1;
            } else if (p1.getCreatedAt().after(p2.getCreatedAt())) {
                return -1;
            }

            return 0;
        }).collect(Collectors.toList());
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void addProduto(ProdutoEntity produto) {
        produtos.add(produto);
    }

    public List<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}
