package com.thrm.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.thrm.domain.Empresa;
import com.thrm.domain.Oferta;
import com.thrm.domain.Responsable;
import com.thrm.services.EmpresaServicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionEmpresa extends ActionSupport {

	private Empresa empresa = null;
	private List<Empresa> empresas = null;
	private List<Empresa> ultimasEmpresas = null;
	private List<String> listadoBusquedaEmpresas = null;
	private String palabraClave = null;
//	private String claveId = null;
	private String tipoBusqueda = null;
	private Set<Oferta> ofertas = null;

	private EmpresaServicios empresaServicios;
	
	private List<String> sectoresSeleccionados = null;
	private Set<Responsable> responsablesEmpresa;
	
	private Long idEmpresa;

	public String registrarEmpresa() {
		String resultado = "ERROR";
		// System.out.println(sectoresSeleccionados.get(0));
		if (getEmpresaServicios().verificarExistenciaCif(empresa.getCif())) {
			addActionError("El cif introducido ya existe en nuestra BD");
			addFieldError("empresa.cif", "");
		} else {
			resultado = getEmpresaServicios().registrar(empresa);
		}
		return resultado;
	}

	public String mostrarEmpresas() {
		String resultado = "ERROR";
		empresas = getEmpresaServicios().mostrarEmpresas();
		resultado = this.recargarPagina();
		return resultado;
	}

	/** Busca empresas según la palabra clave */
	public String buscarEmpresas() {
		String resultado = "ERROR";
		if (empresas != null) {
			empresas.clear();
		}
		empresas = new ArrayList<Empresa>();
		empresas.addAll(getEmpresaServicios().buscarEmpresasPorNombre(palabraClave));
//			this.recargarPagina();
		resultado = "SUCCESS";
		return resultado;
	}

	/** Saca el listado para buscar empresas por distintos criterios */
	public String listarBusquedaEmpresas() {
		String resultado = "ERROR";
		listadoBusquedaEmpresas = getEmpresaServicios().listarBusquedaEmpresas();
		resultado = "SUCCESS";
		return resultado;
	}

	/**
	 * Consultamos las ofertas de una determinada empresa y recargamos la página
	 */
	public String verOfertasPorEmpresa() {
		String resultado = "ERROR";
		try {
			empresa = getEmpresaServicios().buscarEmpresaPorId(idEmpresa);
			ofertas = empresa.getOfertas();
			resultado = this.mostrarEmpresas();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public String ultimasEmpresas() {
		String resultado = "ERROR";
		ultimasEmpresas = getEmpresaServicios().ultimasEmpresas();
		resultado = "SUCCESS";
		return resultado;
	}

//	/** Consultamos el conjunto de ofertas de las empresas */
//	public void ofertasDeEmpresas() {
//		if (ofertas != null) {
//			ofertas.clear();
//		} else {
//			ofertas = new HashSet<Oferta>();
//		}
//		Iterator<Empresa> i = empresas.iterator();
//		while (i.hasNext()) {
//			ofertas.addAll(i.next().getOfertases());
//		}
//	}

	/** Siempre que se recargue la página se llamarán a estos métodos */
	public String recargarPagina() {
		String resultado = "ERROR";
//		resultado = this.listarBusquedaEmpresas();
		resultado = this.ultimasEmpresas();
		return resultado;
	}

	/** Solicitar elminarEmpresa */
	public String eliminarEmpresa() {
		
		getEmpresaServicios().eliminarEmpresa(idEmpresa);
		return "SUCCESS";

	}

	public String buscarResponsablesEmpresa() {
		String resultado = "ERROR";
		try {
			empresa = getEmpresaServicios().buscarEmpresaPorId(idEmpresa);
			responsablesEmpresa = empresa.getResponsables();
			resultado = "SUCCESS";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	public String getPalabraClave(){
		return palabraClave;
	}
	
//	public void setTipoBusqueda(String tipoBusqueda) {
//		this.tipoBusqueda = tipoBusqueda;
//	}

//	public List<String> getListadoEmpresas() {
//		return listadoBusquedaEmpresas;
//	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

//	public List<Empresa> getUltimasEmpresas() {
//		return ultimasEmpresas;
//	}

	public Set<Oferta> getOfertas() {
		return ofertas;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

//	public void setSectoresSeleccionados(List<String> sectoresSeleccionados) {
//		this.sectoresSeleccionados = sectoresSeleccionados;
//	}
//
	public Set<Responsable> getResponsablesEmpresa() {
		return responsablesEmpresa;
	}
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public EmpresaServicios getEmpresaServicios() {
		return empresaServicios;
	}

	public void setEmpresaServicios(EmpresaServicios empresaServicios) {
		this.empresaServicios = empresaServicios;
	}

	
}