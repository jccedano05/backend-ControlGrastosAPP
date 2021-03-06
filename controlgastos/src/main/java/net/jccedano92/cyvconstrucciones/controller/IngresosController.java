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

import net.jccedano92.cyvconstrucciones.dto.IngresosDto;
import net.jccedano92.cyvconstrucciones.model.request.IngresosRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.IngresosRest;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.services.IngresosServiceInterface;

/*
 *	Ruta  localhost:8085/pagos 
 */


@RestController
@RequestMapping("/ingresos")
public class IngresosController {

	
	
	@Autowired
	IngresosServiceInterface ingresosService;
	
	@Autowired
	ModelMapper mapper;
	
	
	@PostMapping
	public IngresosRest createIngreso(@RequestBody IngresosRequestModel ingresoRequestModel) {
		
		
		IngresosDto ingresoDto = ingresosService.createIngreso( ingresoRequestModel );
		
		IngresosRest ingresoToReturn = mapper.map(ingresoDto, IngresosRest.class);
		
		return ingresoToReturn;
		
	}
	
	
	
	
	
	@GetMapping
	public List<IngresosRest> getAllIngresos(){
		
		List<IngresosDto> ingresos = ingresosService.getAllIngresos();
		
		List<IngresosRest> ingresoListRestToReturn = new ArrayList<>();
		
		for( IngresosDto t: ingresos) {
			
			IngresosRest ingreso = mapper.map(t, IngresosRest.class);
			
			ingresoListRestToReturn.add(ingreso);
		}
		
		return ingresoListRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public IngresosRest getIngresoById(@PathVariable long id) {

		
		IngresosDto ingresoDto = ingresosService.getIngresoById( id );
		
		IngresosRest ingresoRest = mapper.map( ingresoDto, IngresosRest.class );
		
		return ingresoRest;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<IngresosDto> deleteIngreso(@PathVariable long id) {

		IngresosDto ingresoDto = ingresosService.getIngresoById( id );
		
		OperationStatusModel<IngresosDto> operationStatusModel = new OperationStatusModel<IngresosDto>( ingresoDto );
		
		operationStatusModel.setName("DELETE");
		
		ingresosService.deleteIngreso( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<IngresosRest> updateIngreso(@RequestBody IngresosRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		IngresosDto ingresoUpdated = ingresosService.updateIngreso( id, updateRequestModel);

		IngresosRest ingresoUpdatedToReturn = mapper.map(ingresoUpdated, IngresosRest.class);
		
		OperationStatusModel<IngresosRest> operationStatusModel = new OperationStatusModel<IngresosRest>( ingresoUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	@GetMapping( path = "/proyecto/{idProyecto}")
	
		public List<IngresosRest> getAllIngresosWhereMatchProyectoId(@PathVariable long idProyecto){
		
		List<IngresosDto> ingresos = ingresosService.getAllIngresosWhereMatchProyectoId(idProyecto);
		
		List<IngresosRest> ingresoListRestToReturn = new ArrayList<>();
		
		for( IngresosDto t: ingresos) {
			
			IngresosRest ingreso = mapper.map(t, IngresosRest.class);
			
			ingresoListRestToReturn.add(ingreso);
		}
		
		return ingresoListRestToReturn;
		
	}
	
}
