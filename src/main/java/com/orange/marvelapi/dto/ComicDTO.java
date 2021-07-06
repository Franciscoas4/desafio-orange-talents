package com.orange.marvelapi.dto;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class ComicDTO {

    private Long codigo;
    private Long comicId;

    @Size(min = 1, max = 255)
    private String titulo;

    private Double preco;

    @Size(min = 1, max = 255)
    private String criadores;

    @Size(min = 1, max = 255)
    private String isbn;

    @Size(min = 1, max = 255)
    private String descricao;


    private String desconto;

    private boolean descontoAtivo;

    public ComicDTO() {}

    public ComicDTO(Long codigo, Long comicId, @Size(min = 1, max = 255) String titulo, Double preco, @Size(min = 1, max = 255) String criadores, @Size(min = 1, max = 255) String isbn, @Size(min = 1, max = 255) String descricao, String desconto, boolean descontoAtivo) {
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
}
