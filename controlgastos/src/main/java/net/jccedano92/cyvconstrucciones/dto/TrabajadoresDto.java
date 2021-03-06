package net.jccedano92.cyvconstrucciones.dto;

public class TrabajadoresDto {
	
	private long id;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String curp;

	private String imss;
	
	private ProyectoDto proyecto;
	
	private OficiosDto oficio;

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

	public ProyectoDto getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDto proyecto) {
		this.proyecto = proyecto;
	}

	public OficiosDto getOficio() {
		return oficio;
	}

	public void setOficio(OficiosDto oficio) {
		this.oficio = oficio;
	}
	
	

}
