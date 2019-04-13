package com.thrm.services;

import com.google.appengine.api.datastore.Key;
import com.thrm.dao.EmpresasDAO;
import com.thrm.dao.OfertaDAO;
import com.thrm.domain.*;

import java.util.ArrayList;
import java.util.List;

public class OfertaServicios extends AbstractServicios {

	private static OfertaServicios os = null;
	private OfertaDAO ofertaDAO = null;
	private EmpresasDAO empresasDAO = new EmpresasDAO();
	private CursosServicios cus = null;

	private OfertaServicios() {
		ofertaDAO = new OfertaDAO();
	}

	public static OfertaServicios getInstance() {
		if (os == null) {
			os = new OfertaServicios();
		}
		return os;
	}

	public List<Oferta> mostrarOfertas() {
		return ofertaDAO.findAll();
	}

	public List<Oferta> buscarOfertasPorNombre(String nombre) {
		return ofertaDAO.findByNombre(nombre);
	}
	
	public List<Oferta> buscarOfertasPorTipoContrato(String tipoContrato){
		return ofertaDAO.findByTipoContrato(tipoContrato);
	}

	public List<Oferta> buscarOfertasPorEstado(Oferta.Estados estado){
		return ofertaDAO.findByEstado(estado);
	}

//	public List<Oferta> ultimasOfertas() {
//		ofertas = ofertaDAO.findLastFive();
//		return ofertas;
//	}
//
	public List<Oferta> misUltimasOfertas(Responsable responsable) {
//		Set<Oferta> coleccionOfertas = responsable.getEmpresas().getOfertases();
//		Iterator<Oferta> it = coleccionOfertas.iterator();
		int i = 1;
		List<Oferta> ofertas = new ArrayList<Oferta>();
//		while (it.hasNext() && i <= 5) {
//			ofertas.add(it.next());
//			i++;
//		}
		return ofertas;
	}

//	public Oferta buscarOfertaPorId(long id) {
//		Oferta o = ofertaDAO.findById(id);
//		return o;
//	}

	public Oferta buscarOfertaByKey(Key key){
		Oferta o = ofertaDAO.findByKey(key);
		return o;
	}
	
//	public List<String> listarBusquedaOfertas() {
//		ArrayList<String> listadoOfertas;
//		Iterator<Oferta> i = ofertas.iterator();
//		listadoOfertas = new ArrayList();
//		while (i.hasNext()) {
//			Oferta o = (Oferta) i.next();
//			listadoOfertas.add(o.getNombre());
//			// listadoOfertas.add(o.getPais());
//			// listadoOfertas.add(o.getPoblacion());
//			// listadoOfertas.add(o.gettipoContrato());
//		}
//		return listadoOfertas;
//	}


	/**
	 * Your user instance is already loaded in the persistence context, 
	 * just modifiy it and don't invoke any EntityManager method, 
	 * the JPA provider will automatically update the database at flush or commit time.
	 * 
	 */
	public String crearOferta(Empresa empresa, Oferta oferta) {
		String resultado = "ERROR";
		empresa.addOferta(oferta);
		oferta.setEmpresa(empresa);
		
		empresasDAO.merge(empresa);
		resultado = "SUCCESS";
		return resultado;
	}
	
	public String modificarOferta (Oferta oferta){
		
		ofertaDAO.merge(oferta);

		return "SUCCESS";
		
	}

	public String eliminarOferta(Key key) {
		String resultado = "ERROR";
		Oferta oferta = ofertaDAO.findByKey(key);
		oferta.setEstado(Oferta.Estados.ELIMINADA);
		ofertaDAO.merge(oferta);
		resultado = "SUCCESS";
		return resultado;
	}

//	public String crearFormacionOferta(Oferta oferta, Curso curso) {
//		String resultado = "ERROR";
//		cus = CursosServicios.getInstance();
//		if (oferta != null && curso != null) {
//			Set<Curso> cursosOferta = oferta.getCursoses();
//			cursosOferta.add(curso);
//			oferta.setCursoses(cursosOferta);
//			resultado = "SUCCESS";
//		}
//		return resultado;
//	}
//
//	/*
//	 * public String eliminarFormacionOferta(int identificador) { String
//	 * resultado="ERROR"; fs=FormacionesServicios.getInstance(); Formacion
//	 * formacion=fs.buscarFormacionPorId(identificador);
//	 * resultado=fs.eliminarFormacion(formacion); return resultado; }
//	 */
//
//	public List<Oferta> buscarOferta(Oferta oferta) {
//		ofertas = ofertaDAO.findByExample(oferta);
//		return ofertas;
//	}

}
