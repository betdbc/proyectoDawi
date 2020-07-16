package net.documentacion.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.documentacion.entidad.Colegio;
import net.documentacion.entidad.Documentacion;
import net.documentacion.service.ColegioService;
import net.documentacion.service.DocumentacionService;

@ParentPackage("dawi")
public class DocumentacionAction extends ActionSupport {
	//REGISTRAR
	private Documentacion documentacion;
	
	
	//Consultar
	private List<Documentacion> listaDocumentacion;
	private List<Colegio>listaColegio;
	
	
	private DocumentacionService documentacionService;
	private ColegioService colegioService;
	
	private Map<String, Object> session=ActionContext.getContext().getSession();
	
	
	public DocumentacionAction() {
		documentacionService=new DocumentacionService();
		colegioService= new ColegioService();
	}
	
	@Action(value="/listAllColegios",results= {@Result(name="ok",type="json") })
	public String listAllColegios() {
		listaColegio= colegioService.listaColegio();
		return "ok";
	}
	
	@Action(value="/listAllDocumentaciones",results= {@Result(name="ok",type="json") })
	public String listAllDocumentaciones() {
		listaDocumentacion= documentacionService.listarDocumentacion();
		return "ok";
	}

	
	@Action(value="/saveDocumentacion",results= {@Result(name="ok",type="redirect",location="/registrarDocumento.jsp") })
	public String saveDocumentacion() {
		int salida;
		salida=documentacionService.saveDocumentacion(documentacion);
		if(salida!=-1)
			session.put("MENSAJE", "Registro Ok");
		else
			session.put("MENSAJE", "Error");
		return "ok";
	}


	public List<Documentacion> getListaDocumentacion() {
		return listaDocumentacion;
	}
	
	public void setListaDocumentacion(List<Documentacion> listaDocumentacion) {
		this.listaDocumentacion = listaDocumentacion;
	}



	public Documentacion getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(Documentacion documentacion) {
		this.documentacion = documentacion;
	}
	

	

}
