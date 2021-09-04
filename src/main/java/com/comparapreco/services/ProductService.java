package com.comparapreco.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comparapreco.dtos.ProductDTO;
import com.comparapreco.models.Product;
import com.comparapreco.repository.IProductRepository;
import com.comparapreco.specifications.ProductSpeficication;

@Service
public class ProductService {

	@Autowired
	IProductRepository iProductRepository;
	
	public Page<ProductDTO> findAll(Integer page, Integer size, String direction, String orderby) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderby);
		ProductSpeficication specification = new ProductSpeficication();
		// Qual o tipo de dado que o banco retorna? No caso de não haver o cast
		Page<Product> productsFromDB = (Page<Product>) iProductRepository.findAll(specification, pageRequest);

		List<ProductDTO> products = productsFromDB.stream()
				.map(product -> new ProductDTO(product)).collect(Collectors.toList());
		
		return new PageImpl<ProductDTO>(products, pageRequest, productsFromDB.getTotalElements());
		
	}
	
}
