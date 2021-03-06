package net.jccedano92.cyvconstrucciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.jccedano92.cyvconstrucciones.entity.VendedorEntity;

@Repository
public interface VendedorRepository extends PagingAndSortingRepository<VendedorEntity, Long> {

	
	VendedorEntity findById( long id );
	
	@Query(value = "SELECT * FROM vendedor ORDER BY nombre ASC", nativeQuery = true)
	List<VendedorEntity> getAllVendedores();
}
