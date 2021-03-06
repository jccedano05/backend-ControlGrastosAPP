package net.jccedano92.cyvconstrucciones.dto;

import java.util.List;

public class ClienteDto {
	
	private long id;
	
	private String nombre;
	
	private String rfc;
	
	private List<ProyectoDto> listarProyectos;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public List<ProyectoDto> getListarProyectos() {
		return listarProyectos;
	}

	public void setListarProyectos(List<ProyectoDto> listaProyectos) {
		this.listarProyectos = listaProyectos;
	}
	
	


}
