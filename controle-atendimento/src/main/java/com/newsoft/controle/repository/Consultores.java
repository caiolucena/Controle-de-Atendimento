package com.newsoft.controle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsoft.controle.model.Consultor;

@Repository
public interface Consultores extends JpaRepository<Consultor, Integer> {

	
	Optional <Consultor> findByNomeIgnoreCase(String nome);
	
	
}
