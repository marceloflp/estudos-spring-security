package com.estudo.seguranca.springsecurity.services.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.estudo.seguranca.springsecurity.entities.Usuario;
import com.estudo.seguranca.springsecurity.services.UsuarioService;

public class CustomUserDetailsService implements UserDetailsService{

	private final UsuarioService service;
	
	
	public CustomUserDetailsService(UsuarioService service) {
		super();
		this.service = service;
	}

	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user = service.obterPorLogin(login);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return User.builder()
				.username(user.getLogin())
				.password(user.getSenha())
				.roles(user.getRole())
				.build();
				
	}

}
