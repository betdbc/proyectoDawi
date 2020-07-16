package net.documentacion.entidad;

import java.io.File;

public class Medicamento {
	private int idMedicamento;
	private String nombre;
	private String descripcion;
	private int stock;
	private double precio;
	private String fechaFabricacion;
	private int idLaboratorio;
	private int idTipo;
	private File foto;
	private byte[] fotoBytes;
	//
	private String nomLaboratorio;
	private String nomTipo;
	
	public int getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFechaFabricacion() {
		return fechaFabricacion;
	}
	public void setFechaFabricacion(String fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	public int getIdLaboratorio() {
		return idLaboratorio;
	}
	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	public byte[] getFotoBytes() {
		return fotoBytes;
	}
	public void setFotoBytes(byte[] fotoBytes) {
		this.fotoBytes = fotoBytes;
	}
	public String getNomLaboratorio() {
		return nomLaboratorio;
	}
	public void setNomLaboratorio(String nomLaboratorio) {
		this.nomLaboratorio = nomLaboratorio;
	}
	public String getNomTipo() {
		return nomTipo;
	}
	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}
	
}


