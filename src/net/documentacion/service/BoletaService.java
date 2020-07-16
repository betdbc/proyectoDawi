package net.documentacion.service;

import java.util.List;

import net.documentacion.entidad.Cliente;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.ClienteDAO;

public class BoletaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ClienteDAO daoCliente=fabrica.getClienteDAO();
	
	public List<Cliente> listarClientes(){
		return daoCliente.listaClientes();	
	}
	
	

	
}
