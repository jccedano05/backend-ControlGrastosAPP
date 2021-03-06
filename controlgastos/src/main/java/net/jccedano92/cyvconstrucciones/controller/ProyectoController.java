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

import net.jccedano92.cyvconstrucciones.dto.ProyectoDto;
import net.jccedano92.cyvconstrucciones.model.request.ProyectoRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.model.responses.ProyectoRest;
import net.jccedano92.cyvconstrucciones.services.ProyectoServiceInterface;

/*
 *	Ruta  localhost:8085/proyecto 
 */

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	
	
	@Autowired
	ProyectoServiceInterface proyectoService;
	
	@Autowired
	ModelMapper mapper;
	
	
	@PostMapping
	public ProyectoRest createProyecto(@RequestBody ProyectoRequestModel proyectoRequestModel) {
		
		
		ProyectoDto proyectoDto = proyectoService.createProyecto( proyectoRequestModel );
		
		ProyectoRest proyectoToReturn = mapper.map(proyectoDto, ProyectoRest.class);
		
		return proyectoToReturn;
		
	}
	
	
	
	
	
	@GetMapping
	public List<ProyectoRest> getAllProyectos(){
		
		List<ProyectoDto> proyectos = proyectoService.getAllProyectos();
		
		List<ProyectoRest> listProyectosRestToReturn = new ArrayList<>();
		
		for( ProyectoDto p: proyectos) {
			
			ProyectoRest proyecto = mapper.map(p, ProyectoRest.class);
			
			listProyectosRestToReturn.add(proyecto);
		}
		
		return listProyectosRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public ProyectoRest getProyectoById(@PathVariable long id) {

		
		ProyectoDto proyectoDto = proyectoService.getProyectoById( id );
		
		ProyectoRest proyectoRest = mapper.map( proyectoDto, ProyectoRest.class );
		
		return proyectoRest;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<ProyectoDto> deleteProyecto(@PathVariable long id) {

		ProyectoDto proyectoDto = proyectoService.getProyectoById( id );
		
		OperationStatusModel<ProyectoDto> operationStatusModel = new OperationStatusModel<ProyectoDto>( proyectoDto );
		
		operationStatusModel.setName("DELETE");
		
		proyectoService.deleteProyecto( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<ProyectoRest> updateProyecto(@RequestBody ProyectoRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		ProyectoDto proyectoUpdated = proyectoService.updateProyecto( id, updateRequestModel);

		ProyectoRest proyectoUpdatedToReturn = mapper.map(proyectoUpdated, ProyectoRest.class);
		
		OperationStatusModel<ProyectoRest> operationStatusModel = new OperationStatusModel<ProyectoRest>( proyectoUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	@GetMapping( path = "/cliente/{idCliente}")
	
		public List<ProyectoRest> getAllProyectosWhereMatchClienteId(@PathVariable long idCliente){
		
		List<ProyectoDto> proyectos = proyectoService.getAllProyectosWhereMatchClienteId(idCliente);
		
		List<ProyectoRest> listProyectosRestToReturn = new ArrayList<>();
		
		for( ProyectoDto p: proyectos) {
			
			ProyectoRest proyecto = mapper.map(p, ProyectoRest.class);
			
			listProyectosRestToReturn.add(proyecto);
		}
		
		return listProyectosRestToReturn;
		
	}
	
	
	
	
}














