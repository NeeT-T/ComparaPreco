package com.comparapreco.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comparapreco.dtos.ProductDTO;
import com.comparapreco.models.Produto;
import com.comparapreco.repository.IProductRepository;
import com.comparapreco.specifications.ProdutoSpecification;

@Service
public class ProductService {

	@Autowired
	IProductRepository iProductRepository;
	
	public Page<ProductDTO> findAll(String nome, Double preco, String nomeMarca, String nomeCategoria, Integer page, Integer size, String direction, String orderby) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderby);
		
		ProdutoSpecification specification = new ProdutoSpecification(nome,preco,nomeMarca,nomeCategoria);
		
		// Qual o tipo de dado que o banco retorna? No caso de não haver o cast
		Page<Produto> productsFromDB = (Page<Produto>) iProductRepository.findAll(specification, pageRequest);

		List<ProductDTO> products = productsFromDB.stream()
				.map(product -> new ProductDTO(product)).collect(Collectors.toList());
		
		
		
		return new PageImpl<ProductDTO>(products, pageRequest, productsFromDB.getTotalElements());
		
	}
	
}
