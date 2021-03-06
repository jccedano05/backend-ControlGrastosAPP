package net.jccedano92.cyvconstrucciones.dto;

import java.util.List;

public class VendedorDto {
	
	private long id;
	
	private String nombre;
	
	private String rfc;
	
	private String descripcion;
	
	private List<PagosDto> listarPagos;

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
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PagosDto> getListarPagos() {
		return listarPagos;
	}

	public void setListarPagos(List<PagosDto> listarPagos) {
		this.listarPagos = listarPagos;
	}
	
	

}
