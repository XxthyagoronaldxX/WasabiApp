package com.netbiis.wassabiapp_jsp.model.beans;

import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class ClienteInfoBean implements Comparable<ClienteInfoBean>{
    private ClienteEntity cliente;
    private List<PagamentoBean> historico;

    public ClienteInfoBean() { historico = new ArrayList<>(); }

    public String totalOfMoneySpended() {
        double total = this.historico.stream().map(PagamentoBean::getTotal).reduce(0.0, Double::sum);

        return String.format("%.2f", total);
    }

    public int totalOfOrders() {
        return this.historico.size();
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<PagamentoBean> getHistorico() {
        return historico;
    }

    public void setHistorico(List<PagamentoBean> historico) {
        this.historico = historico;
    }

    @Override
    public int compareTo(ClienteInfoBean o) {
        if (this.historico.size() == 0)
            return 1;
        if (o.getHistorico().size() == 0)
            return -1;

        if (this.historico.get(0).getDate().after(o.getHistorico().get(0).getDate())) {
            return -1;
        } else if (this.historico.get(0).getDate().before(o.getHistorico().get(0).getDate())) {
            return 1;
        }

        return 0;
    }
}
