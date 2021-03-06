package net.jccedano92.cyvconstrucciones.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity( name = "pagos")
public class PagosEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long idPago;
	
	@Column( nullable =  false)
	private Date fechaEmision;
	
	@ManyToOne
	@JoinColumn( name = "id_proyecto", nullable = false)
	private ProyectoEntity proyecto;
	
	@ManyToOne
	@JoinColumn( name = "id_vendedor", nullable = false)
	private VendedorEntity vendedor;
	
	@Column( length = 100)
	private String numeroFactura;
	
	@Column(nullable = false, scale = 2)
    private double costo;
	
	@Column( nullable = false, columnDefinition = "TEXT")
	private String descripcion;

	public long getIdPagos() {
		return idPago;
	}

	public void setIdPagos(long idPagos) {
		this.idPago = idPagos;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public ProyectoEntity getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoEntity proyecto) {
		this.proyecto = proyecto;
	}

	public VendedorEntity getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorEntity vendedor) {
		this.vendedor = vendedor;
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

	@Override
	public String toString() {
		return "PagosEntity [idPagos=" + idPago + ", fechaEmision=" + fechaEmision + ", proyecto=" + proyecto
				+ ", vendedor=" + vendedor + ", numeroFactura=" + numeroFactura + ", costo=" + costo + ", descripcion="
				+ descripcion + "]";
	}
	

	
	
	
	

}
