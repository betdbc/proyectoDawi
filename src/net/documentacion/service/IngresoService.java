package net.documentacion.service;

import java.util.List;

import net.documentacion.dao.MySqlColegioDAO;
import net.documentacion.dao.MySqlDocumentacionDAO;
import net.documentacion.dao.MySqlIngresoDAO;
import net.documentacion.entidad.Colegio;
import net.documentacion.entidad.Documentacion;
import net.documentacion.entidad.Ingreso;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.DocumentacionDAO;
import net.documentacion.interfaces.IngresoDAO;

public class IngresoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	IngresoDAO daoIngreso=fabrica.getIngresoDAO();
	
	private MySqlIngresoDAO daoIng;
	private MySqlColegioDAO daoCole;
	
	//
	public IngresoService() {
		daoIng=new MySqlIngresoDAO();
		daoCole= new MySqlColegioDAO();
	}
	
	
	
	public List<Ingreso> listAllIngreso(){
		return daoIng.listaIngreso();
	}
	
	public List<Colegio> listarColegio(){
		return daoCole.listaColegio();
	}
	
	public int saveIngreso(Ingreso bean) {
		return daoIngreso.addIngreso(bean);
	}


	
	
}
