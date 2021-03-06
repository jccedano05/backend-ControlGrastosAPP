package net.jccedano92.cyvconstrucciones.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity( name = "vendedor" )
public class VendedorEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long idVendedor;
	
	@Column( nullable = false, length = 255)
	private String nombre;
	
	@Column( length = 20)
	private String rfc;
	
	@Column( columnDefinition = "TEXT" )
	private String descripcion;

	
	@OneToMany( mappedBy = "vendedor")
	private List<PagosEntity> listaPagos = new ArrayList<>();


	public long getIdEmpresaVendedora() {
		return idVendedor;
	}


	public void setIdEmpresaVendedora(long idEmpresaVendedora) {
		this.idVendedor = idEmpresaVendedora;
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


	public List<PagosEntity> getListaPagos() {
		return listaPagos;
	}


	public void setListaPagos(List<PagosEntity> listaPagos) {
		this.listaPagos = listaPagos;
	}


	@Override
	public String toString() {
		return "EmpresaVendedoraEntity [idVendedor=" + idVendedor + ", nombre=" + nombre + ", rfc="
				+ rfc + ", descripcion=" + descripcion + ", listaPagos=" + listaPagos + "]";
	}
	
	
	

	
	
	
}
