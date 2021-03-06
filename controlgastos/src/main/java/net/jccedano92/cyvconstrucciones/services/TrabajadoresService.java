package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.TrabajadoresDto;
import net.jccedano92.cyvconstrucciones.entity.OficiosEntity;
import net.jccedano92.cyvconstrucciones.entity.ProyectoEntity;
import net.jccedano92.cyvconstrucciones.entity.TrabajadoresEntity;
import net.jccedano92.cyvconstrucciones.model.request.TrabajadoresRequestModel;
import net.jccedano92.cyvconstrucciones.repository.OficiosRepository;
import net.jccedano92.cyvconstrucciones.repository.ProyectoRepository;
import net.jccedano92.cyvconstrucciones.repository.TrabajadoresRepository;

@Service
public class TrabajadoresService  implements TrabajadoresServiceInterface{

	
	@Autowired
	TrabajadoresRepository trabajadoresRepository;
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@Autowired
	OficiosRepository oficioRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	
	@Override
	public TrabajadoresDto createTrabajador(TrabajadoresRequestModel trabajadores) {

		
		ProyectoEntity proyectoEntity = proyectoRepository.findById( trabajadores.getProyectoId());
		
		OficiosEntity oficioEntity = oficioRepository.findById( trabajadores.getOficioId());
		
		
		TrabajadoresEntity trabajadorEntity = new TrabajadoresEntity();
		
		trabajadorEntity.setProyecto(proyectoEntity);
		
		trabajadorEntity.setOficio(oficioEntity);
		
		trabajadorEntity.setNombres(trabajadores.getNombres());
		trabajadorEntity.setApellidoPaterno(trabajadores.getApellidoPaterno());
		trabajadorEntity.setApellidoMaterno(trabajadores.getApellidoMaterno());
		trabajadorEntity.setCurp(trabajadores.getCurp());
		trabajadorEntity.setImss(trabajadores.getImss());
		
		
		TrabajadoresEntity createdTrabajador = trabajadoresRepository.save(trabajadorEntity);
		
		TrabajadoresDto trabajadorToReturn = mapper.map(createdTrabajador, TrabajadoresDto.class);
		
		return trabajadorToReturn;
	}




	@Override
	public List<TrabajadoresDto> getAllTrabajadores() {

		List<TrabajadoresEntity> trabajadoresEntity = trabajadoresRepository.getAllTrabajadores();
		
		List<TrabajadoresDto> trabajadoresDtos = new ArrayList<>();
		
		for( TrabajadoresEntity t : trabajadoresEntity) {
			
			TrabajadoresDto trabajador = mapper.map(t, TrabajadoresDto.class);
			
			trabajadoresDtos.add(trabajador);
			
		}
		
		return trabajadoresDtos;
	}




	@Override
	public TrabajadoresDto getTrabajadorById(long id) {
		
		TrabajadoresEntity trabajadorEntity = trabajadoresRepository.findById( id );
		
		TrabajadoresDto trabajadorDto = mapper.map(trabajadorEntity, TrabajadoresDto.class);
		
		return trabajadorDto;
	}




	@Override
	public void deleteTrabajador(long id) {

		TrabajadoresEntity trabajadorEntity = trabajadoresRepository.findById( id );
		
		trabajadoresRepository.delete( trabajadorEntity );
		
	}




	@Override
	public TrabajadoresDto updateTrabajador(long id, TrabajadoresRequestModel trabajador) {

		TrabajadoresEntity trabajadorEntity = trabajadoresRepository.findById( id );
		
		ProyectoEntity proyectoEntity = proyectoRepository.findById( trabajador.getProyectoId());
		
		OficiosEntity oficioEntity = oficioRepository.findById( trabajador.getOficioId());
		
		
		trabajadorEntity.setProyecto(proyectoEntity);
		
		trabajadorEntity.setOficio(oficioEntity);
		
		trabajadorEntity.setNombres(trabajador.getNombres());
		trabajadorEntity.setApellidoPaterno(trabajador.getApellidoPaterno());
		trabajadorEntity.setApellidoMaterno(trabajador.getApellidoMaterno());
		trabajadorEntity.setCurp(trabajador.getCurp());
		trabajadorEntity.setImss(trabajador.getImss());
		
		
		TrabajadoresEntity createdTrabajador = trabajadoresRepository.save(trabajadorEntity);
		
		TrabajadoresDto trabajadorToReturn = mapper.map(createdTrabajador, TrabajadoresDto.class);
		
		return trabajadorToReturn;

	}




	@Override
	public List<TrabajadoresDto> getAllTrabajadoresWhereMatchProyectoId(long proyectoId) {

		List<TrabajadoresEntity> trabajadoresEntities = trabajadoresRepository.getAllTrabajadoresWhereMatchProyectoId(proyectoId);
		
		List<TrabajadoresDto> trabajadoresDtos = new ArrayList<>();
		
		for( TrabajadoresEntity t : trabajadoresEntities) {
			
			TrabajadoresDto trabajador = mapper.map(t, TrabajadoresDto.class);
			
			trabajadoresDtos.add(trabajador);
			
		}
		
		return trabajadoresDtos;
		
	}




	@Override
	public List<TrabajadoresDto> getAllTrabajadoresWhereMatchOficioId(long oficioId) {

		List<TrabajadoresEntity> trabajadoresEntities = trabajadoresRepository.getAllTrabajadoresWhereMatchOficioId(oficioId);
		
		List<TrabajadoresDto> trabajadoresDtos = new ArrayList<>();
		
		for( TrabajadoresEntity t : trabajadoresEntities) {
			
			TrabajadoresDto trabajador = mapper.map(t, TrabajadoresDto.class);
			
			trabajadoresDtos.add(trabajador);
			
		}
		
		return trabajadoresDtos;

	}
	
}
