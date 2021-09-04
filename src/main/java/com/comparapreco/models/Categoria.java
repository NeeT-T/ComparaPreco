package com.comparapreco.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="Category")
public class Categoria {
	
	@Id
	private int id;
	
	@Column(name = "")
	private String nome;
	
	public Categoria() {}
	
	public Categoria(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
