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

import net.jccedano92.cyvconstrucciones.dto.ClienteDto;
import net.jccedano92.cyvconstrucciones.model.request.ClienteRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.ClienteRest;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.services.ClienteServiceInterface;


/*
 *	Ruta  localhost:8080/clientes 
 */


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	
	
	@Autowired
	ClienteServiceInterface clienteService;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	@PostMapping
	public ClienteRest createCliente( @RequestBody ClienteRequestModel createRequestModel ) {
		
		
		
		ClienteDto clienteDto = clienteService.createCliente( createRequestModel );
		
		ClienteRest clienteToReturn = mapper.map( clienteDto, ClienteRest.class );
		
		return clienteToReturn;
		
	}
	
	
	
	
	@GetMapping
	public List<ClienteRest> getAllClientes(){
		
		List<ClienteDto> clientes = clienteService.getAllClientes();
		
		List<ClienteRest> listClientesRestToReturn = new ArrayList<>();
		
		for( ClienteDto c: clientes) {
			
			ClienteRest cliente = mapper.map(c, ClienteRest.class);
			
			listClientesRestToReturn.add(cliente);
		}
		
		return listClientesRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public ClienteRest getClienteById(@PathVariable long id) {

		
		ClienteDto clienteDto = clienteService.getClienteById( id );
		
		ClienteRest clienteRest = mapper.map( clienteDto, ClienteRest.class );
		
		return clienteRest;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<ClienteDto> deleteCliente(@PathVariable long id) {
		
		ClienteDto clienteDto = clienteService.getClienteById( id );
		
		OperationStatusModel<ClienteDto> operationStatusModel = new OperationStatusModel<ClienteDto>( clienteDto );
		
		operationStatusModel.setName("DELETE");
		
		clienteService.deleteCliente( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<ClienteRest> updateCliente(@RequestBody ClienteRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		ClienteDto clienteUpdated = clienteService.updateCliente( id, updateRequestModel);

		ClienteRest clienteUpdatedToReturn = mapper.map(clienteUpdated, ClienteRest.class);
		
		OperationStatusModel<ClienteRest> operationStatusModel = new OperationStatusModel<ClienteRest>( clienteUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	
	
	
}



















