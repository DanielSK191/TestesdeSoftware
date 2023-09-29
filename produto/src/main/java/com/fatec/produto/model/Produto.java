package com.fatec.produto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String descricao;
	private String categoria;
	private double custo;
	private int quantidadeEstoque;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao == null) {
			throw new IllegalArgumentException("a descrição não pode estar em branco!");
		} else if(descricao.isBlank()) {
			throw new IllegalArgumentException("a descrição não pode estar em branco!");
		} else {
			this.descricao = descricao;
		}	
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
}
