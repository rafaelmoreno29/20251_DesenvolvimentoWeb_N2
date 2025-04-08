package com.example.projetoescola.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoescola.config.RegraNegocioException;
import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public CursoDTO salvar(CursoRequestDTO cursoDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(
                cursoDTO.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada."));

        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);

        Curso c = cursoRepository.save(curso);

        CursoDTO cursoResponse = new CursoDTO();
        cursoResponse.setId(c.getId());
        cursoResponse.setNome(c.getNome());
        return cursoResponse;
    }

}
