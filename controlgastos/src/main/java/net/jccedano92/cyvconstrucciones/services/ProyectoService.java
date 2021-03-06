package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.ProyectoDto;
import net.jccedano92.cyvconstrucciones.entity.ClienteEntity;
import net.jccedano92.cyvconstrucciones.entity.ProyectoEntity;
import net.jccedano92.cyvconstrucciones.model.request.ProyectoRequestModel;
import net.jccedano92.cyvconstrucciones.repository.ClienteRepository;
import net.jccedano92.cyvconstrucciones.repository.ProyectoRepository;

@Service
public class ProyectoService implements ProyectoServiceInterface{

	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	
	@Override
	public ProyectoDto createProyecto(ProyectoRequestModel proyecto) {

		
		ClienteEntity clienteEntity = clienteRepository.findById( proyecto.getClienteId());
		
		ProyectoEntity proyectoEntity = new ProyectoEntity();
		
		proyectoEntity.setCliente( clienteEntity );
		
		proyectoEntity.setNombre( proyecto.getNombre( ));
		proyectoEntity.setEstado( proyecto.getEstado() );
		proyectoEntity.setCiudad( proyecto.getCiudad() );
		proyectoEntity.setDescripcion( proyecto.getDescripcion() );
		
		ProyectoEntity createdProyecto = proyectoRepository.save(proyectoEntity);
		
		ProyectoDto proyectoToReturn = mapper.map(createdProyecto, ProyectoDto.class);
		
		return proyectoToReturn;
	}




	@Override
	public List<ProyectoDto> getAllProyectos() {

		List<ProyectoEntity> proyectosEntities = proyectoRepository.getAllProyectos();
		
		List<ProyectoDto> proyectosDtos = new ArrayList<>();
		
		for( ProyectoEntity p : proyectosEntities) {
			
			ProyectoDto proyecto = mapper.map(p, ProyectoDto.class);
			
			proyectosDtos.add(proyecto);
			
		}
		
		return proyectosDtos;
	}




	@Override
	public ProyectoDto getProyectoById(long id) {

		ProyectoEntity proyectoEntity = proyectoRepository.findById( id );
		
		ProyectoDto proyectoDto = mapper.map(proyectoEntity, ProyectoDto.class);
		
		return proyectoDto;
	}




	@Override
	public void deleteProyecto(long id) {

		ProyectoEntity proyectoEntity = proyectoRepository.findById( id );
		
		proyectoRepository.delete( proyectoEntity );
		
	}




	@Override
	public ProyectoDto updateProyecto(long id, ProyectoRequestModel proyecto) {

		ProyectoEntity proyectoEntity = proyectoRepository.findById( id );
		
		ClienteEntity clienteEntity = clienteRepository.findById( proyecto.getClienteId());
		
		
		proyectoEntity.setCliente( clienteEntity );
		
		proyectoEntity.setNombre( proyecto.getNombre( ));
		proyectoEntity.setEstado( proyecto.getEstado() );
		proyectoEntity.setCiudad( proyecto.getCiudad() );
		proyectoEntity.setDescripcion( proyecto.getDescripcion() );
		
		ProyectoEntity updatedProyecto = proyectoRepository.save(proyectoEntity);
		
		ProyectoDto ProyectoToReturn = mapper.map(updatedProyecto, ProyectoDto.class);
		
		return ProyectoToReturn;
		
	}




	@Override
	public List<ProyectoDto> getAllProyectosWhereMatchClienteId(long clienteId) {

		List<ProyectoEntity> proyectosEntities = proyectoRepository.getAllProyectosWhereMatchClienteId(clienteId);
		
		List<ProyectoDto> proyectosDtos = new ArrayList<>();
		
		for( ProyectoEntity p : proyectosEntities) {
			
			ProyectoDto proyecto = mapper.map(p, ProyectoDto.class);
			
			proyectosDtos.add(proyecto);
			
		}
		
		return proyectosDtos;
		
	}
	
	


}



























