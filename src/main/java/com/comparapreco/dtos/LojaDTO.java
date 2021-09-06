package com.comparapreco.dtos;

import java.util.HashSet;
import java.util.Set;

import com.comparapreco.models.Loja;
import com.comparapreco.models.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class LojaDTO {
	
	private Integer Id;
	private String nome;
	private String telefone;
//	@JsonIgnoreProperties("cnpj")
	private String cnpj;
	private String localizacao;
	@JsonIgnoreProperties("lojas")
	private Set<Produto> produtos = new HashSet<Produto>();

	public LojaDTO() {}
	
	public LojaDTO(Loja loja) {
		this.setId(loja.getId());
		this.setNome(loja.getNome());
		this.setTelefone(loja.getTelefone());
		this.setCnpj(loja.getCnpj());
		this.setLocalizacao(loja.getLocalizacao());
		this.setProdutos(loja.getProdutos());
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
