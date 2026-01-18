package com.estudo.seguranca.springsecurity.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudo.seguranca.springsecurity.entities.Usuario;
import com.estudo.seguranca.springsecurity.repositories.UserRepository;

@Service
public class UsuarioService {

	private final UserRepository repository;
	private final PasswordEncoder encoder;
	
	public UsuarioService(UserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}
	
	public void salvar(Usuario user) {
		var senha = user.getSenha();
		user.setSenha(encoder.encode(senha));
		repository.save(user);
	}
	
	public Usuario obterPorLogin(String login) {
		return repository.findByLogin(login);
	}
	
	public List<Usuario> todos(){
		return repository.findAll();
	}
	
}
