package net.jccedano92.cyvconstrucciones.dto;

import java.util.List;

public class OficiosDto {

	
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private double sueldo;
	
	private List<TrabajadoresDto> listarTrabajadores;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public List<TrabajadoresDto> getListarTrabajadores() {
		return listarTrabajadores;
	}

	public void setListarTrabajadores(List<TrabajadoresDto> listarTrabajadores) {
		this.listarTrabajadores = listarTrabajadores;
	}
	
	
	
	
}
