package com.thrm.services;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thrm.dao.FormacionesDAO;
import com.thrm.domain.Formacion;

public class FormacionesServicios {

	private static FormacionesServicios fs = null;
	private List<Formacion> formaciones = null;
	private FormacionesDAO fd = null;

	private FormacionesServicios() {
		fd = new FormacionesDAO();
	}

	public static FormacionesServicios getInstance() {
		if (fs == null) {
			fs = new FormacionesServicios();
		}
		return fs;
	}
	
	public Formacion buscarFormacionPorKey(Key key) {
		Formacion formacion = fd.findByKey(key);
		return formacion;
	}

	public String guardarFormacion(Formacion formacion) {
		String resultado = "ERROR";
		if (formacion != null) {
			fd.save(formacion);
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public Formacion buscarFormacionPorId(int identificador) {
		Formacion formacion = fd.findById(identificador);
		return formacion;
	}

//	public String eliminarFormacion(Formacion formacion) {
//		String resultado = "ERROR";
//		if (formacion != null) {
//			fd.delete(formacion);
//			resultado = "SUCCESS";
//		}
//		return resultado;
//	}

}