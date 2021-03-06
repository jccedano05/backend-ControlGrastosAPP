package net.jccedano92.cyvconstrucciones.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity( name = "cliente")
public class ClienteEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long idCliente;
	
	@Column( nullable = false, length = 255)
	private String nombre;
	
	@Column( length = 20)
	private String rfc;
	
	@OneToMany(mappedBy = "cliente")
	private List<ProyectoEntity> listaProyectos = new ArrayList<>();

	

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public List<ProyectoEntity> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<ProyectoEntity> listaProyectos) {
		this.listaProyectos = listaProyectos;
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

	public List<ProyectoEntity> getProyectos() {
		return listaProyectos;
	}

	public void setProyectos(List<ProyectoEntity> proyectos) {
		this.listaProyectos = proyectos;
	}

	@Override
	public String toString() {
		return "ClienteEntity [idCliente=" + idCliente + ", nombre=" + nombre + ", rfc=" + rfc
				+ ", proyectos=" + listaProyectos + "]";
	}
	
	
	
	

}
