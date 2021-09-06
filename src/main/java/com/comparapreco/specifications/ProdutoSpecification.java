package com.comparapreco.specifications;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.comparapreco.models.Produto;

public class ProdutoSpecification implements Specification<Produto> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2372225102071359411L;
	
	private String nome;
    private Double preco;
    private String nomeMarca;
    private String nomeCategoria;

	public ProdutoSpecification() {}

	public ProdutoSpecification(String nome, Double preco, String nomeCategoria, String nomeMarca) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setNomeCategoria(nomeCategoria);
		this.setNomeMarca(nomeMarca);
	}

	@Override
    public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    	ArrayList<Predicate> predicates = new ArrayList<Predicate>();
    	
    	if(this.nome != null) {
    		Predicate p = criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    		predicates.add(p);
    	}
    	if(this.preco != null) {
    		Predicate p = criteriaBuilder.equal(root.get("preco"), preco);
    		predicates.add(p);
    	}
    	if(this.nomeMarca != null) {
    		Predicate p = criteriaBuilder.like(root.get("nomeMarca"), "%" + nomeMarca + "%");
    		predicates.add(p);
    	}
    	if(this.nomeCategoria != null) {
    		Predicate p = criteriaBuilder.like(root.get("nomeCategoria"), "%" + nomeCategoria + "%");
    		predicates.add(p);
    	}
    	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		
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

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

