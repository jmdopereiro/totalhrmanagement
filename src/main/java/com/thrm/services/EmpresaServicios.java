package com.thrm.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.thrm.dao.EmpresasDAO;
import com.thrm.domain.Empresa;
import com.thrm.domain.Oferta;
import com.thrm.domain.Responsable;

public class EmpresaServicios {

	private List<Empresa> empresas = null;
	private EmpresasDAO empresasDAO = null;
	private Empresa empresa = null;

	private EmpresaServicios() {
		empresasDAO = new EmpresasDAO();
	}

	/**
	 * Comprueba la existencia del cif en la tabla empresas Devolviendo true en
	 * caso de que exista
	 */
	public boolean verificarExistenciaCif(String cif) {
		boolean resultado = false;
		empresas = empresasDAO.findByCif(cif);
		System.out.println(empresas.size() + "CIF: " + cif);
		if (empresas.size() == 1) {
			resultado = true;
		}
		return resultado;
	}

	/**
	 * Comprueba que la clave introducida corresponde a la empresa introducida
	 * (por cif) Devolviendo true en caso de que sea correcto
	 */
	public boolean verificarCodigo(String cif, String codigo) {
		boolean resultado = false;
		empresas = empresasDAO.findByCif(cif);
		if (empresas.size() == 1) {
			Empresa e = empresas.get(0);
			if (e.getCodigo().equals(codigo)) {
				resultado = true;
			}
		}
		return resultado;
	}

	public String registrar(Empresa empresa) {
		empresasDAO.save(empresa);
		return "SUCCESS";
	}

	public List<Empresa> mostrarEmpresas() {
		empresas = empresasDAO.findAll();
//		this.listarBusquedaEmpresas();
		return empresas;
	}

	public List<Empresa> buscarEmpresasPorNombre(String nombre) {
		empresas = empresasDAO.findByNombre(nombre);
		return empresas;
	}

	public Empresa buscarEmpresaPorCif(String palabraClave) {
		empresas = empresasDAO.findByCif(palabraClave);
		Empresa empresa = null;
		if (empresas.size() == 1) {
			empresa = empresas.get(0);
			System.out.println(empresa.getKey());
		}
		return empresa;
	}

	public Empresa buscarEmpresaPorId(long identificador) {
		empresa = empresasDAO.findById(identificador);
		return empresa;
	}

	public List<String> listarBusquedaEmpresas() {
		ArrayList<String> listadoEmpresas;
		Iterator<Empresa> i = empresas.iterator();
		listadoEmpresas = new ArrayList<String>();
		while (i.hasNext()) {
			Empresa e = i.next();
			listadoEmpresas.add(e.getNombre());
			// listadoEmpresas.add(e.getCif());
		}
		return listadoEmpresas;
	}

//	/** Devuelve las ofertas publicadas por una empresa */
//	public Set<Oferta> verOfertasPorEmpresa(int identificador) {
//		Empresa e = empresasDAO.findById(identificador);
//		Set<Oferta> ofertasEmpresa = e.getOfertases();
//		return ofertasEmpresa;
//	}

	public List<Empresa> ultimasEmpresas() {
		empresas = empresasDAO.findLastFive();
		return empresas;
	}
	
	public void eliminarEmpresa(long idEmpresa){
		
		empresasDAO.delete(buscarEmpresaPorId(idEmpresa));
	}
}