package net.jccedano92.cyvconstrucciones.model.responses;

import java.util.List;

public class VendedorRest {
	
	private long id;
	
	private String nombre;
	
	private String rfc;

	private String descripcion;
	
	private List<PagosRest> listarPagos;

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

	public List<PagosRest> getListarPagos() {
		return listarPagos;
	}

	public void setListarPagos(List<PagosRest> listarPagos) {
		this.listarPagos = listarPagos;
	}
	
	
	

}
