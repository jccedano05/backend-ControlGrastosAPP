package net.jccedano92.cyvconstrucciones.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.jccedano92.cyvconstrucciones.dto.UserDto;

public interface UserServiceInterface  extends UserDetailsService{

	public UserDto createUser(UserDto user);
	
	public UserDto getUser(String email);
	
}
