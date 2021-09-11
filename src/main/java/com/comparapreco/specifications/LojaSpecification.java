package com.comparapreco.specifications;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.comparapreco.models.Loja;

public class LojaSpecification implements Specification<Loja> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5567566379528654036L;
	private String nome;
	private String telefone;
	private String cnpj;
	private String localizacao;
	
	public LojaSpecification(String nome, String telefone, String cnpj, String localizacao) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCnpj(cnpj);
		this.setLocalizacao(localizacao);
	}

	@Override
	public Predicate toPredicate(Root<Loja> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    	ArrayList<Predicate> predicates = new ArrayList<Predicate>();
    	
    	if(this.nome != null) {
    		Predicate p = criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    		predicates.add(p);
    	}
    	if(this.telefone != null) {
    		Predicate p = criteriaBuilder.like(root.get("telefone"), "%" + telefone + "%");
    		predicates.add(p);
    	}
    	if(this.cnpj != null) {
    		Predicate p = criteriaBuilder.like(root.get("cnpj"), "%" + cnpj + "%");
    		predicates.add(p);
    	}
    	if(this.localizacao != null) {
    		Predicate p = criteriaBuilder.like(root.get("localizacao"), "%" + localizacao + "%");
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
