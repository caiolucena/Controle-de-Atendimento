package com.newsoft.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsoft.controle.model.Cliente;

public interface Clientes  extends JpaRepository<Cliente,Integer>{

	
	
}
