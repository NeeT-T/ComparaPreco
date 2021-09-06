package com.comparapreco.specifications;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.comparapreco.models.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
		this.nome = nome;
		this.preco = preco;
		this.nomeMarca = nomeMarca;
		this.nomeCategoria = nomeCategoria;
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
}

