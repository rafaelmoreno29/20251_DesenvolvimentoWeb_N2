package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dto.CursoCompletoDTO;
import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO cursoDTO);

    List<CursoDTO> obterTodos();

    CursoCompletoDTO obterPorId(Long id);

    void remover(Long id);

    void editar(Long id, CursoRequestDTO dto);

}
