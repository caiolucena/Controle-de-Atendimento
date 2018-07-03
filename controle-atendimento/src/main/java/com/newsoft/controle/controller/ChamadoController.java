package com.newsoft.controle.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newosft.controle.service.exception.ConsultorComChamadoPendenteException;
import com.newsoft.controle.model.Chamado;
import com.newsoft.controle.repository.Consultores;
import com.newsoft.controle.security.UsuarioSistema;
import com.newsoft.controle.service.CadastroChamadoService;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

	@Autowired
	Consultores consultores;
	
	@Autowired
	CadastroChamadoService cadastroChamadoService;
	
	@GetMapping("/novo")
	ModelAndView novo(Chamado chamado) {
		
		ModelAndView mv = new ModelAndView("chamado/CadastroChamado");
		mv.addObject("dataInicioPreenchimento", LocalDateTime.now());
		mv.addObject("consultores", consultores.findAll());
		
		return mv;
	}

	
	@PostMapping("/novo")
	ModelAndView salvar(@Valid Chamado chamado,BindingResult result, RedirectAttributes attributes,
			@AuthenticationPrincipal UsuarioSistema usuarioSistema) {
		
		if(result.hasErrors()) {
			return novo(chamado);
		}
			
		try {
			chamado.setUsuario(usuarioSistema.getUsuario());
			chamado.setNomeConsultor(consultores.findOne(chamado.getConsultor().getId()).getNome());
			cadastroChamadoService.salvar(chamado);
		}
		catch (ConsultorComChamadoPendenteException e){
			result.rejectValue("consultor", e.getMessage(),e.getMessage());
			return (novo(chamado));
		}
		attributes.addFlashAttribute("mensagem", "Chamado salvo com sucesso!");
		
		return new ModelAndView("redirect:/chamados/novo");
	}
}
