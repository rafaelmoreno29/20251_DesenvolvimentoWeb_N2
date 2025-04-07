package com.example.atividade2;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade2.models.Autor;
import com.example.atividade2.models.Livro;
import com.example.atividade2.repositories.AutorRepository;
import com.example.atividade2.repositories.LivroRepository;

@SpringBootApplication
public class Atividade2Application {

	@Bean
	public CommandLineRunner run(AutorRepository autorRepo, LivroRepository livroRepo) {
		return args -> {
			Autor autor1 = new Autor("Machado de Assis");
			Autor autor2 = new Autor("Clarice Lispector");

			Livro l1 = new Livro("Dom Casmurro", 45.0, autor1);
			Livro l2 = new Livro("Memórias Póstumas", 30.0, autor1);
			Livro l3 = new Livro("A Hora da Estrela", 25.0, autor2);

			autor1.setLivros(Arrays.asList(l1, l2));
			autor2.setLivros(Arrays.asList(l3));

			autorRepo.saveAll(Arrays.asList(autor1, autor2));

			System.out.println("\n--- Livros com preço > 30 ---");
			livroRepo.findByPrecoGreaterThan(30.0).forEach(System.out::println);

			System.out.println("\n--- Livros com preço <= 30 ---");
			livroRepo.findByPrecoLessThanEqual(30.0).forEach(System.out::println);

			System.out.println("\n--- Livros que começam com 'D' ---");
			livroRepo.findByTituloStartingWith("D").forEach(System.out::println);

			System.out.println("\n--- Autores que começam com 'M' ---");
			autorRepo.findByNomeStartingWith("M").forEach(System.out::println);

			System.out.println("\n--- Buscar autor por ID com livros (LEFT JOIN FETCH) ---");
			Autor autorComLivros = autorRepo.buscarAutorComLivros(autor1.getId());
			System.out.println("Autor: " + autorComLivros.getNome());
			autorComLivros.getLivros().forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

}
