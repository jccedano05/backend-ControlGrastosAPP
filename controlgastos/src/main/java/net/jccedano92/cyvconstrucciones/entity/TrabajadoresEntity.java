package net.jccedano92.cyvconstrucciones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity( name= "trabajadores")
public class TrabajadoresEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long idTrabajador;
	
	@Column( nullable = false, length = 50)
	private String nombres;
	
	@Column( nullable = false, length = 50)
	private String apellidoPaterno;
	
	@Column( nullable = false, length = 50)
	private String apellidoMaterno;
	
	@Column( nullable = false, length = 50)
	private String curp;
	
	@Column(length = 50)
	private String imss;
	
	@ManyToOne
	@JoinColumn( name = "id_oficio", nullable = false)
	private OficiosEntity oficio;
	
	@ManyToOne
	@JoinColumn( name = "id_proyecto", nullable = false)
	private ProyectoEntity proyecto;
	
	
	

	public long getIdTrabajador() {
		return idTrabajador;
	}

	public void getIdTrabajador(long id_trabajador) {
		this.idTrabajador = id_trabajador;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getImss() {
		return imss;
	}

	public void setImss(String imss) {
		this.imss = imss;
	}

	public OficiosEntity getOficio() {
		return oficio;
	}

	public void setOficio(OficiosEntity oficio) {
		this.oficio = oficio;
	}
	

	public ProyectoEntity getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoEntity proyecto) {
		this.proyecto = proyecto;
	}

	public void setIdTrabajador(long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	@Override
	public String toString() {
		return "TrabajadoresEntity [idTrabajador=" + idTrabajador + ", nombres=" + nombres + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", curp=" + curp + ", imss=" + imss
				+ ", oficio=" + oficio + ", proyecto=" + proyecto + "]";
	}


	
	
	

}
