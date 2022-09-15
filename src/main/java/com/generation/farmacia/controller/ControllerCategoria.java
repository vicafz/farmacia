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

import com.generation.farmacia.model.ModelCategoria;
import com.generation.farmacia.repository.RepositoryCategoria;

@RestController //
@RequestMapping ("/produto")
@CrossOrigin ("*")
public class ControllerCategoria {
	@Autowired //quais classes serão instanciadas e onde serão
	private RepositoryCategoria repositoryCategoria;
	
	@GetMapping // SELECT*FROM tb_produtos;
	public ResponseEntity <List < ModelCategoria>> getAll(){
		return ResponseEntity.ok(repositoryCategoria.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity <ModelCategoria> getById (@PathVariable Long id){
		return repositoryCategoria.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/categoria/{categoria}")
	public ResponseEntity <List<ModelCategoria>> GetByCategoria(@PathVariable String categoria){ // ResponseEntity é uma lista
		return ResponseEntity.ok(repositoryCategoria.findAllByCategoriaContainigIgnoreCase(categoria));
	}
	
	@PostMapping
	public ResponseEntity <ModelCategoria> post (@RequestBody ModelCategoria categoria){ //RequestBody pega o que tem no corpo da requisição
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));	
	}
	@PutMapping
	public ResponseEntity <ModelCategoria> put (@RequestBody ModelCategoria categoria){ 
		return ResponseEntity.status(HttpStatus.OK).body(repositoryCategoria.save(categoria));
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable Long id) {
	Optional<ModelCategoria> categoria = repositoryCategoria.findById(id);
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	repositoryCategoria.deleteById(id);
	}
}