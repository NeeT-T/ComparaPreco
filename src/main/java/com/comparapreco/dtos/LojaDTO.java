package com.comparapreco.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.comparapreco.models.Loja;
import com.comparapreco.models.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class LojaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Integer Id;
	private String nome;
	private String foto;
	private String telefone;
	private String cep;
	private String logradouro;
	private String latitude;
	private String longitude;
	@JsonIgnoreProperties("cnpj")
	private String cnpj;
	@JsonIgnoreProperties("lojas")
	private Set<Produto> produtos;

	public LojaDTO() {}
	
	public LojaDTO(Loja loja) {
		this.setId(loja.getId());
		this.setFoto(loja.getFoto());
		this.setNome(loja.getNome());
		this.setTelefone(loja.getTelefone());
		this.setCnpj(loja.getCnpj());
		this.setProdutos(loja.getProdutos());
		this.setCep(loja.getCep());
		this.setLogradouro(loja.getLogradouro());
		this.setLatitude(loja.getLatitude());
		this.setLongitude(loja.getLongitude());
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLatitude() {
		return latitude;
	}
	
	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
