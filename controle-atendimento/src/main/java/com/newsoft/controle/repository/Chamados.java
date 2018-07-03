package com.newsoft.controle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsoft.controle.model.Chamado;

public interface Chamados extends JpaRepository<Chamado,Integer> {

	Optional<Chamado> findByNomeConsultorIgnoreCase(String nome);
}
