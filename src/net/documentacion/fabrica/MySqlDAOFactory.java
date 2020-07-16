package net.documentacion.fabrica;

import net.documentacion.dao.MySqlClienteDAO;
import net.documentacion.dao.MySqlColegioDAO;
import net.documentacion.dao.MySqlDocumentacionDAO;
import net.documentacion.dao.MySqlLaboratorioDAO;
import net.documentacion.dao.MySqlMedicamentoDAO;
import net.documentacion.dao.MySqlTipoMedicamentoDAO;
import net.documentacion.dao.MySqlUsuarioDAO;
import net.documentacion.entidad.TipoMedicamento;
import net.documentacion.interfaces.ClienteDAO;
import net.documentacion.interfaces.ColegioDAO;
import net.documentacion.interfaces.DocumentacionDAO;
import net.documentacion.interfaces.LaboratorioDAO;
import net.documentacion.interfaces.MedicamentoDAO;
import net.documentacion.interfaces.TipoMedicamentoDAO;
import net.documentacion.interfaces.UsuarioDAO;

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
