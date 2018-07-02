package com.newsoft.controle.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsoft.controle.model.Chamado;
import com.newsoft.controle.model.enums.Status;
import com.newsoft.controle.repository.Chamados;

@Service
public class CadastroChamadoService {

	
	@Autowired
	Chamados chamados;
	
	//lembrar de salvar o status como false
	
	
	//só vai deixar salvar um chamado se o consultar pra onde o chamado tá indo, 
	//não tiver nenhum chamado com status pendente
	
	@Transactional
	public Chamado salvar (Chamado chamado) {

		try {
			chamado.setStatus(Status.PENDENTE);
			chamado.setDataPreenchimento((LocalDateTime.now()));
			Chamado retorno =  chamados.saveAndFlush(chamado);
			return retorno;
		} catch (Exception e) {
			return null;
		}
	}
}
