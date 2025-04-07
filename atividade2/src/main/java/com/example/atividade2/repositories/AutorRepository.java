package com.example.atividade2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.atividade2.models.Autor;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNomeStartingWith(String nome);

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.livros WHERE a.id = :id")
    Autor buscarAutorComLivros(Long id);
}
