package com.estudo.seguranca.springsecurity.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.seguranca.springsecurity.entities.User;
import com.estudo.seguranca.springsecurity.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll(){
		List<User> users = service.findAll();
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User userAdd = service.createUser(user);
		
		return ResponseEntity.ok(userAdd);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		user = service.updateUser(id, user);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		service.deleteUser(id);
		
		return ResponseEntity.noContent().build();
	}
}
