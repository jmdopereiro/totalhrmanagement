package com.thrm.services;

import java.util.ArrayList;
import java.util.List;

import com.thrm.dao.ConocimientosDAO;
import com.thrm.domain.Conocimiento;

public class ConocimientosServicios {

	private List<Conocimiento> conocimientos = null;
	private ConocimientosDAO conocimientosDAO;
	private Conocimiento conocimiento = null;

	public List<Conocimiento> mostrarConocimientos() {
//		conocimientos = conocimientosDAO.findAll();
		conocimientos = new ArrayList<Conocimiento>();
		conocimientos.add(new Conocimiento("Java"));
		return conocimientos;
	}

	public ConocimientosDAO getConocimientosDAO() {
		return conocimientosDAO;
	}

	public void setConocimientosDAO(ConocimientosDAO conocimientosDAO) {
		this.conocimientosDAO = conocimientosDAO;
	}

//	public Conocimientos buscarConocimientoPorNombre(String nombre) {
//		conocimientos = conocimientosDAO.findByNombre(nombre);
//		if (conocimientos.size() == 1) {
//			conocimiento = conocimientos.get(0);
//
//		}
//		return conocimiento;
//	}
}