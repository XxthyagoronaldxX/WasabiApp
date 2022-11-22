package com.netbiis.wassabiapp_jsp.model.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "categoria", schema = "wasabi_db")
public class CategoriaEntity {
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
    @OneToMany(mappedBy = "categoriaByCategoriaId")
    private Collection<ProdutoHasCategoriaEntity> produtoHasCategoriasById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriaEntity that = (CategoriaEntity) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    public Collection<ProdutoHasCategoriaEntity> getProdutoHasCategoriasById() {
        return produtoHasCategoriasById;
    }

    public void setProdutoHasCategoriasById(Collection<ProdutoHasCategoriaEntity> produtoHasCategoriasById) {
        this.produtoHasCategoriasById = produtoHasCategoriasById;
    }
}
