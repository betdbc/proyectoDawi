package net.documentacion.action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.documentacion.entidad.Medicamento;
import net.documentacion.entidad.Parametros;
import net.documentacion.entidad.TipoMedicamento;
import net.documentacion.service.MedicamentoService;
@ParentPackage("dawi")
public class MedicamentoAction extends ActionSupport{
	//atributo de tipo lista de la clase Medicamento
	private List<Medicamento> listaMedicamentos;
	//atributo de tipo lista de la clase TipoMedicamento
	private List<TipoMedicamento> listaTipoMedicamentos;
	//atributo de la clase Medicamento, se va a referenciar en cada caja de GUI
	private Medicamento medicamento;
	//atributo que almacena el codigo de medicamento a eliminar
	private int codigoMedicamento;
	//atributo que almacena el codigo del laboratorio
	private int codigoLaboratorio;
	//
	private String nombre;
	//
	private String baseFoto;
	//
	private int codigoLab,codigoTip;
	
	//atributo tipo sesión
	private Map<String, Object> session=(Map<String, Object>)ActionContext.getContext().getSession();

	
	//atributo para un servicio "MedicamentoService"
	private MedicamentoService servicioMedicamento;

	
	//constructor
	public MedicamentoAction() {
		servicioMedicamento=new MedicamentoService();
	}
	
	//crear una acción que retorne un JSON
	@Action(value="/listAllTipoAtLaboratorio",results= {@Result(name="ok",type="json") })
	public String listAllTipoAtLaboratorio() {
		listaTipoMedicamentos=servicioMedicamento.listaTipoMedicamentoByLaboratorio(codigoLaboratorio);
		return "ok";
	}
	//crear una acción que retorne un JSON
	@Action(value="/findFotoAtMedicamento",results= {@Result(name="ok",type="json") })
	public String findFotoAtMedicamento() {
		Medicamento bean=servicioMedicamento.fotoMedicamentoAtCodigo(codigoMedicamento);
		if(bean!=null)
			baseFoto=Base64.getEncoder().encodeToString(bean.getFotoBytes());
		else
			baseFoto=null;
		return "ok";
	}	
	
	
	//crear una acción que retorne un JSON
	@Action(value="/listAllMedicamentos",results= {@Result(name="ok",type="json") })
	public String listAllMedicamentos() {
		listaMedicamentos=servicioMedicamento.listaMedicamentos();
		return "ok";
	}
	//crear una acción que retorne un JSON
	@Action(value="/listAllMedicamentosPorNombre",results= {@Result(name="ok",type="json") })
	public String listAllMedicamentosPorNombre() {
		listaMedicamentos=servicioMedicamento.listaMedicamentosPorNombre(nombre);
		return "ok";
	}
	//crear una acción que retorne un JSON
	@Action(value="/listAllMedicamentosPorLaboratorioPorTipo",results= {@Result(name="ok",type="json") })
	public String listAllMedicamentosPorLaboratorioPorTipo() {
		//crear un objeto de la clase Parametros
		Parametros bean=new Parametros();
		//setear
		bean.setIdLab(codigoLab);
		bean.setIdTipo(codigoTip);
		listaMedicamentos=servicioMedicamento.listaMedicamentosPorLaboratorioPorTipo(bean);
		return "ok";
	}
		
	
	
	//crear una acción para registrar medicamento
	@Action(value="/addMedicamento",results= {@Result(name="ok",type="redirect",location="/medicamento.jsp") })
	public String addMedicamento() throws IOException {
		int estado;
		if(medicamento.getFoto()!=null) {
			
			//obtener la imagen seleccionada de la vista, dicha imagen se encuentra en el
			//atributo foto que es de tipo File
			InputStream is=new FileInputStream(medicamento.getFoto());
			//crear un arreglo de bytes con el tamaño del archivo "is"
			byte arreglo[]=new byte[is.available()];
			//leer el binario "is" y enviar la información al arreglo de bytes
			is.read(arreglo);
			//setear el atributo fotoBytes con el valor del arreglo
			medicamento.setFotoBytes(arreglo);
		}
		else
			medicamento.setFotoBytes(null);
		
		estado=servicioMedicamento.registrarMedicamento(medicamento);
		if(estado!=-1)
			session.put("MENSAJE", "Se registro correctamente el medicamento");
		else
			session.put("MENSAJE", "Error en el registro del medicamento");
		return "ok";
	}
	//crear una acción para eliminar medicamento
	@Action(value="/deleteMedicamento",results= {@Result(name="ok",type="redirect",location="/medicamento.jsp") })
	public String deleteMedicamento() {
		int estado;
		estado=servicioMedicamento.eliminarMedicamento(codigoMedicamento);
		if(estado!=-1)
			session.put("MENSAJE", "Se elimino correctamente el medicamento");
		else
			session.put("MENSAJE", "Error en la eliminación del medicamento");
		return "ok";
	}
	//crear una acción para actualizar foto del medicamento
	@Action(value="/updateFotoMedicamento",results= {@Result(name="ok",type="redirect",location="/medicamento.jsp") })
	public String updateFotoMedicamento() throws IOException {
		int estado;
		//obtener la imagen seleccionada de la vista, dicha imagen se encuentra en el
		//atributo foto que es de tipo File
		InputStream is=new FileInputStream(medicamento.getFoto());
		//crear un arreglo de bytes con el tamaño del archivo "is"
		byte arreglo[]=new byte[is.available()];
		//leer el binario "is" y enviar la información al arreglo de bytes
		is.read(arreglo);
		//setear el atributo fotoBytes con el valor del arreglo
		medicamento.setFotoBytes(arreglo);
		
		estado=servicioMedicamento.actualizarFotoMedicamento(medicamento);
		if(estado!=-1)
			session.put("MENSAJE", "Se actualizo correctamente el medicamento");
		else
			session.put("MENSAJE", "Error en la actualización del medicamento");
		return "ok";
	}
	//crear una acción para actualizar medicamento
		@Action(value="/updateMedicamento",results= {@Result(name="ok",type="redirect",location="/medicamento.jsp") })
		public String updateMedicamento() {
			int estado;
			estado=servicioMedicamento.actualizarMedicamento(medicamento);
			if(estado!=-1)
				session.put("MENSAJE", "Se actualizo correctamente el medicamento");
			else
				session.put("MENSAJE", "Error en la actualización del medicamento");
			return "ok";
		}	
	
	
	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}
	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public int getCodigoMedicamento() {
		return codigoMedicamento;
	}

	public void setCodigoMedicamento(int codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	public List<TipoMedicamento> getListaTipoMedicamentos() {
		return listaTipoMedicamentos;
	}

	public void setListaTipoMedicamentos(List<TipoMedicamento> listaTipoMedicamentos) {
		this.listaTipoMedicamentos = listaTipoMedicamentos;
	}

	public int getCodigoLaboratorio() {
		return codigoLaboratorio;
	}

	public void setCodigoLaboratorio(int codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}

	public String getBaseFoto() {
		return baseFoto;
	}

	public void setBaseFoto(String baseFoto) {
		this.baseFoto = baseFoto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoLab() {
		return codigoLab;
	}

	public void setCodigoLab(int codigoLab) {
		this.codigoLab = codigoLab;
	}

	public int getCodigoTip() {
		return codigoTip;
	}

	public void setCodigoTip(int codigoTip) {
		this.codigoTip = codigoTip;
	}

	
	
	
}




