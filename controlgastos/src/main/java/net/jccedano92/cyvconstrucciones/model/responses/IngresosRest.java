package net.jccedano92.cyvconstrucciones.model.responses;

import java.util.Date;

public class IngresosRest {
	
	private long id;
	
	private Date fechaEmision;

	private ProyectoRest proyecto;
	
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

	public ProyectoRest getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoRest proyecto) {
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
