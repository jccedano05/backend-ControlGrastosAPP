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

import net.jccedano92.cyvconstrucciones.dto.PagosDto;
import net.jccedano92.cyvconstrucciones.model.request.PagosRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.model.responses.PagosRest;
import net.jccedano92.cyvconstrucciones.services.PagosServiceInterface;

/*
 *	Ruta  localhost:8085/pagos 
 */


@RestController
@RequestMapping("/pagos")
public class PagosController {
	
	@Autowired
	PagosServiceInterface pagosService;
	
	@Autowired
	ModelMapper mapper;
	
	
	@PostMapping
	public PagosRest createPago(@RequestBody PagosRequestModel pagoRequestModel) {
		
		
		PagosDto pagoDto = pagosService.createPago( pagoRequestModel );
		
		PagosRest pagoToReturn = mapper.map(pagoDto, PagosRest.class);
		
		return pagoToReturn;
		
	}
	
	
	
	
	
	@GetMapping
	public List<PagosRest> getAllPagos(){
		
		List<PagosDto> pagos = pagosService.getAllPagos();
		
		List<PagosRest> pagoListRestToReturn = new ArrayList<>();
		
		for( PagosDto t: pagos) {
			
			PagosRest pago = mapper.map(t, PagosRest.class);
			
			pagoListRestToReturn.add(pago);
		}
		
		return pagoListRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public PagosRest getPagoById(@PathVariable long id) {

		
		PagosDto pagoDto = pagosService.getPagoById( id );
		
		PagosRest pagoToReturn = mapper.map( pagoDto, PagosRest.class );
		
		return pagoToReturn;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<PagosDto> deletePago(@PathVariable long id) {

		PagosDto pagoDto = pagosService.getPagoById( id );
		
		OperationStatusModel<PagosDto> operationStatusModel = new OperationStatusModel<PagosDto>( pagoDto );
		
		operationStatusModel.setName("DELETE");
		
		pagosService.deletePago( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<PagosRest> updatePago(@RequestBody PagosRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		PagosDto pagoUpdated = pagosService.updatePago( id, updateRequestModel);

		PagosRest pagoUpdatedToReturn = mapper.map(pagoUpdated, PagosRest.class);
		
		OperationStatusModel<PagosRest> operationStatusModel = new OperationStatusModel<PagosRest>( pagoUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	@GetMapping( path = "/proyecto/{idProyecto}")
	
		public List<PagosRest> getAllPagosWhereMatchProyectoId(@PathVariable long idProyecto){
		
		List<PagosDto> pagoListDto = pagosService.getAllPagosWhereMatchProyectoId(idProyecto);
		
		List<PagosRest> pagoListRestToReturn = new ArrayList<>();
		
		for( PagosDto t: pagoListDto) {
			
			PagosRest pagoDto = mapper.map(t, PagosRest.class);
			
			pagoListRestToReturn.add(pagoDto);
		}
		
		return pagoListRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/vendedor/{idVendedor}")
	
	public List<PagosRest> getAllPagosWhereMatchVendedorId(@PathVariable long idVendedor){
	
	List<PagosDto> pagoListDto = pagosService.getAllPagosWhereMatchVendedorId(idVendedor);
	
	List<PagosRest> pagoListRestToReturn = new ArrayList<>();
	
	for( PagosDto t: pagoListDto) {
		
		PagosRest pagoDto = mapper.map(t, PagosRest.class);
		
		pagoListRestToReturn.add(pagoDto);
	}
	
	return pagoListRestToReturn;
	
}

}
