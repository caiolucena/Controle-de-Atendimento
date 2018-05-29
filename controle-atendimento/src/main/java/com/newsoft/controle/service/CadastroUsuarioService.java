package com.newsoft.controle.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newosft.controle.service.exception.ItemDuplicadoException;
import com.newosft.controle.service.exception.LoginDuplicadoException;
import com.newsoft.controle.model.Usuario;
import com.newsoft.controle.repository.Usuarios;

@Service
public class CadastroUsuarioService {

	@Autowired
	Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PersistenceContext
    private EntityManager manager;
	
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

	@Transactional
	public List <String> permissoes(Usuario usuario){
	return manager.createQuery("select distinct p.nome from Usuario u inner join u.grupos g inner join g.permissoes p where u = :usuario",String.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}
	
}
