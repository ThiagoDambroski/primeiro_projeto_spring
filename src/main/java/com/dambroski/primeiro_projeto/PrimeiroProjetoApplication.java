package com.dambroski.primeiro_projeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dambroski.primeiro_projeto.domain.Categoria;
import com.dambroski.primeiro_projeto.domain.Cidade;
import com.dambroski.primeiro_projeto.domain.Cliente;
import com.dambroski.primeiro_projeto.domain.Endereco;
import com.dambroski.primeiro_projeto.domain.Estado;
import com.dambroski.primeiro_projeto.domain.Produto;
import com.dambroski.primeiro_projeto.domain.enums.TipoCliente;
import com.dambroski.primeiro_projeto.repositories.CategoriaRepository;
import com.dambroski.primeiro_projeto.repositories.CidadeRepository;
import com.dambroski.primeiro_projeto.repositories.ClienteRepository;
import com.dambroski.primeiro_projeto.repositories.EnderecoRepository;
import com.dambroski.primeiro_projeto.repositories.EstadoRepository;
import com.dambroski.primeiro_projeto.repositories.ProdutoRepository;

@SpringBootApplication
public class PrimeiroProjetoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"impressora",800.00);
		Produto p3 = new Produto(null,"mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria silva","maria@gmail.com","36376542377",TipoCliente.PessoaFisica);
		
		cli1.getTelefones().addAll(Arrays.asList("123123412","23312442"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","apto203","jardim","38220",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida matos","105","Sala 800","Centro","38130",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		

	}

}
