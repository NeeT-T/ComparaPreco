package com.comparapreco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.comparapreco.models.Loja;

public interface ILojaRepository extends JpaRepository<Loja, Integer>, JpaSpecificationExecutor<Loja> {}
