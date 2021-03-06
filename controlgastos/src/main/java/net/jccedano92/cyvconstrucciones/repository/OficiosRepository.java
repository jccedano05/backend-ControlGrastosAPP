package net.jccedano92.cyvconstrucciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.jccedano92.cyvconstrucciones.entity.OficiosEntity;

@Repository
public interface OficiosRepository extends PagingAndSortingRepository<OficiosEntity, Long> {

	
	OficiosEntity findById( long id );
	
	@Query(value = "SELECT * FROM oficios ORDER BY titulo ASC", nativeQuery = true)
	List<OficiosEntity> getAllOficios();
}
