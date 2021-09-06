package com.comparapreco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comparapreco.dtos.ProdutoDTO;
import com.comparapreco.services.ProdutoService;

@RestController
@RequestMapping("/v1/produtos")
@CrossOrigin
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findAll (
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "12") Integer size,
			@RequestParam(required = false, defaultValue = "ASC") String direction,
			@RequestParam(required = false, defaultValue = "nome") String orderby,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) Double preco,
			@RequestParam(required = false) String nomeMarca,
			@RequestParam(required = false) String nomeCategoria
		) {
		
		try {
			return new ResponseEntity<Page<ProdutoDTO>>(produtoService.findAll(nome, preco, nomeMarca, nomeCategoria, page, size, direction, orderby), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
	}
}
