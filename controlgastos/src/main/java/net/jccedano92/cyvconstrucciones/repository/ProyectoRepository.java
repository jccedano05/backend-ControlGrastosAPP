package net.jccedano92.cyvconstrucciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.jccedano92.cyvconstrucciones.entity.ProyectoEntity;

@Repository
public interface ProyectoRepository extends PagingAndSortingRepository<ProyectoEntity, Long>{

	
	ProyectoEntity findById( long id );
	
	@Query(value = "SELECT * FROM proyecto ORDER BY nombre ASC", nativeQuery = true)
	List<ProyectoEntity> getAllProyectos();
	
	
	@Query(value = "SELECT * FROM proyecto p WHERE p.id_cliente = :cliente ORDER BY nombre ASC", nativeQuery = true)
	List<ProyectoEntity> getAllProyectosWhereMatchClienteId(@Param("cliente") long clienteId);
	
}
