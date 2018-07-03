package com.newsoft.controle.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newosft.controle.service.exception.ConsultorComChamadoPendenteException;
import com.newsoft.controle.model.Chamado;
import com.newsoft.controle.model.enums.Status;
import com.newsoft.controle.repository.Chamados;

@Service
public class CadastroChamadoService {

	@Autowired
	Chamados chamados;

	// lembrar de salvar o status como false
	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public Chamado salvar(Chamado chamado) {
		
		Optional <Chamado> chamadoPendente = chamados.findByNomeConsultorIgnoreCase(chamado.getNomeConsultor());
		if (chamadoPendente.isPresent()) {
			throw new ConsultorComChamadoPendenteException("Existe um chamado pendente para este Consultor!");
		} 
		try {
			chamado.setStatus(Status.PENDENTE);
			chamado.setDataPreenchimento((LocalDateTime.now()));

			if (chamado.getCliente().getId() == 0) {

				chamado.getCliente().setId(1);
			}
			
			System.out.println("Entrei no método");
			
			Chamado retorno = chamados.saveAndFlush(chamado);
			return retorno;
			// só vai deixar salvar um chamado se o consultar pra onde o chamado tá indo,
			// não tiver nenhum chamado com status pendente

		} catch (Exception e) {
			System.out.println("Entrei na exceção");
			return null;
		}
	}



}
