package com.dambroski.primeiro_projeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dambroski.primeiro_projeto.domain.Categoria;
import com.dambroski.primeiro_projeto.repositories.CategoriaRepository;

@SpringBootApplication
public class PrimeiroProjetoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
