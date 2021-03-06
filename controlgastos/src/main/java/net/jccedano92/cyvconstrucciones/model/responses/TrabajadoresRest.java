package net.jccedano92.cyvconstrucciones.model.responses;


public class TrabajadoresRest {

	private long id;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String curp;

	private String imss;
	
	private ProyectoRest proyecto;
	
	private OficiosRest oficio;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public ProyectoRest getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoRest proyecto) {
		this.proyecto = proyecto;
	}

	public OficiosRest getOficio() {
		return oficio;
	}

	public void setOficio(OficiosRest oficio) {
		this.oficio = oficio;
	}
	
	
	
}
