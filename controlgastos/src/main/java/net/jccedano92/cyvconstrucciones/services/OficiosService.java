package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.OficiosDto;
import net.jccedano92.cyvconstrucciones.entity.OficiosEntity;
import net.jccedano92.cyvconstrucciones.model.request.OficiosRequestModel;
import net.jccedano92.cyvconstrucciones.repository.OficiosRepository;

@Service
public class OficiosService implements OficiosServiceInterface{

	
	
	@Autowired
	OficiosRepository oficioRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	@Override
	public OficiosDto createOficio(OficiosRequestModel oficio) {

		
		OficiosEntity oficioEntity = new OficiosEntity();
		
		oficioEntity.setNombre( oficio.getNombre() );
		oficioEntity.setDescripcion( oficio.getDescripcion() );
		oficioEntity.setSueldo( oficio.getSueldo() );
		
		OficiosEntity createdoficio = oficioRepository.save( oficioEntity );
		
		OficiosDto oficioToReturn = mapper.map( createdoficio , OficiosDto.class);
		
		return oficioToReturn;
	}
	
	
	@Override
	public List<OficiosDto> getAllOficios() {

		List<OficiosEntity> oficiosEntities = oficioRepository.getAllOficios();
		
		List<OficiosDto> oficiosDtos = new ArrayList<>();
		
		for( OficiosEntity o : oficiosEntities) {
			
			OficiosDto oficio = mapper.map(o, OficiosDto.class);
			
			oficiosDtos.add(oficio);
			
		}
		
		return oficiosDtos;
	}

	
	
	

	@Override
	public OficiosDto getOficioById(long id) {

		OficiosEntity oficioEntity = oficioRepository.findById( id );
		
		OficiosDto oficiosDto = mapper.map(oficioEntity, OficiosDto.class);
		
		return oficiosDto;
	}
	
	
	


	@Override
	public void deleteOficio(long id) {

		OficiosEntity oficioEntity = oficioRepository.findById( id );
		
		oficioRepository.delete( oficioEntity );
		
		
	}


	@Override
	public OficiosDto updateOficio(long id, OficiosRequestModel oficioRequestModel) {

		
		OficiosEntity oficioEntity = oficioRepository.findById( id );
		
		
		oficioEntity.setNombre(oficioRequestModel.getNombre());
		oficioEntity.setDescripcion(oficioRequestModel.getDescripcion());
		oficioEntity. setSueldo(oficioRequestModel.getSueldo());
		
		OficiosEntity updatedOficio = oficioRepository.save(oficioEntity);
		
		OficiosDto oficioToReturn = mapper.map(updatedOficio, OficiosDto.class);
		
		return oficioToReturn;
	}

}
