package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.ClienteDto;
import net.jccedano92.cyvconstrucciones.model.request.ClienteRequestModel;

public interface ClienteServiceInterface {
	
	public ClienteDto createCliente( ClienteRequestModel cliente);
	
	public List<ClienteDto> getAllClientes();
	
	public ClienteDto getClienteById( long id);
	
	public void deleteCliente(long clienteId);
	
	public ClienteDto updateCliente( long clienteId, ClienteRequestModel clienteDto);

}
