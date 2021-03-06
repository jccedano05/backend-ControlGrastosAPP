package net.jccedano92.cyvconstrucciones.services;

import java.util.List;

import net.jccedano92.cyvconstrucciones.dto.IngresosDto;
import net.jccedano92.cyvconstrucciones.model.request.IngresosRequestModel;

public interface IngresosServiceInterface {
	
	public IngresosDto createIngreso( IngresosRequestModel ingreso);
	
	public List<IngresosDto> getAllIngresos();
	
	public IngresosDto getIngresoById( long id);
	
	public void deleteIngreso(long id);
	
	public IngresosDto updateIngreso( long id, IngresosRequestModel ingreso);
	
	public List<IngresosDto> getAllIngresosWhereMatchProyectoId(long proyectoId);
	
}
