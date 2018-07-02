package com.newsoft.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newsoft.controle.model.Chamado;
import com.newsoft.controle.repository.Consultores;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

	@Autowired
	Consultores consultores;
	
	@GetMapping("/novo")
	ModelAndView novo(Chamado chamado) {
		
		ModelAndView mv = new ModelAndView("chamado/CadastroChamado");
		
		mv.addObject("consultores", consultores.findAll());
		
		
		return mv;
	}
	
}
