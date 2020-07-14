package net.farmacia.interfaces;
import java.util.List;
import net.farmacia.entidad.TipoMedicamento;
public interface TipoMedicamentoDAO {
	public List<TipoMedicamento> listAllTipoMedicamentoByLaboratorio(int codLab);
}
