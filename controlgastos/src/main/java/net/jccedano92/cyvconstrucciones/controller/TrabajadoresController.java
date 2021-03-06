package net.jccedano92.cyvconstrucciones.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.jccedano92.cyvconstrucciones.dto.TrabajadoresDto;
import net.jccedano92.cyvconstrucciones.model.request.TrabajadoresRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.model.responses.TrabajadoresRest;
import net.jccedano92.cyvconstrucciones.services.TrabajadoresServiceInterface;

/*
 *	Ruta  localhost:8085/trabajadores 
 */


@RestController
@RequestMapping("/trabajadores")
public class TrabajadoresController {

	
	
	
	@Autowired
	TrabajadoresServiceInterface trabajadoresService;
	
	@Autowired
	ModelMapper mapper;
	
	
	@PostMapping
	public TrabajadoresRest createTrabajador(@RequestBody TrabajadoresRequestModel trabajadorRequestModel) {
		
		
		TrabajadoresDto trabajadorDto = trabajadoresService.createTrabajador( trabajadorRequestModel );
		
		TrabajadoresRest trabajadorToReturn = mapper.map(trabajadorDto, TrabajadoresRest.class);
		
		
		
		return trabajadorToReturn;
		
	}
	
	
	@GetMapping
	public List<TrabajadoresRest> getAllTrabajadores(){
		
		List<TrabajadoresDto> trabajadores = trabajadoresService.getAllTrabajadores();
		
		List<TrabajadoresRest> listTrabajadorRestToReturn = new ArrayList<>();
		
		for( TrabajadoresDto t: trabajadores) {
			
			TrabajadoresRest trabajador = mapper.map(t, TrabajadoresRest.class);
			
			listTrabajadorRestToReturn.add(trabajador);
		}
		
		return listTrabajadorRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public TrabajadoresRest getTrabajadorById(@PathVariable long id) {

		
		TrabajadoresDto trabajadorDto = trabajadoresService.getTrabajadorById( id );
		
		TrabajadoresRest trabajadorRest = mapper.map( trabajadorDto, TrabajadoresRest.class );
		
		return trabajadorRest;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<TrabajadoresDto> deleteTrabajador(@PathVariable long id) {

		TrabajadoresDto trabajadorDto = trabajadoresService.getTrabajadorById( id );
		
		OperationStatusModel<TrabajadoresDto> operationStatusModel = new OperationStatusModel<TrabajadoresDto>( trabajadorDto );
		
		operationStatusModel.setName("DELETE");
		
		trabajadoresService.deleteTrabajador( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<TrabajadoresRest> updateTrabajador(@RequestBody TrabajadoresRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		TrabajadoresDto trabajadorUpdated = trabajadoresService.updateTrabajador( id, updateRequestModel);

		TrabajadoresRest trabajadorUpdatedToReturn = mapper.map(trabajadorUpdated, TrabajadoresRest.class);
		
		OperationStatusModel<TrabajadoresRest> operationStatusModel = new OperationStatusModel<TrabajadoresRest>( trabajadorUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	@GetMapping( path = "/proyecto/{idProyecto}")
	
		public List<TrabajadoresRest> getAllTrabajadoresWhereMatchProyectoId(@PathVariable long idProyecto){
		
		List<TrabajadoresDto> trabajadores = trabajadoresService.getAllTrabajadoresWhereMatchProyectoId(idProyecto);
		
		List<TrabajadoresRest> listTrabajadorRestToReturn = new ArrayList<>();
		
		for( TrabajadoresDto t: trabajadores) {
			
			TrabajadoresRest trabajador = mapper.map(t, TrabajadoresRest.class);
			
			listTrabajadorRestToReturn.add(trabajador);
		}
		
		return listTrabajadorRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/oficio/{idOficio}")
	
	public List<TrabajadoresRest> getAllTrabajadoresWhereMatchOficioId(@PathVariable long idOficio){
	
	List<TrabajadoresDto> trabajadores = trabajadoresService.getAllTrabajadoresWhereMatchOficioId(idOficio);
	
	List<TrabajadoresRest> listTrabajadorRestToReturn = new ArrayList<>();
	
	for( TrabajadoresDto t: trabajadores) {
		
		TrabajadoresRest trabajador = mapper.map(t, TrabajadoresRest.class);
		
		listTrabajadorRestToReturn.add(trabajador);
	}
	
	return listTrabajadorRestToReturn;
	
}
	
	
	
	
	
}

