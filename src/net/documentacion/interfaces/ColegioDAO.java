package net.documentacion.interfaces;

import java.util.List;

import net.documentacion.entidad.Colegio;

public interface ColegioDAO {
	public List<Colegio> listaColegio();

	List<Colegio> listaComboColegio();
}
