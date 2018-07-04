package com.newsoft.controle.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsoft.controle.model.Cidade;
import com.newsoft.controle.repository.Cidades;


@Service
public class CadastroCidadeService {
	private static Logger logger = Logger.getLogger(CadastroCidadeService.class);
	@Autowired
	private Cidades cidades;
	
	@PersistenceContext
    private EntityManager manager;
	
	/**
	 * Esse é o método responsável por realizar buscas por UF no banco de dados
	 * @param uf, que é a String contendo a UF 
	 * @return List<Cidade> contendo o(s) objeto(s) referente(s) a busca
	 */
	@Transactional
	public List<Cidade> buscarPorUf(String uf){
		return manager.createQuery("select e from Cidade e where e.uf = '"+uf+"'",Cidade.class).getResultList();
	}
	
	/**
	 * Esse é o método responsável por fazer uma busca por nome no banco de dados
	 * @param busca, que é a String que contém o parâmetro de busca por Cidade no banco de dados
	 * @return List<Cidade> contendo o(s) objeto(s) referente(s) à busca
	 */
	@Transactional
	public Cidade buscarPorNome(String nome){
		return manager.createQuery("select e from Cidade e where e.nome = '"+nome+"'",Cidade.class).getSingleResult();
	}
	

	public List<Cidade> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return manager.createQuery("select e from Cidade e where e.estado.id = '"+id+"'",Cidade.class).getResultList();
	}

}