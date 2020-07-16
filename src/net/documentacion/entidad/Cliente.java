package net.documentacion.entidad;

public class Cliente {
	private int codigo,dni,codigoDistrito;
	private String nombres,apellidos,sexo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCodigoDistrito() {
		return codigoDistrito;
	}
	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}
