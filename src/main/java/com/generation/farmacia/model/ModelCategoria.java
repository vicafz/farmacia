package com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "tb_categoria")
public class ModelCategoria {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //chave primária + auto-increment
	private Long id;
	
	@NotBlank (message = "O atributo categoria é obrigatório")
	private String Categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	
	

}
