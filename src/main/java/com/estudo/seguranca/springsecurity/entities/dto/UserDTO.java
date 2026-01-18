package com.estudo.seguranca.springsecurity.entities.dto;

import java.util.List;

public record UserDTO(String login, String senha, List<String> roles) {

}
