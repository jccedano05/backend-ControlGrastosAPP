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

import net.jccedano92.cyvconstrucciones.dto.OficiosDto;
import net.jccedano92.cyvconstrucciones.model.request.OficiosRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.OficiosRest;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.services.OficiosServiceInterface;




@RestController
@RequestMapping("/oficio")
public class OficiosController {

	
	@Autowired
	OficiosServiceInterface oficioService;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	
	@PostMapping
	public OficiosRest createVendedor( @RequestBody OficiosRequestModel oficioRequestModel ) {
		
		
		OficiosDto oficioDto = oficioService.createOficio( oficioRequestModel );
		
		OficiosRest oficioToReturn = mapper.map( oficioDto, OficiosRest.class );
		
		return oficioToReturn;
		
	}
	
	
	
	
	@GetMapping
	public List<OficiosRest> getAllOficios(){
		
		List<OficiosDto> oficios = oficioService.getAllOficios();
		
		List<OficiosRest> listOficiosRestToReturn = new ArrayList<>();
		
		for( OficiosDto o: oficios) {
			
			OficiosRest oficio = mapper.map(o, OficiosRest.class);
			
			listOficiosRestToReturn.add(oficio);
		}
		
		return listOficiosRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public OficiosRest getOficioById(@PathVariable long id) {

		
		OficiosDto oficioDto = oficioService.getOficioById( id );
		
		OficiosRest oficioRest = mapper.map( oficioDto, OficiosRest.class );
		
		return oficioRest;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<OficiosDto> deleteOficio(@PathVariable long id) {

		OficiosDto oficioDto = oficioService.getOficioById( id );
		
		OperationStatusModel<OficiosDto> operationStatusModel = new OperationStatusModel<OficiosDto>( oficioDto );
		
		operationStatusModel.setName("DELETE");
		
		oficioService.deleteOficio( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<OficiosRest> updateOficio(@RequestBody OficiosRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		OficiosDto oficioUpdated = oficioService.updateOficio( id, updateRequestModel);

		OficiosRest oficioUpdatedToReturn = mapper.map(oficioUpdated, OficiosRest.class);
		
		OperationStatusModel<OficiosRest> operationStatusModel = new OperationStatusModel<OficiosRest>( oficioUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
}
