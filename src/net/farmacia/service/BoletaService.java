package net.farmacia.service;

import java.util.List;

import net.farmacia.entidad.Cliente;
import net.farmacia.fabrica.DAOFactory;
import net.farmacia.interfaces.ClienteDAO;

public class BoletaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ClienteDAO daoCliente=fabrica.getClienteDAO();
	
	public List<Cliente> listarClientes(){
		return daoCliente.listaClientes();	
	}
	
	

	
}
