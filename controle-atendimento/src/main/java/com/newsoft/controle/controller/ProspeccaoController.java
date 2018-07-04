package com.newsoft.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newsoft.controle.model.Prospeccao;

@Controller
@RequestMapping("/prospeccao")
public class ProspeccaoController {

	
	@GetMapping("/nova")
	public  ModelAndView novo(Prospeccao prospeccao) {
		
		ModelAndView mv = new ModelAndView("prospeccao/CadastroProspeccao");
		
		return mv;
	}
}
