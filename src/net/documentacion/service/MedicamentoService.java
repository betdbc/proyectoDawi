package net.documentacion.service;
import java.util.List;

import net.documentacion.entidad.Medicamento;
import net.documentacion.entidad.Parametros;
import net.documentacion.entidad.TipoMedicamento;
import net.documentacion.fabrica.DAOFactory;
import net.documentacion.interfaces.MedicamentoDAO;
import net.documentacion.interfaces.TipoMedicamentoDAO;

public class MedicamentoService {
	//PASO 1: crear la fabrica indicando el tipo de base de datos a usar
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	//PASO 2: indicar en DAO a trabajar
	MedicamentoDAO dao=fabrica.getMedicamentoDAO();
	TipoMedicamentoDAO daoTipo=fabrica.getTipoMedicamentoDAO();
	
	public List<Medicamento> listaMedicamentos(){
		return dao.listMedicamento();
	}
	public int registrarMedicamento(Medicamento med) {
		return dao.addMedicamento(med);
	}
	public int eliminarMedicamento(int id) {
		return dao.deleteMedicamento(id);
	}
	public int actualizarMedicamento(Medicamento med) {
		return dao.updateMedicamento(med);
	}
	public List<TipoMedicamento> listaTipoMedicamentoByLaboratorio(int codLab){
		return daoTipo.listAllTipoMedicamentoByLaboratorio(codLab);
	}
	public int actualizarFotoMedicamento(Medicamento med) {
		return dao.updateFotoMedicamento(med);
	}
	public Medicamento fotoMedicamentoAtCodigo(int cod) {
		return dao.findMedicamento(cod);
	}
	public List<Medicamento> listaMedicamentosPorNombre(String nom){
		return dao.listMedicamentoAtNombre(nom);
	}
	public List<Medicamento> listaMedicamentosPorLaboratorioPorTipo(Parametros bean){
		return dao.listConsultaMedicamentoLaboratorioPorTipo(bean);
	}
	public List<Medicamento> listConsultaMedicamentoPorLaboratorio(int codLab) {
		return dao.listConsultaMedicamentoPorLaboratorio(codLab);
	}
}



