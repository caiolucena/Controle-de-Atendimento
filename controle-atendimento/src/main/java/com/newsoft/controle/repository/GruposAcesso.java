package com.newsoft.controle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsoft.controle.model.GrupoAcesso;

@Repository
public interface GruposAcesso extends JpaRepository<GrupoAcesso,Integer>{
	
	Optional <GrupoAcesso> findByNomeIgnoreCase(String nome);
	
}
