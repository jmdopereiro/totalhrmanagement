package com.thrm.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thrm.domain.Candidato;
import com.thrm.domain.Inscripcion;
import com.thrm.domain.Oferta;
import com.thrm.services.CandidatosServicios;
import com.thrm.services.OfertaServicios;
import com.thrm.services.SectoresServicios;
import com.thrm.services.ServiciosGlobales;

import java.util.List;
import java.util.Map;

public class ActionGlobal extends ActionSupport {

	private OfertaServicios os = null;
	private Oferta oferta = null;
	private CandidatosServicios cs = null;
	private Candidato candidato = null;
	private String mensaje = null;
	private Integer idOferta = null;
	private Integer idCandidato = null;
	private ServiciosGlobales sg = null;
	private Inscripcion inscripcion = null;
	private static Map session = null;
	private SectoresServicios ss = null;
	private List<String> listaSectores = null;

//	public String verCandidatoOferta() {
//		String resultado = "ERROR";
//		sg = ServiciosGlobales.getInstance();
//		if (sg.comprobarLogin()) {
//			cs = CandidatosServicios.getInstance();
//			os = OfertasServicios.getInstance();
//			candidato = cs.buscarCandidatoPorId(idCandidato);
//			oferta = os.buscarOfertaPorId(idOferta);
//			Set<Inscripcion> inscripciones = cs.getInscripciones(candidato);
//			if (inscripciones != null) {
//				Iterator<Inscripcion> it = inscripciones.iterator();
//				boolean salirBucle = false;
//				while (it.hasNext() && salirBucle == false) {
//					inscripcion = it.next();
//					if (inscripcion.getEstado() == "Preseleccion") {
//						salirBucle = true;
//					}
//				}
//			}
//			resultado = "SUCCESS";
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public String aceptarCandidatura() {
//		String resultado = "ERROR";
//		sg = ServiciosGlobales.getInstance();
//		if (sg.comprobarLogin()) {
//			cs = CandidatosServicios.getInstance();
//			os = OfertasServicios.getInstance();
//			candidato = cs.buscarCandidatoPorId(idCandidato);
//			oferta = os.buscarOfertaPorId(idOferta);
//			resultado = sg.aceptarCandidatura(candidato, oferta);
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public String desestimarCandidatura() {
//		String resultado = "ERROR";
//		sg = ServiciosGlobales.getInstance();
//		if (sg.comprobarLogin()) {
//			cs = CandidatosServicios.getInstance();
//			os = OfertasServicios.getInstance();
//			candidato = cs.buscarCandidatoPorId(idCandidato);
//			oferta = os.buscarOfertaPorId(idOferta);
//			resultado = sg.desestimarCandidatura(candidato, oferta);
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
	public String mostrarRegistro() {
		String resultado = "SUCCESS";
//		String resultado = this.cargarSectores();
		return resultado;
	}
//
//	public String cargarSectores() {
//		String resultado = "ERROR";
//		ss = SectoresServicios.getInstance();
//		List<Sector> sectores = ss.mostrarSectores();
//		Iterator<Sector> i = sectores.iterator();
//		if (sectores.size() > 0) {
//			listaSectores = new ArrayList();
//			while (i.hasNext()) {
//				listaSectores.add(i.next().getNombre());
//			}
//		}
//		resultado = "SUCCESS";
//		return resultado;
//	}
//
	public static String salirSeguridad() {
		String resultado = "SUCCESS";
		session = ActionContext.getContext().getSession();
		session.clear();
		return resultado;
	}
//
//	public Oferta getOferta() {
//		return oferta;
//	}
//
//	public void setOferta(Oferta oferta) {
//		this.oferta = oferta;
//	}
//
//	public Candidato getCandidato() {
//		return candidato;
//	}
//
//	public void setCandidato(Candidato candidato) {
//		this.candidato = candidato;
//	}
//
//	public Inscripcion getInscripcion() {
//		return inscripcion;
//	}
//
//	public void setInscripcion(Inscripcion inscripcion) {
//		this.inscripcion = inscripcion;
//	}
//
//	public String getMensaje() {
//		return mensaje;
//	}
//
//	public Integer getIdOferta() {
//		return idOferta;
//	}
//
//	public void setIdOferta(Integer idOferta) {
//		this.idOferta = idOferta;
//	}
//
//	public Integer getIdCandidato() {
//		return idCandidato;
//	}
//
//	public void setIdCandidato(Integer idCandidato) {
//		this.idCandidato = idCandidato;
//	}
//
//	public List<String> getListaSectores() {
//		return listaSectores;
//	}
}