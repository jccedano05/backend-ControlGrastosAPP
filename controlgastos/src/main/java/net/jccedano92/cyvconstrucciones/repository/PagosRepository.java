package net.jccedano92.cyvconstrucciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.jccedano92.cyvconstrucciones.entity.PagosEntity;

public interface PagosRepository extends PagingAndSortingRepository<PagosEntity, Long>{

	
	PagosEntity findById( long id );
	
	@Query(value = "SELECT * FROM pagos ORDER BY fecha_emision DESC", nativeQuery = true)
	List<PagosEntity> getAllPagos();
	
	
	@Query(value = "SELECT * FROM pagos p WHERE p.id_proyecto = :proyecto ORDER BY fecha_emision DESC", nativeQuery = true)
	List<PagosEntity> getAllPagosWhereMatchProyectoId(@Param("proyecto") long proyectoId);

	@Query(value = "SELECT * FROM pagos p WHERE p.id_vendedor = :vendedor ORDER BY fecha_emision DESC", nativeQuery = true)
	List<PagosEntity> getAllPagosWhereMatchVendedorId(@Param("vendedor") long vendedorId);

	
}
