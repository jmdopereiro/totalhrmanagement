package com.thrm.actions;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thrm.domain.*;
import com.thrm.services.EmpresaServicios;
import com.thrm.services.InscripcionServicios;
import com.thrm.services.OfertaServicios;
import com.thrm.services.ServiciosGlobales;

import java.net.URLDecoder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.thrm.domain.ConocimientosEnOfertas;

public class ActionOferta extends ActionSupport {

	private String tipoBusqueda = null;
	private Long id = null;
	
	private Oferta oferta = null;
	private List<Oferta> ofertas = null;
	private List<Oferta> ofertasRecomendadas = null;
	private List<Oferta> ultimasOfertas = null;
	private List<String> listadoBusquedaOfertas = null;
	private String posibleInscripcion = null;
	private String mensaje = null;
	private ServiciosGlobales serviciosGlobales;
	private String palabraClave = null;
	private boolean inscripcionError = false;
	private Formacion formacion = null;
	private List<Curso> listaCursos = null;
	private List<Idioma> listaIdiomas = null;
	private List<Conocimiento> listaConocimientos = null;
	private IdiomaEnOferta idiomaOferta = null;
//	private ConocimientosEnOfertas conocimientoOferta = null;
	private boolean modificarFormacionError = false;
	private boolean modificarIdiomaError = false;
	private boolean modificarConocimientoError = false;
	private Responsable responsable = null;
	private Curso cursoOferta = null;
	private List<Candidato> candidatos = null;
	
	private Long idEmpresa;
	private EmpresaServicios empresaServicios;
	private OfertaServicios ofertaServicios;
	private InscripcionServicios inscripcionServicios;

	static final Logger logger = Logger.getLogger("ActionOferta");	
	
	public String mostrarOfertas() {
		String resultado = "SUCCESS";
		ofertas = ofertaServicios.mostrarOfertas();
//			resultado = this.recargarPagina();
		return resultado;
	}

//	public String listarBusquedaOfertas() {
//		String resultado = "ERROR";
//		listadoBusquedaOfertas = ofertaServicios.listarBusquedaOfertas();
//		resultado = "SUCCESS";
//		return resultado;
//	}


	/**
	 * At the moment this action method is being used for both the search screen of the candidate and
	 * the search screen of the manager.
	 * 
	 * @return
	 */
	public String buscarOfertas() {
		String resultado = "ERROR";
		if (oferta != null) {

			if(oferta.getNombre() != null && !oferta.getNombre().equals(""))
				ofertas = ofertaServicios.buscarOfertasPorNombre(oferta.getNombre());
			else if(oferta.getEmpresa() != null && oferta.getEmpresa().getNombre() != null && !oferta.getEmpresa().getNombre().equals("")) {
				List<Empresa> empresas = empresaServicios.buscarEmpresasPorNombre(oferta.getEmpresa().getNombre());
				if (empresas.size() > 0)
					ofertas = Arrays.asList(empresas.get(0).getOfertas().toArray(new Oferta[0]));
			}
			else if(oferta.getTipoContrato() != null) {
				ofertas = ofertaServicios.buscarOfertasPorTipoContrato(oferta.getTipoContrato());
			} else if (oferta.getDuracion() != null) {
				ofertas = ofertaServicios.buscarOfertas(oferta);
			} else if (oferta.getEstado() != null) {
				ofertas = ofertaServicios.buscarOfertasPorEstado(oferta.getEstado());
			}

			if (ofertas != null) {
				logger.info(ofertas.size() + oferta.getNombre());
			}
			resultado = "SUCCESS";
//			this.recargarPagina();
		}
		return resultado;
	}

	public String buscarOfertasResponsable() {
		logger.info("Dentro de buscarOfertasResponsable");

		ofertas = new ArrayList<Oferta>();
		String resultado = "ERROR";
		if (oferta != null) {

			Empresa empresa = (Empresa)ActionContext.getContext().getSession().get("empresa");
			
			if(oferta.getNombre() != null && !oferta.getNombre().equals("")) {
				for(Oferta item: empresa.getOfertas()) {
					if(oferta.getNombre().equals(item.getNombre())) {
						ofertas.add(item);
					}
				}
			}
//			else if(oferta.getTipoContrato() != null) {
//				ofertas = ofertaServicios.buscarOfertasPorTipoContrato(oferta.getTipoContrato());
//			}
//			else if(oferta.getEstado() != null) {
//				ofertas = ofertaServicios.buscarOfertasPorEstado(oferta.getEstado());
//			}

			logger.info(ofertas.size() + oferta.getNombre());
			resultado = "SUCCESS";
//			this.recargarPagina();
		}
		return resultado;
	}

//	public String recargarPagina() {
//		String resultado = "ERROR";
//		resultado = this.listarBusquedaOfertas();
//		resultado = this.ultimasOfertas();
//		return resultado;
//	}
//
//	public void buscarOfertasRecomendadas() {
//		ofertasRecomendadas = new ArrayList<Oferta>(5);
//		int idCandidato;
//		os = OfertasServicios.getInstance();
//		/* Match */
//
//	}
//
//	public String ultimasOfertas() {
//		String resultado = "ERROR";
//		os = OfertasServicios.getInstance();
//		ultimasOfertas = os.ultimasOfertas();
//		resultado = "SUCCESS";
//		return resultado;
//	}
//
//	public String misUltimasOfertas() {
//		String resultado = "ERROR";
//		os = OfertasServicios.getInstance();
//		ultimasOfertas = os.ultimasOfertas();
//		resultado = "SUCCESS";
//		return resultado;
//	}

	/**
	 * Este metodo deberia llamarse verOfertaCandidato porque parece que es para el candidato.
	 */
	public String verOferta() {
		String resultado = "ERROR";
		oferta = getOfertaServicios().buscarOfertaByKey(getOfertaKeyFromEmpresaAndId());
		Candidato candidato = serviciosGlobales.cargarCandidato();
		this.comprobarPosibleInscripcion(oferta, candidato);
		resultado = "SUCCESS";
		return resultado;
	}

	public String verOfertaResponsable() {
		String resultado = "ERROR";
//		oferta = OfertasServicios.getInstance().buscarOfertaPorId(id);
		logger.info("id = " + id);
		Key key = getOfertaKeyFromEmpresaAndId();
		oferta = ofertaServicios.buscarOfertaByKey(key);
		
		resultado = "SUCCESS";
		return resultado;
	}

	private Key getOfertaKeyFromEmpresaAndId() {
		
		Empresa empresa = null;
		
		if(idEmpresa != null)//In this case we come from candidato.
			empresa = getEmpresaServicios().buscarEmpresaPorId(idEmpresa);
		else				//In this other case we come from responsable.
			empresa = (Empresa)ActionContext.getContext().getSession().get("empresa");

		Key key = empresa.getKey().getChild("Oferta", id);
		return key;
	}

//	/* SIN ACABAR TODAS LAS COMPROBACIONES (otros estados de oferta) */
	public void comprobarPosibleInscripcion(Oferta oferta, Candidato candidato) {

		boolean inscrito = serviciosGlobales.comprobarExistenciaInscripcion(candidato, oferta);
		boolean plazoFinalizado = plazoOfertaFinalizado(oferta);
		if (inscrito) {
			if (plazoFinalizado) {
				posibleInscripcion = "YaInscritoNoEliminar";
			} else {
				posibleInscripcion = "YaInscritoEliminar";
			}
		} else {
			if (!plazoFinalizado) {
				posibleInscripcion = "OK";
			} else {
				posibleInscripcion = "PlazoCerrado";
			}
		}
	}

	public String inscribirCandidato() {

		String resultado = "ERROR";
		try {
			System.out.println(idEmpresa);

			Candidato candidato = serviciosGlobales.cargarCandidato();
			Key ofertaKey = getOfertaKeyFromEmpresaAndId();
			oferta = ofertaServicios.buscarOfertaByKey(ofertaKey);
			System.out.println(oferta.getEstado());
//			if (oferta.getEstado().equals("Iniciada")) {
				if (!plazoOfertaFinalizado(oferta)) {
					resultado = inscripcionServicios.inscribirCandidato(candidato, oferta);
					mensaje = "inscripcionExito";
				}
				if (resultado.equals("ERROR")) {
					mensaje = "inscripcionError";
				}
//			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public String eliminarInscripcion() {
		String resultado = "ERROR";
		inscripcionError = true;
		Candidato candidato = serviciosGlobales.cargarCandidato();

		try {

			Key ofertaKey = getOfertaKeyFromEmpresaAndId();
			Oferta oferta = ofertaServicios.buscarOfertaByKey(ofertaKey);

			if (!plazoOfertaFinalizado(oferta)) {
				resultado = serviciosGlobales.eliminarInscripcionCandidato(candidato, oferta);
				resultado = "SUCCESS";
				mensaje = "eliminarInscripcionExito";
			}
			if (resultado.equals("ERROR")) {
				mensaje = "eliminarInscripcionError";
			}
			inscripcionError = false;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public String mostrarCrearOferta() {

	    String label = getText("registroOferta.datosGenericos.descripcion");
        URLDecoder.decode(label);

		String resultado = "ERROR";
		listaCursos = getServiciosGlobales().cargarCursos();
//			listaIdiomas = serviciosGlobales.cargarIdiomas();
//			listaConocimientos = serviciosGlobales.cargarConocimientos();
		responsable = serviciosGlobales.cargarResponsable();
		resultado = "SUCCESS";
		return resultado;
	}

	public String crearActualizarOferta() {
		
		if(id != null)
			return modificarOferta();
		else{
			if (oferta.getFechaInicio() != null && oferta.getFechaFin() != null) {
				if (oferta.getFechaInicio().after(oferta.getFechaFin())) {
					addActionError("El dia de inicio no puede ser posterior al dia de finalización");
					addFieldError("oferta.fechainicio", "");
					addFieldError("oferta.fechafin", "");
				} else {
					if (!plazoOfertaFinalizado(oferta)) {
						Empresa empresa = (Empresa)ActionContext.getContext().getSession().get("empresa");
//						logger.info("empresa is in " + NucleusJPAHelper.getObjectState(empresa) + " state ");
						ofertaServicios.crearOferta(empresa, oferta);
					} else {
						// TODO This error is not showed in the screen
						logger.log(Level.CONFIG, "El plazo de finalización no puede ser anterior al dia de hoy");
						addActionError("La fecha de finalización de la oferta no puede ser anterior al dia de hoy");
						addFieldError("oferta.fechafin", "");
					}
				}
			}
			return "SUCCESS";
		}
	}
	
	@Override
	public void validate() {
		if (oferta.getFechaInicio() == null || oferta.getFechaFin() == null || oferta.getFechaInicio().equals("") || oferta.getFechaFin().equals("")) {
			addActionError("Los campos Fecha de inicio y Fecha de finalización son obligatorios");
			addFieldError("oferta.fechainicio", "");
			addFieldError("oferta.fechafin", "");
		}
	}

	public String modificarOferta(){
		
		Key key = getOfertaKeyFromEmpresaAndId();
		oferta.setKey(key);
		
		return ofertaServicios.modificarOferta(oferta);
	}

	public String eliminarOferta() {
		String resultado = "ERROR";
		
		Key key = getOfertaKeyFromEmpresaAndId();
		
		resultado = ofertaServicios.eliminarOferta(key);
		return resultado;
	}

	public String mostrarEditarOferta() {
		String resultado = "ERROR";
		Key key = getOfertaKeyFromEmpresaAndId();
		oferta = ofertaServicios.buscarOfertaByKey(key);
		if (oferta != null) {
//				if (serviciosGlobales.comprobarPermisosResponsable(oferta)) {
//					listaCursos = serviciosGlobales.cargarCursos();
//					listaIdiomas = serviciosGlobales.cargarIdiomas();
//					listaConocimientos = serviciosGlobales.cargarConocimientos();
			resultado = "SUCCESS";
//				} else {
//					resultado = "LOGIN";
//				}
		}
		return resultado;
	}

private Empresa getEmpresaFromSession() {
	Map<String, Object> session = ActionContext.getContext().getSession();
	Empresa empresa = (Empresa) session.get("empresa");
	return empresa;
}

//	public String crearFormacionOferta() {
//		String resultado = "ERROR";
//		modificarFormacionError = true;
//		os = OfertasServicios.getInstance();
//		oferta = os.buscarOfertaPorId(idOferta);
//		resultado = os.crearFormacionOferta(oferta, cursoOferta);
//		return resultado;
//	}
//
//	public String eliminarFormacionOferta() {
//		String resultado = "ERROR";
//		modificarFormacionError = true;
//		resultado = serviciosGlobales.eliminarFormacionCandidato(id);
//		return resultado;
//	}
//
//	public String crearIdiomaOferta() {
//		String resultado = "ERROR";
//		modificarIdiomaError = true;
//		os = OfertasServicios.getInstance();
//		oferta = os.buscarOfertaPorId(idOferta);
//		String nombreIdioma = idiomaOferta.getIdiomas().getNombre();
//		resultado = serviciosGlobales.crearIdiomaOferta(nombreIdioma, idiomaOferta, oferta);
//		return resultado;
//	}
//
//	public String eliminarIdiomaOferta() {
//		String resultado = "ERROR";
//		modificarIdiomaError = true;
//		resultado = serviciosGlobales.eliminarIdiomaOferta(id);
//		return resultado;
//	}
//
//	public String crearConocimientoOferta() {
//		String resultado = "ERROR";
//		modificarConocimientoError = true;
//		os = OfertasServicios.getInstance();
//		oferta = os.buscarOfertaPorId(idOferta);
//		String nombreConocimiento = conocimientoOferta.getConocimientos().getNombre();
//		resultado = serviciosGlobales.crearConocimientoOferta(nombreConocimiento, conocimientoOferta, oferta);
//		return resultado;
//	}
//
//	public String eliminarConocimientoOferta() {
//		String resultado = "ERROR";
//		modificarConocimientoError = true;
//		resultado = serviciosGlobales.eliminarConocimientoOferta(id);
//		return resultado;
//	}

	public String buscarCandidatosInscritosEnOferta() {
		String resultado = "ERROR";

		Key ofertaKey = getOfertaKeyFromEmpresaAndId();
		Oferta oferta = ofertaServicios.buscarOfertaByKey(ofertaKey);
		
		candidatos = serviciosGlobales.buscarCandidatosInscritos(oferta);
		resultado = "SUCCESS";
		return resultado;
	}

	public static boolean plazoOfertaFinalizado(Oferta oferta) {

		logger.info(oferta.getFechaFin().toString());
		Date hoy = Calendar.getInstance().getTime();

		return hoy.after(oferta.getFechaFin());
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

//	public List<Oferta> getOfertaRecomendadas() {
//		return ofertasRecomendadas;
//	}
//
//	public List<Oferta> getUltimasOfertas() {
//		return ultimasOfertas;
//	}
//
//	public List<String> getListadoBusquedaOfertas() {
//		return listadoBusquedaOfertas;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public void setTipoBusqueda(String tipoBusqueda) {
//		this.tipoBusqueda = tipoBusqueda;
//	}

	public String getPosibleInscripcion() {
		return posibleInscripcion;
	}

//	public String getMensaje() {
//		return mensaje;
//	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

//	public void setInscripcionError(boolean inscripcionError) {
//		this.inscripcionError = inscripcionError;
//	}
//
//	public Formacion getFormacion() {
//		return formacion;
//	}
//
//	public void setFormacion(Formacion formacion) {
//		this.formacion = formacion;
//	}
//
//	public Idiomasenofertas getIdiomaOferta() {
//		return idiomaOferta;
//	}
//
//	public void setIdiomaOferta(Idiomasenofertas idiomaOferta) {
//		this.idiomaOferta = idiomaOferta;
//	}
//
//	public ConocimientosEnOfertas getConocimientoOferta() {
//		return conocimientoOferta;
//	}
//
//	public void setConocimientoOferta(ConocimientosEnOfertas conocimientoOferta) {
//		this.conocimientoOferta = conocimientoOferta;
//	}
//
//	public List<Curso> getListaCursos() {
//		return listaCursos;
//	}
//
//	public List<Idioma> getListaIdiomas() {
//		return listaIdiomas;
//	}
//
//	public List<Conocimientos> getListaConocimientos() {
//		return listaConocimientos;
//	}

	public boolean getModificarFormacionError() {
		return modificarFormacionError;
	}

	public void setModificarFormacionError(boolean modificarFormacionError) {
		this.modificarFormacionError = modificarFormacionError;
	}

//	public boolean getModificarIdiomaError() {
//		return modificarIdiomaError;
//	}
//
//	public void setModificarIdiomaError(boolean modificarIdiomaError) {
//		this.modificarIdiomaError = modificarIdiomaError;
//	}
//
//	public boolean getModificarConocimientoError() {
//		return modificarConocimientoError;
//	}
//
//	public void setModificarConocimientoError(boolean modificarConocimientoError) {
//		this.modificarConocimientoError = modificarConocimientoError;
//	}
//
//	public Curso getCursoOferta() {
//		return cursoOferta;
//	}
//
//	public void setCursoOferta(Curso cursoOferta) {
//		this.cursoOferta = cursoOferta;
//	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public void setIdEmpresa(long idEmpresa){
		this.idEmpresa = idEmpresa;
	}

	public EmpresaServicios getEmpresaServicios() {
		return empresaServicios;
	}

	public void setEmpresaServicios(EmpresaServicios empresaServicios) {
		this.empresaServicios = empresaServicios;
	}

	public OfertaServicios getOfertaServicios() {
		return ofertaServicios;
	}

	public void setOfertaServicios(OfertaServicios ofertaServicios) {
		this.ofertaServicios = ofertaServicios;
	}

	public ServiciosGlobales getServiciosGlobales() {
		return serviciosGlobales;
	}

	public void setServiciosGlobales(ServiciosGlobales serviciosGlobales) {
		this.serviciosGlobales = serviciosGlobales;
	}

	public void setInscripcionServicios(InscripcionServicios inscripcionServicios) {
		this.inscripcionServicios = inscripcionServicios;
	}
}