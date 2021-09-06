package com.comparapreco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.comparapreco.models.Produto;

public interface IProductRepository extends JpaRepository<Produto, Integer>, JpaSpecificationExecutor<Produto> { }
