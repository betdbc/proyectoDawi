package net.documentacion.entidad;

public class Documentacion {
	 private int codigo;
	 private String nombre;
	 private String asunto;
	 private String fecha;
	 
	 private int codigoColegio;
	 
	 private String nombrecole;
	 
	 
	 
	public String getNombrecole() {
		return nombrecole;
	}
	public void setNombrecole(String nombrecole) {
		this.nombrecole = nombrecole;
	}
	public int getCodigoColegio() {
		return codigoColegio;
	}
	public void setCodigoColegio(int codigoColegio) {
		this.codigoColegio = codigoColegio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	 
	 
}
