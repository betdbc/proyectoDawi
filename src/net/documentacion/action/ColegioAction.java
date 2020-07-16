package net.documentacion.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import net.documentacion.entidad.Colegio;
import net.documentacion.service.ColegioService;

@ParentPackage("dawi")
public class ColegioAction extends ActionSupport {
	private List<Colegio> listaColegios;
	
	private ColegioService colegioService;
	
	public ColegioAction() {
		colegioService=new ColegioService();
	}


	//acción que retorna JSON
			@Action(value="/listAllColegios",results= {@Result(name="ok",type="json") })
			public String listAllColegios() {
				listaColegios=colegioService.listaColegio();
				return "ok";
			}
			
			public List<Colegio> getListaColegios() {
				return listaColegios;
			}
			

	public void setListaColegios(List<Colegio> listaColegios) {
		this.listaColegios = listaColegios;
	}
	
}
