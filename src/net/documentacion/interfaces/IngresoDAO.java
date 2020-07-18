package net.documentacion.interfaces;

import java.util.List;

import net.documentacion.entidad.Ingreso;

public interface IngresoDAO {
	
	public List<Ingreso> listaIngreso();
	public int addIngreso(Ingreso ing);

	public int updateIngreso(Ingreso ing);
	public int deleteIngreso(int id);
}
