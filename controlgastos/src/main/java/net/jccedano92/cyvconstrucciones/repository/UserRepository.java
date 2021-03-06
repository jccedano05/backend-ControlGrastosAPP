package net.jccedano92.cyvconstrucciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jccedano92.cyvconstrucciones.entity.UserEntity;

@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	
}
