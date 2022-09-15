package com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity //Entidade = gera uma tabela no db
@Table(name = "tb_produtos") //nome da tabela no db
public class ModelProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //chave primária + auto-increment
	private Long id;
	
	@NotBlank(message= "O atributo nome é Obrigatorio")
	//@Size (max= 100, message= "O atributo nome deve conter no minimo 03 e no máximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "O atributo não pode ser nulo")
	//@Size ( max= 5, message = "O atributo nome deve ter no minimo 03 e no maximo 05")
	private Double preco;
	
	@NotNull(message = "O atributo não pode ser nulo")
	//@Size ( max= 1000, message = "O atributo nome deve ter no minimo 01 e no maximo 1000")
	private int quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
}