package com.comparapreco.dtos;

import com.comparapreco.models.Produto;

public class ProductDTO {
	
	private String nome;
	private Double preco;
	private String nomeMarca;
	private String nomeCategoria;
	
	
	
	public ProductDTO(Produto produto) {
		setNome(produto.getNome());
		setPreco(produto.getPreco());
		setNomeMarca(produto.getMarca().getNome());
		setNomeCategoria(produto.getCategoria().getNome());
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



	public String getNomeMarca() {
		return nomeMarca;
	}



	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}



	public String getNameCategory() {
		return nomeCategoria;
	}



	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}



	