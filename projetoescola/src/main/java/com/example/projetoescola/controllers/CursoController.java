package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.services.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // @GetMapping()
    // public List<Curso> getTodosCursos() {
    // return cursoRepository.findAll();
    // }

    @PostMapping()
    public CursoDTO postCurso(@RequestBody CursoRequestDTO curso) {
        return cursoService.salvar(curso);
    }
}
