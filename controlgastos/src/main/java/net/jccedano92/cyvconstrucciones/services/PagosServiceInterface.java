package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.PagosDto;
import net.jccedano92.cyvconstrucciones.model.request.PagosRequestModel;

public interface PagosServiceInterface {


	public PagosDto createPago( PagosRequestModel pago);
	
	public List<PagosDto> getAllPagos();
	
	public PagosDto getPagoById( long id);
	
	public void deletePago(long id);
	
	public PagosDto updatePago( long id, PagosRequestModel pago);
	
	public List<PagosDto> getAllPagosWhereMatchProyectoId(long proyectoId);
	
	public List<PagosDto> getAllPagosWhereMatchVendedorId(long oficioId);
}
