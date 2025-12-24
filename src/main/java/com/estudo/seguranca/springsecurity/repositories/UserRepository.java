package com.estudo.seguranca.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.seguranca.springsecurity.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
