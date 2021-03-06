package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.ProyectoDto;
import net.jccedano92.cyvconstrucciones.model.request.ProyectoRequestModel;

public interface ProyectoServiceInterface {
	
	public ProyectoDto createProyecto( ProyectoRequestModel proyecto);
	
	public List<ProyectoDto> getAllProyectos();
	
	public ProyectoDto getProyectoById( long id);
	
	public void deleteProyecto(long id);
	
	public ProyectoDto updateProyecto( long id, ProyectoRequestModel proyecto);
	
	public List<ProyectoDto> getAllProyectosWhereMatchClienteId(long clienteId);
}
