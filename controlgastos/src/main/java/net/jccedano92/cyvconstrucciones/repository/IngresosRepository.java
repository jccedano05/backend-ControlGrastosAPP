package net.jccedano92.cyvconstrucciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.jccedano92.cyvconstrucciones.entity.IngresosEntity;

@Repository
public interface IngresosRepository  extends PagingAndSortingRepository<IngresosEntity, Long>{

	
	IngresosEntity findById( long id );
	
	@Query(value = "SELECT * FROM ingresos ORDER BY fecha_emision DESC", nativeQuery = true)
	List<IngresosEntity> getAllIngresos();
	
	
	@Query(value = "SELECT * FROM ingresos i WHERE i.id_proyecto = :proyecto ORDER BY fecha_emision DESC", nativeQuery = true)
	List<IngresosEntity> getAllIngresosWhereMatchProyectoId(@Param("proyecto") long proyectoId);


	
	
}
