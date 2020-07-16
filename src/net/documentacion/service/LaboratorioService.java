package net.documentacion.service;
import java.util.List;

import net.documentacion.entidad.Laboratorio;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.LaboratorioDAO;
public class LaboratorioService {
		//PASO 1: crear la fabrica indicando el tipo de base de datos a usar
		DAOFactory fabrica=DAOFactory.getDAOFactory(1);
		//PASO 2: indicar en DAO a trabajar
		LaboratorioDAO dao=fabrica.getLaboratorioDAO();
		
		
		public List<Laboratorio> listarLaboratorios(){
			return dao.listLaboratorio();
		}
		
}



