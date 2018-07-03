package com.newsoft.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newosft.controle.service.exception.ItemDuplicadoException;
import com.newosft.controle.service.exception.LoginDuplicadoException;
import com.newosft.controle.service.exception.SenhaObrigatoriaUsuarioException;
import com.newsoft.controle.model.Usuario;
import com.newsoft.controle.repository.GruposAcesso;
import com.newsoft.controle.service.CadastroUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	GruposAcesso grupos;

	@Autowired
	CadastroUsuarioService cadastroUsuarioService;
	@GetMapping("/novo")
	public ModelAndView novo(Usuario usuario) {

		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());

		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView cadastro(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(usuario);
		}
		// salvar o usuario
		try {
			cadastroUsuarioService.salvar(usuario);
		}
		catch (ItemDuplicadoException e){
			result.rejectValue("nome", e.getMessage(),e.getMessage());
			return (novo(usuario));
		}
		catch(LoginDuplicadoException e) {
			result.rejectValue("login", e.getMessage(),e.getMessage());
			return (novo(usuario));
		}
		catch(SenhaObrigatoriaUsuarioException e){
			result.rejectValue("senha", e.getMessage(),e.getMessage());
		}

		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");

		return new ModelAndView("redirect:/usuarios/novo");

	}
}
