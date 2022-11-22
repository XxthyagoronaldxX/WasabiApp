package com.netbiis.wassabiapp_jsp.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produto_has_categoria", schema = "wasabi_db")
public class ProdutoHasCategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    private CategoriaEntity categoriaByCategoriaId;
    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private ProdutoEntity produtoByProdutoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoHasCategoriaEntity that = (ProdutoHasCategoriaEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public CategoriaEntity getCategoriaByCategoriaId() {
        return categoriaByCategoriaId;
    }

    public void setCategoriaByCategoriaId(CategoriaEntity categoriaByCategoriaId) {
        this.categoriaByCategoriaId = categoriaByCategoriaId;
    }

    public ProdutoEntity getProdutoByProdutoId() {
        return produtoByProdutoId;
    }

    public void setProdutoByProdutoId(ProdutoEntity produtoByProdutoId) {
        this.produtoByProdutoId = produtoByProdutoId;
    }
}
