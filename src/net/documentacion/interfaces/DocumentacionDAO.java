package net.documentacion.interfaces;

import java.util.List;

import net.documentacion.entidad.Documentacion;

public interface DocumentacionDAO {
	public List<Documentacion> listaDocumentacion();
	public int addDocumentacion(Documentacion doc);

	public int updateDocumentacion(Documentacion doc);
	public int deleteDocumentacion(int id);
}
