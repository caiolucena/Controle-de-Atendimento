package com.newsoft.controle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsoft.controle.model.Consultor;
import com.newsoft.controle.model.Grupo;

@Repository
public interface Consultores extends JpaRepository<Consultor, Integer> {

	
	Optional <Grupo> findByNomeIgnoreCase(String nome);
	
	
}
