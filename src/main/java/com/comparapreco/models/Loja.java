package com.comparapreco.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lojas")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "localizacao")
	private String localizacao;
	
    @ManyToMany(mappedBy = "lojas", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "lojas", "produtos", "produtos" })
    private Set<Produto> produtos = new HashSet<>();

	public Loja() {}
	
	public Loja(Integer id, String nome, String telefone, String cnpj, String localizacao, Set<Produto> produtos) {
		this.setId(id);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCnpj(cnpj);
		this.setLocalizacao(localizacao);
		this.setProdutos(produtos);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
