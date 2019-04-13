package com.thrm.services;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.thrm.dao.ExperienciasDAO;
import com.thrm.domain.Experiencia;

public class ExperienciasServicios {

	private static ExperienciasServicios es = null;
	private List<Experiencia> experiencia = null;
	private ExperienciasDAO ed = null;

	private ExperienciasServicios() {
		ed = new ExperienciasDAO();
	}

	public static ExperienciasServicios getInstance() {
		if (es == null) {
			es = new ExperienciasServicios();
		}
		return es;
	}

	public String guardarExperiencia(Experiencia experiencia) {
		String resultado = "ERROR";
		if (experiencia != null) {
			ed.save(experiencia);
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public String eliminarExperiencia(Experiencia experiencia) {
		String resultado = "ERROR";
		if (experiencia != null) {
			ed.delete(experiencia);
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public Experiencia buscarExperienciaPorKey(Key key) {
		Experiencia experiencia = ed.findByKey(key);
		return experiencia;
	}

}