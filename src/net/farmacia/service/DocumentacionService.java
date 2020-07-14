package net.farmacia.service;

import java.util.List;

import net.farmacia.entidad.Documentacion;
import net.farmacia.fabrica.DAOFactory;
import net.farmacia.interfaces.DocumentacionDAO;

public class DocumentacionService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	DocumentacionDAO daoDocumentacion=fabrica.getDocumentacionDAO();
	
	public List<Documentacion> listarDocumentacion(){
		return daoDocumentacion.listaDocumentacion();
	}
}
