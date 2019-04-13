package com.thrm.services;

import java.util.Iterator;
import java.util.List;

import com.thrm.dao.EmpresasDAO;
import com.thrm.dao.ResponsableDAO;
import com.thrm.domain.Empresa;
import com.thrm.domain.Responsable;

public class ResponsablesServicios {

	private static ResponsablesServicios rs = null;
	private List<Responsable> responsables = null;
	private ResponsableDAO responsableDAO = null;
	private EmpresasDAO empresasDAO = null;

	private ResponsablesServicios() {
		responsableDAO = new ResponsableDAO();
		empresasDAO = new EmpresasDAO();
	}

	public static ResponsablesServicios getInstance() {
		if (rs == null) {
			rs = new ResponsablesServicios();
		}
		return rs;
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
//
//	public String modificarPerfil(Responsables responsable) {
//		String resultado = "ERROR";
//		ServiciosGlobales sg = ServiciosGlobales.getInstance();
//		Responsables responsableAlmacenado = sg.cargarResponsable();
//		// Responsables
//		// responsableAlmacenado=this.buscarResponsablePorDni(responsable.getDni());
//		int idResponsable = responsableAlmacenado.getIdresponsable();
//		String password = responsableAlmacenado.getPassword();
//		Empresa empresa = responsableAlmacenado.getEmpresas();
//		responsable.setIdresponsable(idResponsable);
//		responsable.setPassword(password);
//		responsable.setEmpresas(empresa);
//		rd.merge(responsable);
//		resultado = "SUCCESS";
//		return resultado;
//	}
//
//	public String cambiarPassword(Responsables responsable, String nuevaPassword) {
//		String resultado = "ERROR";
//		responsable.setPassword(nuevaPassword);
//		rd.attachDirty(responsable);
//		rd.merge(responsable);
//		resultado = "SUCCESS";
//		return resultado;
//	}

}