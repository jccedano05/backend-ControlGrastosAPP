package net.jccedano92.cyvconstrucciones.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.jccedano92.cyvconstrucciones.dto.UserDto;
import net.jccedano92.cyvconstrucciones.model.request.UserDetailRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.UserRest;
import net.jccedano92.cyvconstrucciones.services.UserServiceInterface;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceInterface userService;
	
	
	@GetMapping (produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE } )
	public UserRest getUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //accedemos al contexto de la aplicacion y obtenemos la autentificacion
		
		String email = authentication.getPrincipal().toString();  //obtenemos el usuario del subject que mandamos al postear
		
		UserDto userDto = userService.getUser(email);
		
		UserRest userToReturn = new UserRest();
		
		BeanUtils.copyProperties(userDto, userToReturn);
		
		return userToReturn;
		
	}
	
	
	@PostMapping (produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE } )
	public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {
		
		UserRest userToReturn = new UserRest();
		
		UserDto userDto = new UserDto();
		userDto.setId((long) 1);
		userDto.setUserId("");
		userDto.setEncryptedPassword("");
		
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		
		BeanUtils.copyProperties(createdUser, userToReturn);
		
		return userToReturn;
		
		
		
	}
	
}
