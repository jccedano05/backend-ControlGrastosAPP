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

import net.jccedano92.cyvconstrucciones.dto.VendedorDto;
import net.jccedano92.cyvconstrucciones.model.request.VendedorRequestModel;
import net.jccedano92.cyvconstrucciones.model.responses.OperationStatusModel;
import net.jccedano92.cyvconstrucciones.model.responses.VendedorRest;
import net.jccedano92.cyvconstrucciones.services.VendedorServiceInterface;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	VendedorServiceInterface vendedorService;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	
	
	@PostMapping
	public VendedorRest createVendedor( @RequestBody VendedorRequestModel vendedorRequestModel ) {
		
		
		VendedorDto vendedorDto = vendedorService.createVendedor( vendedorRequestModel );
		
		VendedorRest vendedorToReturn = mapper.map( vendedorDto, VendedorRest.class );
		
		return vendedorToReturn;
		
	}
	
	
	
	
	
	@GetMapping
	public List<VendedorRest> getAllVendedores(){
		
		List<VendedorDto> vendedores = vendedorService.getAllVendedores();
		
		List<VendedorRest> listVendedorRestToReturn = new ArrayList<>();
		
		for( VendedorDto v: vendedores) {
			
			VendedorRest vendedor = mapper.map(v, VendedorRest.class);
			
			listVendedorRestToReturn.add(vendedor);
		}
		
		return listVendedorRestToReturn;
		
	}
	
	
	
	
	@GetMapping( path = "/{id}")
	public VendedorRest getVendedorById(@PathVariable long id) {

		
		VendedorDto vendedorDto = vendedorService.getVendedorById( id );
		
		VendedorRest vendedorRest = mapper.map( vendedorDto, VendedorRest.class );
		
		return vendedorRest;
		
	}
	
	
	
	@DeleteMapping( path = "/{id}")
	public OperationStatusModel<VendedorDto> deleteVendedor(@PathVariable long id) {

		VendedorDto vendedorDto = vendedorService.getVendedorById( id );
		
		OperationStatusModel<VendedorDto> operationStatusModel = new OperationStatusModel<VendedorDto>( vendedorDto );
		
		operationStatusModel.setName("DELETE");
		
		vendedorService.deleteVendedor( id );
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
	
	
	@PutMapping( path = "/{id}")
	public OperationStatusModel<VendedorRest> updateVendedor(@RequestBody VendedorRequestModel updateRequestModel, @PathVariable long id ) {
		
		
		VendedorDto vendedorUpdated = vendedorService.updateVendedor( id, updateRequestModel);

		VendedorRest vendedorUpdatedToReturn = mapper.map(vendedorUpdated, VendedorRest.class);
		
		OperationStatusModel<VendedorRest> operationStatusModel = new OperationStatusModel<VendedorRest>( vendedorUpdatedToReturn );
		
		operationStatusModel.setName("UPDATED");
		
		operationStatusModel.setResult("SUCCESS");
		
		return operationStatusModel;
		
	}
	
	
	
		
	
	
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
