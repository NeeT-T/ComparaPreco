package com.comparapreco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comparapreco.dtos.ProductDTO;
import com.comparapreco.services.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAll (
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "12") Integer size,
			@RequestParam(required = false, defaultValue = "ASC") String direction,
			@RequestParam(required = false, defaultValue = "name") String orderby
		) {
		
		try {
			return new ResponseEntity<Page<ProductDTO>>(productService.findAll(page, size, direction, orderby), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
	}
}
