package com.estudo.seguranca.springsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudo.seguranca.springsecurity.entities.User;
import com.estudo.seguranca.springsecurity.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		
		User user = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Erro genérico: User não encontrado"));
		
		return user;
	}
	
	public User createUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(Long id, User user) {
		try {
			User userUpdate = repository.findById(id)
					.orElseThrow(() -> new RuntimeException("Erro genérico: User não encontrado"));
			
			update(userUpdate, user);
			
			return repository.save(userUpdate);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar");
		}
	}

	private void update(User userUpdate, User user) {
		userUpdate.setEmail(user.getEmail());
		userUpdate.setNome(user.getNome());
		userUpdate.setSenha(user.getSenha());
	}
	
	public void deleteUser(Long id) {
		try {
			
			if(!repository.existsById(id)) throw new RuntimeException("User de ID " + id + " não existe!");
			repository.deleteById(id);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar");
		}
	}
	
}
