package net.farmacia.service;
import java.util.List;
import net.farmacia.entidad.Laboratorio;
import net.farmacia.fabrica.DAOFactory;
import net.farmacia.interfaces.LaboratorioDAO;
public class LaboratorioService {
		//PASO 1: crear la fabrica indicando el tipo de base de datos a usar
		DAOFactory fabrica=DAOFactory.getDAOFactory(1);
		//PASO 2: indicar en DAO a trabajar
		LaboratorioDAO dao=fabrica.getLaboratorioDAO();
		
		
		public List<Laboratorio> listarLaboratorios(){
			return dao.listLaboratorio();
		}
		
}



