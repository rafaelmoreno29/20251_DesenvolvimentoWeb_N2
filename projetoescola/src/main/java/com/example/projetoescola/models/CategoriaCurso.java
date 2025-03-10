package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.OneToMany;

public class CategoriaCurso {
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "categoriaCurso")
    private List<Curso> cursos;

    public CategoriaCurso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaCurso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
