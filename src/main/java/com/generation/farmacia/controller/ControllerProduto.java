package com.generation.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.farmacia.model.ModelProduto;
import com.generation.farmacia.repository.RepositoryProduto;


@RestController //
@RequestMapping ("/produto")
@CrossOrigin ("*")// recebe requisições de fora do dominio
public class ControllerProduto {
	
	@Autowired //quais classes serão instanciadas e onde serão
	private RepositoryProduto repositoryProduto;
	
	@GetMapping // SELECT*FROM tb_produtos;
	public ResponseEntity <List < ModelProduto>> getAll(){
		return ResponseEntity.ok(repositoryProduto.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <ModelProduto> getById (@PathVariable Long id){
		return repositoryProduto.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity <List<ModelProduto>> GetByNome(@PathVariable String nome){ // ResponseEntity é uma lista
		return ResponseEntity.ok(repositoryProduto.findAllByNomeContainingIgnoreCase(nome));
	}
	@PostMapping
	public ResponseEntity <ModelProduto> post (@RequestBody ModelProduto produto){ //RequestBody pega o que tem no corpo da requisição
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryProduto.save(produto));	
	}
	@PutMapping
	public ResponseEntity <ModelProduto> put (@RequestBody ModelProduto produto){ 
		return ResponseEntity.status(HttpStatus.OK).body(repositoryProduto.save(produto));
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable Long id) {
	Optional<ModelProduto> produto = repositoryProduto.findById(id);
		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	repositoryProduto.deleteById(id);
	}

}