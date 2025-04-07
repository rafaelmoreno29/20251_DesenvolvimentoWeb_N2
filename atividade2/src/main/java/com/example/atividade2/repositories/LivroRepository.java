package com.example.atividade2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade2.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByPrecoGreaterThan(Double valor);

    List<Livro> findByPrecoLessThanEqual(Double valor);

    List<Livro> findByTituloStartingWith(String titulo);
}