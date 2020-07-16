package net.documentacion.service;
import java.util.List;

import net.documentacion.entidad.Enlace;
import net.documentacion.entidad.Usuario;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.UsuarioDAO;

public class UsuarioService {
	//PASO 1: crear la fabrica indicando el tipo de base de datos a usar
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	//PASO 2: indicar en DAO a trabajar
	UsuarioDAO dao=fabrica.getUsuarioDAO();
			
			
	public Usuario iniciarSesion(Usuario bean) {
		return dao.iniciarSesion(bean);
	}
	public List<Enlace> traerEnlancesPorUsuario(int codUsu) {
		return dao.traerEnlancesPorUsuario(codUsu);
	}
	
	
}
