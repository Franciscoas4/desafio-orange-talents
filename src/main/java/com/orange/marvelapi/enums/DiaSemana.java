package com.orange.marvelapi.enums;

public enum DiaSemana {

    SEGUNDA_FEIRA(2),
    TERCA_FEIRA(3),
    QUARTA_FEIRA(4),
    QUINTA_FEIRA(5),
    SEXTA_FEIRA(6),

    SEGUNDA("Segunda-feira"),
    TERCA("Terca-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira");

    private Integer semanaDia;
    private String nome;

    DiaSemana(Integer semanaDia) {
        this.semanaDia = semanaDia;
    }

    DiaSemana(String nome) {
        this.nome = nome;
    }

    public Integer getSemanaDia() {
        return semanaDia;
    }

    public String getNome() {
        return nome;
    }
}
