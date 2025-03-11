package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository,
			@Autowired PessoaRepository pessoaRepository) {
		return args -> {
			cursoRepository.salvar(
					new Curso(null, "teste", 2000));
			cursoRepository.salvar(
					new Curso(null, "teste2", 2050));
			List<Curso> listaCursos = cursoRepository.obterTodos();
			System.out.println("*** Cursos cadastrados:");
			listaCursos.forEach(System.out::println);
			System.out.println("*** Inserir Categoria:");
			CategoriaCurso categ = categoriaRepository.salvar(
					new CategoriaCurso(null, "Informática"));
			System.out.println("*** Vincular Categoria ao curso ***");
			Curso curso = cursoRepository.obterTodos().get(0);
			curso.setCategoriaCurso(categ);
			cursoRepository.salvar(curso);
			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa = pessoaRepository.salvar(
					new Pessoa(null, "João"));

			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa2 = pessoaRepository.salvar(
					new Pessoa(null, "maria"));

			System.out.println("*** Vincular pessoa ao curso ***");
			curso.addPessoa(pessoa);
			curso.addPessoa(pessoa2);

			cursoRepository.salvar(curso);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
