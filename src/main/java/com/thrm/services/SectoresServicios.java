package com.thrm.services;

import java.util.List;

import com.thrm.dao.SectoresDAO;
import com.thrm.domain.Sector;

public class SectoresServicios {

	private static SectoresServicios ss = null;
	private List<Sector> sectores = null;
	private SectoresDAO sd = null;

//	private SectoresServicios() {
//		sd = new SectoresDAO();
//	}
//
//	public static SectoresServicios getInstance() {
//		if (ss == null) {
//			ss = new SectoresServicios();
//		}
//		return ss;
//	}
//
//	public List<Sector> mostrarSectores() {
//		sectores = sd.findAll();
//		return sectores;
//	}
}