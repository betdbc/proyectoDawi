package net.farmacia.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import net.farmacia.entidad.Colegio;
import net.farmacia.entidad.Documentacion;
import net.farmacia.service.DocumentacionService;

@ParentPackage("dawi")
public class DocumentacionAction extends ActionSupport {
	//
	private List<Documentacion> listaDocumentacion;
	
	private DocumentacionService documentacionService;
	
	public DocumentacionAction() {
		documentacionService=new DocumentacionService();
	}
	/*
	public List<Documentacion> getListaDocumentacion() {
		return listaDocumentacion;
	}*/
	
	
	@Action(value="/listAllDocumentaciones",results= {@Result(name="ok",type="json") })
	public String listAllDocumentaciones() {
		listaDocumentacion= documentacionService.listarDocumentacion();
		return "ok";
	}


	public List<Documentacion> getListaDocumentacion() {
		return listaDocumentacion;
	}


	public void setListaDocumentacion(List<Documentacion> listaDocumentacion) {
		this.listaDocumentacion = listaDocumentacion;
	}
	
	

}
