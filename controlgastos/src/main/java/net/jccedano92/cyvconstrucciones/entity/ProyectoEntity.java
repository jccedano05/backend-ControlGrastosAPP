package net.jccedano92.cyvconstrucciones.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity( name = "proyecto")
public class ProyectoEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private long idProyecto;
	
	@ManyToOne
	@JoinColumn( name = "id_cliente", nullable = false )
	private ClienteEntity cliente;
	
	@Column( nullable = false)
	private String nombre;
	
	@Column( columnDefinition = "TEXT")
	private String descripcion;
	
	@Column( length = 30)
	private String ciudad;
	
	@Column( length = 30)
	private String estado;
	
	@OneToMany( mappedBy = "proyecto")
	private List< IngresosEntity > listaIngresos = new ArrayList<>();
	
	@OneToMany( mappedBy = "proyecto")
	private List< PagosEntity > listaPagos = new ArrayList<>();
	
	@OneToMany( mappedBy = "proyecto")
	private List< TrabajadoresEntity > listaTrabajadores = new ArrayList<>();

	public long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
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

	public List<IngresosEntity> getListaIngresos() {
		return listaIngresos;
	}

	public void setListaIngresos(List<IngresosEntity> listaIngresos) {
		this.listaIngresos = listaIngresos;
	}

	public List<PagosEntity> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<PagosEntity> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public List<TrabajadoresEntity> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<TrabajadoresEntity> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	@Override
	public String toString() {
		return "ProyectoEntity [idProyecto=" + idProyecto + ", cliente=" + cliente + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", ciudad=" + ciudad + ", estado=" + estado + ", listaIngresos="
				+ listaIngresos + ", listaPagos=" + listaPagos + ", listaTrabajadores=" + listaTrabajadores + "]";
	}

	
	
	
	

}
