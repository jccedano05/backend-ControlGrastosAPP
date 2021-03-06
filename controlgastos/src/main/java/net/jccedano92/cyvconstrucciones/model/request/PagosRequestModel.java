package net.jccedano92.cyvconstrucciones.model.request;



public class PagosRequestModel {
	
	private String fechaEmision;

	private long proyectoId;
	
	private long vendedorId;
	
	private String numeroFactura;
	
	private double costo;
	
	private String descripcion;

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public long getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(long proyectoId) {
		this.proyectoId = proyectoId;
	}

	public long getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(long vendedorId) {
		this.vendedorId = vendedorId;
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
