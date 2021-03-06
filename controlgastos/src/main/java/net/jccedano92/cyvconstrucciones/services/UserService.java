package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.UserDto;
import net.jccedano92.cyvconstrucciones.entity.UserEntity;
import net.jccedano92.cyvconstrucciones.exceptions.EmailExistsException;
import net.jccedano92.cyvconstrucciones.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface{

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPassword;

	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserEntity userEntity = userRepository.findByEmail(email);
		
		if( userEntity == null ) {
			throw new UsernameNotFoundException(email);
		}

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}
	
	

	@Override
	public UserDto createUser(UserDto user) {
		
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new EmailExistsException("El email ya existe");
		}
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword(bCryptPassword.encode(user.getPassword()));
		
		UUID userId = UUID.randomUUID();
		
		userEntity.setUserId(userId.toString());
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto userToReturn = new UserDto();
		
		BeanUtils.copyProperties(storedUserDetails, userToReturn);
		
		return userToReturn;
	}


	
	

	@Override
	public UserDto getUser(String email) {

		UserEntity userEntity = userRepository.findByEmail(email);
		
		if( userEntity == null ) {
			throw new UsernameNotFoundException(email);
		}
		
		UserDto userToReturn = new UserDto();
		
		BeanUtils.copyProperties(userEntity, userToReturn);
		
		return userToReturn;
		
	}
	
	
	
	
}
