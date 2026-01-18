package com.estudo.seguranca.springsecurity.entities;

import org.mapstruct.Mapper;

import com.estudo.seguranca.springsecurity.entities.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	Usuario toEntity(UserDTO userDTO);
	
	UserDTO toDTO(Usuario user);
}
