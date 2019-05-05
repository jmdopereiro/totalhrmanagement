package com.thrm.services;

import java.util.Iterator;
import java.util.List;

import com.thrm.dao.EmpresasDAO;
import com.thrm.dao.ResponsableDAO;
import com.thrm.domain.Empresa;
import com.thrm.domain.Responsable;
import com.thrm.util.ContextProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;

public class ResponsablesServicios {

	private static final Log log = LogFactory.getLog(ResponsablesServicios.class);


	private List<Responsable> responsables = null;
	private ResponsableDAO responsableDAO;
	private EmpresasDAO empresasDAO = null;
	private ServiciosGlobales serviciosGlobales;

	private ResponsablesServicios() {
		responsableDAO = new ResponsableDAO();
		empresasDAO = new EmpresasDAO();
	}

	public Responsable buscarResponsablePorDni(String dni) {
		Responsable responsable = null;
		responsables = responsableDAO.findByDni(dni);

		if (responsables.size() == 1) {
			responsable = responsables.get(0);
		}
		return responsable;
	}
//
//	public Responsables buscarResponsablePorNombre(String nombre) {
//		Responsables responsable = null;
//		responsables = rd.findByNombre(nombre);
//		if (responsables.size() == 1) {
//			responsable = responsables.get(0);
//		}
//		return responsable;
//	}
//
/**
 * It is necessary to store the company and not the responsible because the company is the father.
 */
	public String registrar(Empresa empresa, Responsable responsable) {
		
		String resultado = "ERROR";
		if(!responsableEnEmpresa(responsable.getDni(), empresa)){
			responsable.setEmpresa(empresa);
			empresa.addResponsable(responsable);
			empresasDAO.merge(empresa);
			resultado = "SUCCESS";
		}
		return resultado;
	}

	private boolean responsableEnEmpresa(String dni, Empresa empresa){
		for(Iterator<Responsable> it = empresa.getResponsables().iterator(); it.hasNext();){
			Responsable responsable = it.next();
			if(responsable.getDni().equals(dni))
				return true;
		}
		return false;
	}
//	public String registrar(Responsable responsable) {
//		String resultado = "ERROR";
//		responsableDAO.save(responsable);
//		resultado = "SUCCESS";
//		return resultado;
//	}
	
//
//	public String eliminarResponsable(String dni) {
//		String resultado = "ERROR";
//		responsables = rd.findByDni(dni);
//		if (responsables.size() == 1) {
//			Responsables responsable = responsables.get(0);
//			rd.delete(responsable);
//			resultado = "SUCCESS";
//		}
//		return resultado;
//	}

	public String modificarPerfil(Responsable responsable) {
		String resultado = "ERROR";
		Responsable responsableAlmacenado = serviciosGlobales.cargarResponsable();
		log.info("Responsable almacenado: "+ responsableAlmacenado + " key: " + responsableAlmacenado.getKey());

		String password = responsableAlmacenado.getPassword();
		Empresa empresa = responsableAlmacenado.getEmpresa();
		responsable.setKey(responsableAlmacenado.getKey());
		responsable.setPassword(password);
		responsable.setEmpresa(empresa);
		responsableDAO.merge(responsable);
		resultado = "SUCCESS";
		return resultado;
	}

	public void setServiciosGlobales(ServiciosGlobales serviciosGlobales) {
		this.serviciosGlobales = serviciosGlobales;
	}

//	public String cambiarPassword(Responsables responsable, String nuevaPassword) {
//		String resultado = "ERROR";
//		responsable.setPassword(nuevaPassword);
//		rd.attachDirty(responsable);
//		rd.merge(responsable);
//		resultado = "SUCCESS";
//		return resultado;
//	}

}