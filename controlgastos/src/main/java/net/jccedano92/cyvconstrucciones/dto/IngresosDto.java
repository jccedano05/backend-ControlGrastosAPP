package net.jccedano92.cyvconstrucciones.dto;

import java.util.Date;

public class IngresosDto {
	
	private long id;
	
	private Date fechaEmision;
	
	private ProyectoDto proyecto;

	private String numeroFactura;
	
	private double costo;
	
	private String descripcion;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public ProyectoDto getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDto proyecto) {
		this.proyecto = proyecto;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	


}
