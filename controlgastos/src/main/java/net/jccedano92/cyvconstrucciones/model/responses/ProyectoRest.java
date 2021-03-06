package net.jccedano92.cyvconstrucciones.model.responses;

import java.util.List;

public class ProyectoRest {
	
	private long id;
	
	private String nombre;
	
	private String ciudad;
	
	private String estado;
	
	private String descripcion;
	
	private ClienteRest cliente;
	
	private List<TrabajadoresRest> listarTrabajadores;

	
	
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ClienteRest getCliente() {
		return cliente;
	}

	public void setCliente(ClienteRest cliente) {
		this.cliente = cliente;
	}

	public List<TrabajadoresRest> getListarTrabajadores() {
		return listarTrabajadores;
	}

	public void setListarTrabajadores(List<TrabajadoresRest> listarTrabajadores) {
		this.listarTrabajadores = listarTrabajadores;
	}
	
	
	
	

}
