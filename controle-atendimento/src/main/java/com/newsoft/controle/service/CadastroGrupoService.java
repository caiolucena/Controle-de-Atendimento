package com.newsoft.controle.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 * Essa é a classe de Serviço do Grupo, que contém os métodos responsáveis por realizar buscas desse objeto no banco de dados.
 * @author Newsoft
 *
 */
@Service
public class CadastroGrupoService {
	
	@PersistenceContext
	private EntityManager manager;
	
}
