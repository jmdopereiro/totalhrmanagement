package com.thrm.services;

import java.util.ArrayList;
import java.util.List;

import com.thrm.dao.IdiomasDAO;
import com.thrm.domain.Idioma;

public class IdiomasServicios {

	private static IdiomasServicios is = null;
	private List<Idioma> idiomas = null;
	private IdiomasDAO id = null;
	private Idioma idioma = null;

	private IdiomasServicios() {
		id = new IdiomasDAO();
	}

	public static IdiomasServicios getInstance() {
		if (is == null) {
			is = new IdiomasServicios();
		}
		return is;
	}

	public List<Idioma> mostrarIdiomas() {

		List<Idioma> idiomas = new ArrayList<Idioma>();
		idiomas.add(new Idioma("ingles"));
		idiomas.add(new Idioma("Frances"));
		idiomas.add(new Idioma("Aleman"));
		idiomas.add(new Idioma("Portugues"));
		idiomas.add(new Idioma("Italiano"));
		
//		idiomas = id.findAll();
		return idiomas;
	}

//	public Idioma buscarIdiomaPorNombre(String nombre) {
//		idioma = id.findByNombre(nombre);
//		if (idioma.size() == 1) {
//			idioma = idioma.get(0);
//
//		}
//		return idioma;
//	}
}