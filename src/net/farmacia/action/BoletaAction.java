package net.farmacia.action;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;
import net.farmacia.entidad.Cliente;
import net.farmacia.entidad.Medicamento;
import net.farmacia.service.BoletaService;
import net.farmacia.service.MedicamentoService;

@ParentPackage("dawi")
public class BoletaAction extends ActionSupport{
	//lista de clientes
	private List<Cliente> listaClientes;
	//lista de Medicamentos
	private List<Medicamento> listaMedicamentos;
	//
	private int codigoLaboratorio;
	
	//
	private BoletaService boletaService; 
	//
	private MedicamentoService medicamentoService;
	
	//
	public BoletaAction() {
		boletaService=new BoletaService();
		medicamentoService=new MedicamentoService();
	}
	
		//acción que retorna JSON
		@Action(value="/listAllClientes",results= {@Result(name="ok",type="json") })
		public String listAllClientes() {
			listaClientes=boletaService.listarClientes();
			return "ok";
		}
	//acción que retorna JSON
	@Action(value="/listAllMedicamentoAtLaboratorio",results= {@Result(name="ok",type="json") })
	public String listAllMedicamentoAtLaboratorio() {
		listaMedicamentos=medicamentoService.
				listConsultaMedicamentoPorLaboratorio(codigoLaboratorio);
		return "ok";
	}
	
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	public int getCodigoLaboratorio() {
		return codigoLaboratorio;
	}

	public void setCodigoLaboratorio(int codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}
	
}






