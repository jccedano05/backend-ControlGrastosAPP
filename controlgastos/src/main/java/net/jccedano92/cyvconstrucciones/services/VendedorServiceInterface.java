package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.VendedorDto;
import net.jccedano92.cyvconstrucciones.model.request.VendedorRequestModel;

public interface VendedorServiceInterface {

	public VendedorDto createVendedor( VendedorRequestModel vendedor);
	
	public List<VendedorDto> getAllVendedores();
	
	public VendedorDto getVendedorById( long id);
	
	public void deleteVendedor(long id);
	
	public VendedorDto updateVendedor( long id, VendedorRequestModel vendedor);
}
