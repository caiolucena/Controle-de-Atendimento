package com.newsoft.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsoft.controle.model.Chamado;

public interface Chamados extends JpaRepository<Chamado,Integer> {

}
