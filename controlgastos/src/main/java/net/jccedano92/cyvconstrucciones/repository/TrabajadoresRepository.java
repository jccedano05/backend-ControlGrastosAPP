package net.jccedano92.cyvconstrucciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.jccedano92.cyvconstrucciones.entity.TrabajadoresEntity;

public interface TrabajadoresRepository extends PagingAndSortingRepository<TrabajadoresEntity, Long>{

	
	TrabajadoresEntity findById( long id );
	
	@Query(value = "SELECT * FROM trabajadores ORDER BY apellido_paterno ASC", nativeQuery = true)
	List<TrabajadoresEntity> getAllTrabajadores();
	
	
	@Query(value = "SELECT * FROM trabajadores t WHERE t.id_proyecto = :proyecto ORDER BY apellido_paterno ASC", nativeQuery = true)
	List<TrabajadoresEntity> getAllTrabajadoresWhereMatchProyectoId(@Param("proyecto") long proyectoId);

	@Query(value = "SELECT * FROM trabajadores t WHERE t.id_oficio = :oficio ORDER BY apellido_paterno ASC", nativeQuery = true)
	List<TrabajadoresEntity> getAllTrabajadoresWhereMatchOficioId(@Param("oficio") long oficioId);
	
}
