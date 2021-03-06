package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.OficiosDto;
import net.jccedano92.cyvconstrucciones.model.request.OficiosRequestModel;

public interface OficiosServiceInterface {

	public OficiosDto createOficio( OficiosRequestModel oficio);
	
	public List<OficiosDto> getAllOficios();
	
	public OficiosDto getOficioById( long id);
	
	public void deleteOficio(long oficioId);
	
	public OficiosDto updateOficio( long oficioId, OficiosRequestModel oficioDto);

}
