package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.ModelCategoria;

@Repository
public interface RepositoryCategoria extends JpaRepository <ModelCategoria, Long>{
	
	List<ModelCategoria> findAllByCategoriaContainigIgnoreCase (String categoria);

}