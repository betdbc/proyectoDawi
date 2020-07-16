package net.documentacion.service;

import java.util.List;

import net.documentacion.dao.MySqlColegioDAO;
import net.documentacion.dao.MySqlDocumentacionDAO;
import net.documentacion.entidad.Colegio;
import net.documentacion.entidad.Documentacion;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.DocumentacionDAO;

public class DocumentacionService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	DocumentacionDAO daoDocumentacion=fabrica.getDocumentacionDAO();
	
	private MySqlColegioDAO daoCole;
	private MySqlDocumentacionDAO daoDoc;
	
	//
	public DocumentacionService() {
		daoCole=new MySqlColegioDAO();
		daoDoc= new MySqlDocumentacionDAO();
	}
	
	
	
	public List<Colegio> listAllColegio(){
		return daoCole.listaColegio();
	}
	
	public List<Documentacion> listarDocumentacion(){
		return daoDoc.listaDocumentacion();
	}
	
	public int saveDocumentacion(Documentacion bean) {
		return daoDocumentacion.addDocumentacion(bean);
	}


	
	
}
