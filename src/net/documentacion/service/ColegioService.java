package net.documentacion.service;

import java.util.List;

import net.documentacion.entidad.Colegio;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.ColegioDAO;

public class ColegioService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ColegioDAO daoColegio=fabrica.getColegioDAO();
	
	public List<Colegio> listaColegio(){
		return daoColegio.listaColegio();
	}
	
	
	public int saveColegio(Colegio bean) {
		return daoColegio.saveColegio(bean);
	}
	
	
}
