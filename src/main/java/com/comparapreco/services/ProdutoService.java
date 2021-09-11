package com.comparapreco.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comparapreco.dtos.ProdutoDTO;
import com.comparapreco.models.Produto;
import com.comparapreco.repository.IProductRepository;
import com.comparapreco.specifications.ProdutoSpecification;

@Service
public class ProdutoService {

	@Autowired
	IProductRepository iProductRepository;
	
	@Cacheable("produtos")
	public Page<ProdutoDTO> findAll( String nome, Double preco, String marca, String categoria, Integer page, Integer size, String direction, String orderby) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderby);
		ProdutoSpecification specification = new ProdutoSpecification(nome, preco, marca, categoria);
		Page<Produto> produtosFromDB = (Page<Produto>) iProductRepository.findAll(specification, pageRequest);  // Qual o tipo de dado que o banco retorna? No caso de não haver o cast
		List<ProdutoDTO> produtos = produtosFromDB.stream()
				.map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
		return new PageImpl<ProdutoDTO>(produtos, pageRequest, produtosFromDB.getTotalElements());
	}
	
	public ProdutoDTO findById(Integer id) {
		Optional<Produto> optional = iProductRepository.findById(id);
		if (optional.isPresent()) {
			return new ProdutoDTO(optional.get());
		}
		return null;
	}
}
