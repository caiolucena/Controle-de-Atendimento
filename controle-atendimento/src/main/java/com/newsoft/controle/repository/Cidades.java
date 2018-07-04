package com.newsoft.controle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsoft.controle.model.Cidade;

public interface Cidades extends JpaRepository <Cidade,Integer>{
	
		Optional<Cidade> findByNomeIgnoreCase(String nome);
}
