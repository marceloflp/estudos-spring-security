package com.estudo.seguranca.springsecurity.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.seguranca.springsecurity.entities.Usuario;
import com.estudo.seguranca.springsecurity.services.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

	private final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Usuario user) {
		service.salvar(user);
	}
	
	@GetMapping("/todos")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> salvar() {
		return service.todos();
	}
}
