package com.newsoft.controle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsoft.controle.model.Usuario;
import com.newsoft.controle.repository.Usuarios;

import br.uepb.biblio.service.exception.ItemDuplicadoException;
import br.uepb.biblio.service.exception.LoginDuplicadoException;

@Service
public class CadastroUsuarioService {

	@Autowired
	Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Transactional
	public Usuario salvar (Usuario usuario) {
		Optional <Usuario> usuarioOptional = usuarios.findByNomeIgnoreCase(usuario.getNome());
		if(usuarioOptional.isPresent()){
			throw new ItemDuplicadoException(" Usuário já Cadastrado!");
		}
		
		usuarioOptional = usuarios.findByLoginIgnoreCase(usuario.getLogin());
		if(usuarioOptional.isPresent()) {
			throw new LoginDuplicadoException(" Já há um usuário cadastrado com este Login!");
		}
	
		usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		usuario.setConfirmacaoSenha(usuario.getSenha());
		try {
			Usuario retorno =  usuarios.saveAndFlush(usuario);
			return retorno;
		} catch (Exception e) {
			return null;
		}
	}

	
}
