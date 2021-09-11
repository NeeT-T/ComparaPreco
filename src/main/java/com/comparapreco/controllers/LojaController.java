package com.comparapreco.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comparapreco.dtos.LojaDTO;
import com.comparapreco.services.LojaService;

@RestController
@RequestMapping("/v1/lojas")
@CrossOrigin
public class LojaController {
	
	@Autowired
	LojaService lojaService;
	
	@GetMapping
	public ResponseEntity<Page<LojaDTO>> findAll (
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "12") Integer size,
			@RequestParam(required = false, defaultValue = "ASC") String direction,
			@RequestParam(required = false, defaultValue = "nome") String orderby,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String telefone,
			@RequestParam(required = false) String cnpj,
			@RequestParam(required = false) String localizacao
		) {
		
		return new ResponseEntity<Page<LojaDTO>>(lojaService.findAll(nome, telefone, cnpj, localizacao, page, size, direction, orderby), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LojaDTO> findById (@PathVariable Integer id) {
		return new ResponseEntity<LojaDTO>(lojaService.findById(id), HttpStatus.OK);
	}
	
}
