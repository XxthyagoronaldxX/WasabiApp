package com.netbiis.wassabiapp_jsp.model.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "produto", schema = "wasabi_db")
public class ProdutoEntity implements Serializable, Comparable<ProdutoEntity>, Cloneable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "preco")
    private BigDecimal preco;
    @Basic
    @Column(name = "quantidade")
    private Integer quantidade;
    @OneToMany(mappedBy = "produtoByProdutoId")
    private Collection<PedidoEntity> pedidosById;
    @OneToMany(mappedBy = "produtoByProdutoId")
    private Collection<ProdutoHasCategoriaEntity> produtoHasCategoriasById;
    @Transient
    private int quantidadeSelected = 0;
    @Transient
    private boolean isSelected = false;

    public void incrementQuantidadeSelected() {
        this.quantidadeSelected++;
    }

    public void decrementQuantidadeSelected() {
        this.quantidadeSelected--;
    }

    public int getQuantidadeSelected() {
        return quantidadeSelected;
    }

    public void setQuantidadeSelected(int quantidadeSelected) {
        this.quantidadeSelected = quantidadeSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Collection<PedidoEntity> getPedidosById() {
        return pedidosById;
    }

    public void setPedidosById(Collection<PedidoEntity> pedidosById) {
        this.pedidosById = pedidosById;
    }

    public Collection<ProdutoHasCategoriaEntity> getProdutoHasCategoriasById() {
        return produtoHasCategoriasById;
    }

    public void setProdutoHasCategoriasById(Collection<ProdutoHasCategoriaEntity> produtoHasCategoriasById) {
        this.produtoHasCategoriasById = produtoHasCategoriasById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoEntity that = (ProdutoEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public List<CategoriaEntity> getCategorias() {
        return this
                .getProdutoHasCategoriasById()
                .stream()
                .map(ProdutoHasCategoriaEntity::getCategoriaByCategoriaId)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(ProdutoEntity o) {
        if (this.getPedidosById().size() < o.getPedidosById().size()) {
            return 1;
        } else if (this.getPedidosById().size() > o.getPedidosById().size()) {
            return -1;
        }

        return 0;
    }

    @Override
    public ProdutoEntity clone() {
        try {
            return (ProdutoEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
