package com.newsoft.controle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsoft.controle.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository <Usuario,Integer> {
	
	Optional <Usuario> findByNomeIgnoreCase(String nome);
	Optional <Usuario> findByLoginIgnoreCase(String login);
}
