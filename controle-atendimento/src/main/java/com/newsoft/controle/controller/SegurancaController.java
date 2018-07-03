package com.newsoft.controle.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.newsoft.controle.model.Chamado;
import com.newsoft.controle.repository.Chamados;
import com.newsoft.controle.security.UsuarioSistema;

/**
 * Essa é a classe Controller da classe Seguranca, e é responsável por fazer a ponte entre as views referentes a esse objeto e os Models, de acordo com as solicitações realizadas nas rotas.
 * @author EquipeACL
 *
 */
@Controller
public class SegurancaController {

	@Autowired
	Chamados chamados;
	
	/**
	 * Esse é o método responsável pela autenticação do login do usuário.
	 * @param user, que são os dados do login do usuário
	 * @return "redirect:/tccs/novo", que redireciona o usuário para a página da biblioteca em caso do login estar correto
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@AuthenticationPrincipal UsuarioSistema user){
		if(user != null) {
			return "redirect:/index";
		}
		return "Login";
	}
	

	/**
	 * Esse método é responsável por retornar um erro caso o login do usuário esteja incorreto.
	 * @return 403, renderiza a página de erro 403
	 */
	@GetMapping("/403")
	public String acessoNegado() {
		return "403";
	}
	

	/**
	 * Esse método é responsável por renderizar a pagina inicial do sistema
	 * @return index, que é a pagina inicial da biblioteca
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView paginaInicial(@AuthenticationPrincipal UsuarioSistema user) {
		ModelAndView mv = new ModelAndView("index");
		
		Optional <Chamado> chamadosPendentes = chamados.findByNomeConsultorIgnoreCase(user.getUsuario().getNome());
		if(chamadosPendentes.isPresent()) {
			mv.addObject("chamadoPendente", "1");
		}
		else {
			mv.addObject("chamadoPendente", "0");
		}
		
		return mv;
	}
	
}
