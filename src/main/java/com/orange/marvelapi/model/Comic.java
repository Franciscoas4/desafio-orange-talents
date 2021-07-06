package com.orange.marvelapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "comics")
public class Comic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_comic")
    private Long codigo;
    @Column(name = "comic_id")
    private Long comicId;

    private String titulo;
    private Double preco;
    private String criadores;
    private String isbn;
    private String descricao;
    private String desconto;
    private boolean descontoAtivo;

    public Comic() {}

    public Comic(Long codigo, Long comicId, String titulo, Double preco, String criadores, String isbn, String descricao, String desconto, boolean descontoAtivo) {
        this.codigo = codigo;
        this.comicId = comicId;
        this.titulo = titulo;
        this.preco = preco;
        this.criadores = criadores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.desconto = desconto;
        this.descontoAtivo = descontoAtivo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCriadores() {
        return criadores;
    }

    public void setCriadores(String criadores) {
        this.criadores = criadores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public boolean isDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comic comic = (Comic) o;
        return descontoAtivo == comic.descontoAtivo && codigo.equals(comic.codigo) && comicId.equals(comic.comicId) && titulo.equals(comic.titulo) && preco.equals(comic.preco) && criadores.equals(comic.criadores) && isbn.equals(comic.isbn) && descricao.equals(comic.descricao) && desconto.equals(comic.desconto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, comicId, titulo, preco, criadores, isbn, descricao, desconto, descontoAtivo);
    }
}
