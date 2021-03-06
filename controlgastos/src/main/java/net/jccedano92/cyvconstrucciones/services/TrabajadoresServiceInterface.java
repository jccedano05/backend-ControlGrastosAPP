package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.TrabajadoresDto;
import net.jccedano92.cyvconstrucciones.model.request.TrabajadoresRequestModel;

public interface TrabajadoresServiceInterface {
	
	public TrabajadoresDto createTrabajador( TrabajadoresRequestModel trabajador);
	
	public List<TrabajadoresDto> getAllTrabajadores();
	
	public TrabajadoresDto getTrabajadorById( long id);
	
	public void deleteTrabajador(long id);
	
	public TrabajadoresDto updateTrabajador( long id, TrabajadoresRequestModel trabajador);
	
	public List<TrabajadoresDto> getAllTrabajadoresWhereMatchProyectoId(long proyectoId);
	
	public List<TrabajadoresDto> getAllTrabajadoresWhereMatchOficioId(long oficioId);

}
