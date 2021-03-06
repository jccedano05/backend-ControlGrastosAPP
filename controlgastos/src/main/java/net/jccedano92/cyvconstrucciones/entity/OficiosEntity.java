package net.jccedano92.cyvconstrucciones.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity( name = "oficios" )
public class OficiosEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long idOficio;
	
	@Column( nullable = false, length = 255)
	private String titulo;
	
	@Column( columnDefinition = "TEXT" )
	private String descripcion;
	
	@Column( nullable = false, scale = 2 )
	private double sueldo;
	
	@OneToMany( mappedBy = "oficio")
	private List<TrabajadoresEntity> listaTrabajadores = new ArrayList<>();

	public long getIdOficio() {
		return idOficio;
	}

	public void setIdOficio(long id_oficio) {
		this.idOficio = id_oficio;
	}

	public String getNombre() {
		return titulo;
	}

	public void setNombre(String nombre) {
		this.titulo = nombre;
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

	public List<TrabajadoresEntity> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<TrabajadoresEntity> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	@Override
	public String toString() {
		return "OficiosEntity [idOficio=" + idOficio + ", nombre=" + titulo + ", descripcion=" + descripcion
				+ ", sueldo=" + sueldo + ", listaTrabajadores=" + listaTrabajadores + "]";
	}
	
	

	
	

}
