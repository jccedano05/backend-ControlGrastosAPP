package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.IngresosDto;
import net.jccedano92.cyvconstrucciones.entity.IngresosEntity;
import net.jccedano92.cyvconstrucciones.entity.ProyectoEntity;
import net.jccedano92.cyvconstrucciones.model.request.IngresosRequestModel;
import net.jccedano92.cyvconstrucciones.repository.IngresosRepository;
import net.jccedano92.cyvconstrucciones.repository.ProyectoRepository;
import net.jccedano92.cyvconstrucciones.utils.DateFormatJCCV;

@Service
public class IngresosService implements IngresosServiceInterface{
	
	@Autowired
	IngresosRepository ingresosRepository;
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	
	@Autowired
	ModelMapper mapper;
	
	
	
	
	@Override
	public IngresosDto createIngreso(IngresosRequestModel ingreso) {

		
		ProyectoEntity proyectoEntity = proyectoRepository.findById( ingreso.getProyectoId());

		
		IngresosEntity ingresoEntity = new IngresosEntity();
		
		
		ingresoEntity.setProyecto(proyectoEntity);
		
		ingresoEntity.setFechaEmision(DateFormatJCCV.ParseStringToDate(ingreso.getFechaEmision())); //convertir a date
		
		ingresoEntity.setNumeroFactura(ingreso.getNumeroFactura());
		
		ingresoEntity.setCosto(ingreso.getCosto());
		
		ingresoEntity.setDescripcion(ingreso.getDescripcion());
		
		
		
		IngresosEntity createdIngreso = ingresosRepository.save(ingresoEntity);
		
		IngresosDto ingresoToReturn = mapper.map(createdIngreso, IngresosDto.class);
		
		return ingresoToReturn;
	}




	@Override
	public List<IngresosDto> getAllIngresos() {
		
		List<IngresosEntity> ingresosEntity = ingresosRepository.getAllIngresos();
		
		List<IngresosDto> ingresosDtos = new ArrayList<>();
		
		for( IngresosEntity t : ingresosEntity) {
			
			IngresosDto ingreso = mapper.map(t, IngresosDto.class);
			
			ingresosDtos.add(ingreso);
			
		}	
		return ingresosDtos;
	}




	@Override
	public IngresosDto getIngresoById(long id) {
		
		IngresosEntity ingresoEntity = ingresosRepository.findById( id );
		
		IngresosDto ingresoDtos = mapper.map(ingresoEntity, IngresosDto.class);
		
		return ingresoDtos;
	}




	@Override
	public void deleteIngreso(long id) {

		IngresosEntity ingresoEntity = ingresosRepository.findById( id );
		
		ingresosRepository.delete( ingresoEntity );
		
	}




	@Override
	public IngresosDto updateIngreso(long id, IngresosRequestModel ingreso) {
		
		IngresosEntity ingresoEntity = ingresosRepository.findById( id );		

		ProyectoEntity proyectoEntity = proyectoRepository.findById( ingreso.getProyectoId());
		
		ingresoEntity.setProyecto(proyectoEntity);
		
		ingresoEntity.setFechaEmision(DateFormatJCCV.ParseStringToDate(ingreso.getFechaEmision())); //convertir a date
		
		ingresoEntity.setNumeroFactura(ingreso.getNumeroFactura());
		
		ingresoEntity.setCosto(ingreso.getCosto());
		
		ingresoEntity.setDescripcion(ingreso.getDescripcion());
		
		
		
		IngresosEntity createdIngreso = ingresosRepository.save(ingresoEntity);
		
		IngresosDto ingresoToReturn = mapper.map(createdIngreso, IngresosDto.class);
		
		return ingresoToReturn;
	}




	@Override
	public List<IngresosDto> getAllIngresosWhereMatchProyectoId(long proyectoId) {

		List<IngresosEntity> ingresosEntity = ingresosRepository.getAllIngresosWhereMatchProyectoId( proyectoId );
		
		List<IngresosDto> ingresosDtos = new ArrayList<>();
		
		for( IngresosEntity t : ingresosEntity) {
			
			IngresosDto ingreso = mapper.map(t, IngresosDto.class);
			
			ingresosDtos.add(ingreso);
			
		}	
		return ingresosDtos;

	}

}
