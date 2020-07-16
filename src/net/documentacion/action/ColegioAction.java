package net.documentacion.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.documentacion.entidad.Colegio;
import net.documentacion.service.ColegioService;

@ParentPackage("dawi")
public class ColegioAction extends ActionSupport {
	private Colegio colegio;
	
	private List<Colegio> listaColegios;
	
	private ColegioService colegioService;
	
	public ColegioAction() {
		colegioService=new ColegioService();
	}

	private Map<String, Object> session=ActionContext.getContext().getSession();

	//acción que retorna JSON
			@Action(value="/listAllColegios",results= {@Result(name="ok",type="json") })
			public String listAllColegios() {
				listaColegios=colegioService.listaColegio();
				return "ok";
			}
			
			@Action(value="/listAllColegioscombo",results= {@Result(name="ok",type="json") })
			public String listAllColegioscombo() {
				listaColegios=colegioService.listaColegiocombo();
				return "ok";
			}
			
			
			@Action(value="/saveColegio",results= {@Result(name="ok",type="redirect",location="/registrarColegio.jsp") })
			public String saveColegio() {
				int salida;
				salida=colegioService.saveColegio(colegio);
				if(salida!=-1)
					session.put("MENSAJE", "Registro Ok");
				else
					session.put("MENSAJE", "Error");
				return "ok";
			}
			
			
			
			
			
			
			
	public List<Colegio> getListaColegios() {
				return listaColegios;
	}
	
	public void setListaColegios(List<Colegio> listaColegios) {
		this.listaColegios = listaColegios;
	}
	public Colegio getColegio() {
		return colegio;
	}
	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}
	
	
	
}
