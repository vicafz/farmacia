package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.ModelProduto;

@Repository
public interface RepositoryProduto extends JpaRepository <ModelProduto, Long>{

	List <ModelProduto> findAllByNomeContainingIgnoreCase(String nome);
}