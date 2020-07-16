package net.documentacion.interfaces;
import java.util.List;

import net.documentacion.entidad.Laboratorio;
public interface LaboratorioDAO {
	public int addLaboratorio(Laboratorio lab);
	public int updateLaboratorio(Laboratorio lab);
	public int deleteLaboratorio(int id);
	public List<Laboratorio> listLaboratorio();
	public Laboratorio findLaboratorio(int id);
}

