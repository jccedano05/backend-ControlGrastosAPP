package net.jccedano92.cyvconstrucciones.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.jccedano92.cyvconstrucciones.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<ClienteEntity, Long> {

	
	ClienteEntity findById( long id );
	
	@Query(value = "SELECT * FROM cliente ORDER BY nombre ASC", nativeQuery = true)
	List<ClienteEntity> getAllClientes();
	

}



