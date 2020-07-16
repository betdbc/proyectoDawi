package net.documentacion.action;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import net.documentacion.entidad.Laboratorio;
import net.documentacion.service.LaboratorioService;
@ParentPackage("dawi")
public class LaboratorioAction extends ActionSupport{
	
	//atributo de tipo lista de la clase Laboratorio
	private List<Laboratorio> listaLaboratorios;

	//atributo para un servicio "LaboratorioService"
	private LaboratorioService servicioLaboratorio;
	
	//constructor
	public LaboratorioAction() {
		servicioLaboratorio=new LaboratorioService();
	}
	
	//crear una acción que retorne un JSON
	@Action(value="/listAllLaboratorios",results= {@Result(name="ok",type="json") })
	public String listAllLaboratorios() {
		listaLaboratorios=servicioLaboratorio.listarLaboratorios();
		return "ok";
	}
	
	public List<Laboratorio> getListaLaboratorios() {
		return listaLaboratorios;
	}
	public void setListaLaboratorios(List<Laboratorio> listaLaboratorios) {
		this.listaLaboratorios = listaLaboratorios;
	}
}
