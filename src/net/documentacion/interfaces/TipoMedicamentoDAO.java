package net.documentacion.interfaces;
import java.util.List;

import net.documentacion.entidad.TipoMedicamento;
public interface TipoMedicamentoDAO {
	public List<TipoMedicamento> listAllTipoMedicamentoByLaboratorio(int codLab);
	
}
