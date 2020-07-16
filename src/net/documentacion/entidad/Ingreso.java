package net.documentacion.entidad;

public class Ingreso {
	private int codigoIngreso, codigoDocumentacion;
	private String estado, nombre, asunto, fecha;
	public int getCodigoIngreso() {
		return codigoIngreso;
	}
	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}
	public int getCodigoDocumentacion() {
		return codigoDocumentacion;
	}
	public void setCodigoDocumentacion(int codigoDocumentacion) {
		this.codigoDocumentacion = codigoDocumentacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
