package net.jccedano92.cyvconstrucciones.model.request;

public class TrabajadoresRequestModel {
	
	private long proyectoId;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String curp;

	private String imss;
	
	private long oficioId;

	public long getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(long proyectoId) {
		this.proyectoId = proyectoId;
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

	public long getOficioId() {
		return oficioId;
	}

	public void setOficioId(long oficioId) {
		this.oficioId = oficioId;
	}
	
	

}
