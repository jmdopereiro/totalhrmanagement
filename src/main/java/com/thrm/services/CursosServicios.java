package com.thrm.services;

import java.util.List;

import com.thrm.dao.CursosDAO;
import com.thrm.domain.Curso;

public class CursosServicios {

	private static CursosServicios cs = null;
	private List<Curso> cursos = null;
	private CursosDAO cd = null;
	private Curso curso = null;

	private CursosServicios() {
		cd = new CursosDAO();
	}

	public static CursosServicios getInstance() {
		if (cs == null) {
			cs = new CursosServicios();
		}
		return cs;
	}

	public List<Curso> mostrarCursos() {
		cursos = cd.findAll();
		return cursos;
	}

//	public Curso buscarCursoPorNombre(String nombre) {
//		cursos = cd.findByCurso(nombre);
//		if (cursos.size() == 1) {
//			curso = cursos.get(0);
//
//		}
//		return curso;
//	}
}