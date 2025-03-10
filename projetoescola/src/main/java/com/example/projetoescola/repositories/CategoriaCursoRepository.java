package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public CategoriaCurso salvar(CategoriaCurso categoriaCurso) {
        return entityManager.merge(categoriaCurso);
    }

    public List<CategoriaCurso> obterTodos() {
        return entityManager.createQuery("FROM CategoriaCurso", CategoriaCurso.class).getResultList();
    }
}
