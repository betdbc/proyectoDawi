package net.farmacia.fabrica;

import net.farmacia.dao.MySqlClienteDAO;
import net.farmacia.dao.MySqlColegioDAO;
import net.farmacia.dao.MySqlDocumentacionDAO;
import net.farmacia.dao.MySqlLaboratorioDAO;
import net.farmacia.dao.MySqlMedicamentoDAO;
import net.farmacia.dao.MySqlTipoMedicamentoDAO;
import net.farmacia.dao.MySqlUsuarioDAO;
import net.farmacia.entidad.TipoMedicamento;
import net.farmacia.interfaces.ClienteDAO;
import net.farmacia.interfaces.ColegioDAO;
import net.farmacia.interfaces.DocumentacionDAO;
import net.farmacia.interfaces.LaboratorioDAO;
import net.farmacia.interfaces.MedicamentoDAO;
import net.farmacia.interfaces.TipoMedicamentoDAO;
import net.farmacia.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public LaboratorioDAO getLaboratorioDAO() {
		// TODO Auto-generated method stub
		return new MySqlLaboratorioDAO();
	}

	@Override
	public MedicamentoDAO getMedicamentoDAO() {
		// TODO Auto-generated method stub
		return new MySqlMedicamentoDAO();
	}

	@Override
	public TipoMedicamentoDAO getTipoMedicamentoDAO() {
		// TODO Auto-generated method stub
		return new MySqlTipoMedicamentoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}

	@Override
	public DocumentacionDAO getDocumentacionDAO() {
		// TODO Auto-generated method stub
		return new MySqlDocumentacionDAO();
	}

	@Override
	public ColegioDAO getColegioDAO() {
		// TODO Auto-generated method stub
		return new MySqlColegioDAO();
	}





}
