package com.comparapreco.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="produtos")
public class Produto implements Serializable {
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 4089388603729401078L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "id_categorias")
	private Categoria categoria;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "lojas_produtos",
    joinColumns = {
            @JoinColumn(name = "id_produtos", referencedColumnName = "id",
                    nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "id_lojas", referencedColumnName = "id",
                    nullable = false, updatable = false)})
	private Set<Loja> lojas;

	public Produto() {}

	public Produto(String nome, Double preco, Marca marca, Categoria categoria, Set<Loja> lojas) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setMarca(marca);
		this.setCategoria(categoria);
		this.setLojas(lojas);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(Set<Loja> lojas) {
		this.lojas = lojas;
	}
	
}
