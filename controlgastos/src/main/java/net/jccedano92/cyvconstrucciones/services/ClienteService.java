package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.ClienteDto;
import net.jccedano92.cyvconstrucciones.entity.ClienteEntity;
import net.jccedano92.cyvconstrucciones.model.request.ClienteRequestModel;
import net.jccedano92.cyvconstrucciones.repository.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceInterface{

	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Override
	public ClienteDto createCliente(ClienteRequestModel cliente) {

		
		ClienteEntity clienteEntity = new ClienteEntity();
		
		clienteEntity.setNombre( cliente.getNombre() );
		clienteEntity.setRfc( cliente.getRfc() );
		
		ClienteEntity createdCliente = clienteRepository.save( clienteEntity );
		
		ClienteDto clienteToReturn = mapper.map( createdCliente , ClienteDto.class);
		
		return clienteToReturn;
	}


	@Override
	public List<ClienteDto> getAllClientes() {

		List<ClienteEntity> clientesEntities = clienteRepository.getAllClientes();
		
		List<ClienteDto> clientesDtos = new ArrayList<>();
		
		for( ClienteEntity c : clientesEntities) {
			
			ClienteDto cliente = mapper.map(c, ClienteDto.class);
			
			clientesDtos.add(cliente);
			
		}
		
		return clientesDtos;
	}


	@Override
	public ClienteDto getClienteById(long id) {

		ClienteEntity clienteEntity = clienteRepository.findById( id );
		
		ClienteDto clienteDto = mapper.map(clienteEntity, ClienteDto.class);
		
		return clienteDto;
	}


	@Override
	public void deleteCliente(long id) {

		ClienteEntity clienteEntity = clienteRepository.findById( id );
		
		clienteRepository.delete(clienteEntity);
		
		
	}


	@Override
	public ClienteDto updateCliente(long id, ClienteRequestModel clienteRequestModel) {

		
		ClienteEntity clienteEntity = clienteRepository.findById( id );
		
		
		clienteEntity.setNombre(clienteRequestModel.getNombre());
		clienteEntity.setRfc(clienteRequestModel.getRfc());
		
		ClienteEntity updatedCliente = clienteRepository.save(clienteEntity);
		
		ClienteDto clienteToReturn = mapper.map(updatedCliente, ClienteDto.class);
		
		return clienteToReturn;
	}

}
