package com.thrm.actions;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.thrm.util.ContextProvider;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thrm.domain.Candidato;
import com.thrm.domain.Conocimiento;
import com.thrm.domain.ConocimientoEnCandidato;
import com.thrm.domain.Curriculum;
import com.thrm.domain.Curso;
import com.thrm.domain.Empresa;
import com.thrm.domain.Experiencia;
import com.thrm.domain.Formacion;
import com.thrm.domain.Idioma;
import com.thrm.domain.IdiomaEnCandidato;
import com.thrm.domain.Inscripcion;
import com.thrm.domain.Oferta;
import com.thrm.services.*;

public class ActionCandidato extends ActionSupport {

	private static final Log log = LogFactory.getLog(ActionCandidato.class);

	private List<Candidato> candidatos = null;
	private Candidato candidato = null;
	private String email;
	private String pass = null;
	private Set<Curriculum> curriculums = null;
	private List<Inscripcion> inscripciones = null;
	private Set<Formacion> formaciones = null;
	private List<Oferta> ofertas = null;
	private List<Empresa> empresas = null;
	private Set<Oferta> ofertasEmpresa = null;
	private String tipoBusqueda = null;
	private String palabraClave = null;
	private boolean registroCandidatoError = false;
	private String mensaje = null;
	
	private ServiciosGlobales serviciosGlobales;
	private CandidatosServicios candidatosServicios;

	private File fichero = null;
	private String ficheroContentType = null;
	private String ficheroFileName = null;

	private Date hoy = null;
	private String hola = null;
	private HttpServletResponse response = null;
	private CursosServicios cus = null;
	private List<String> listaCursosTipo = null;
	private List<String> listaCursosNombre = null;
	private boolean modificarFormacionError = false;
	private boolean modificarExperienciaError = false;
	private boolean modificarPasswordError = false;
	
	private Long id = null;
	private Long formacionId = null;
	
	private FormacionesServicios fs = null;
	private Formacion formacion = null;
	private List<Curso> listaCursos = null;
	private Experiencia experiencia = null;
	private List<Idioma> listaIdiomas = null;
	private List<Conocimiento> listaConocimientos = null;
	private IdiomaEnCandidato idiomaEnCandidato = null;
	private ConocimientoEnCandidato conocimientoEnCandidato = null;
	private String passwordAntigua = null;
	private String passwordNueva = null;
	private String password = null;
	private String idiomaCurriculum = null;
	private Long curriculumId = null;
	private Long idiomaEnCandidatoId = null;
	private Long conocimientoEnCandidatoId = null;
	private String urlFoto = null;
	
	private InputStream ficheroStream = null;
	private long experienciaId;
	private EmpresaServicios empresaServicios;
	private FormacionesServicios formacionesServicios;

	@PostConstruct
	public void init() {
		serviciosGlobales = ContextProvider.getBean(ServiciosGlobales.class);
	}

	public String principalCandidato() {
		String resultado = "ERROR";
//			ofertas = os.ultimasOfertas();
		empresas = getEmpresaServicios().ultimasEmpresas();
		hoy = Calendar.getInstance().getTime();
		resultado = "SUCCESS";
		return resultado;
	}

	public String perfilCandidato() {
		candidato = getServiciosGlobales().cargarCandidato();

//		Set<IdiomaEnCandidato> idiomasEnCandidato = candidato.getIdiomasEnCandidato();
//		IdiomaEnCandidato idiomaEnCandidato = idiomasEnCandidato.iterator().next();
		
		curriculums = candidato.getCurriculums();
//			inscripcion = cs.getInscripciones(candidato);
		return "SUCCESS";
	}

	private CandidatosServicios getCandidatosServicios() {
		return candidatosServicios;
	}

	public String registrarCandidato() {
		String resultado = "ERROR";
		if (getCandidatosServicios().verificarExistenciaDniEmail(candidato.getDni(), candidato.getEmail())) {
			addActionError("El dni o el email introducido ya existe en nuestra BD");
			addFieldError("candidato.dni", "");
			addFieldError("email", "");
			addFieldError("candidato.email", "");
		} else {
			resultado = getCandidatosServicios().registrar(candidato);
			ActionContext.getContext().getSession().put("dniUsuario", candidato.getDni());
			mensaje = "bienvenida";
		}
		return resultado;
	}

	public String subirFoto() {

		String resultado = "ERROR";
		if (fichero != null) {
			log.info("Uploading file: " + fichero.getName());
			candidato = getServiciosGlobales().cargarCandidato();
			candidato.setFotoContentType(ficheroContentType);
			candidato.setFotoFileName(ficheroFileName);
			resultado = candidatosServicios.guardarFoto(candidato, fichero);
		} else
			log.error("Unable to upload file");

		mensaje = "subirFotoExito";
		if (resultado.equals("ERROR")) {
			mensaje = "subirFotoError";
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public void mostrarFoto() {

		try {
			if (id == null) {
				candidato = getServiciosGlobales().cargarCandidato();
			} else {
				candidato = candidatosServicios.buscarCandidatoPorId(id);
			}
			response = ServletActionContext.getResponse();
			ServletOutputStream sos = response.getOutputStream();

			InputStream inputStream = new ByteArrayInputStream(candidato.getFoto().getBytes());
			BufferedInputStream iis;
			iis = new BufferedInputStream(inputStream);



//			BufferedImage image = ImageIO.read(iis);
//			ImageIO.write(image, "JPG", sos);

			sos.write(candidato.getFoto().getBytes(), 0, 524288);
			iis.close();
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String eliminarFoto() {
		String resultado = "ERROR";
		candidato = getServiciosGlobales().cargarCandidato();
		resultado = candidatosServicios.eliminarFoto(candidato);
		mensaje = "eliminarFotoExito";
		if (resultado.equals("ERROR")) {
			mensaje = "eliminarFotoError";
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public String subirCurriculum() {
		String resultado = "ERROR";
		if (fichero != null) {
			candidato = getServiciosGlobales().cargarCandidato();
//			resultado = getServiciosGlobales().guardarCurriculum(fichero, candidato, idiomaCurriculum, ficheroFileName, ficheroContentType);
		}
		mensaje = "subirCurriculumExito";
		if (resultado.equals("ERROR")) {
			mensaje = "subirCurriculumError";
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public String descargarCurriculum() {
		Curriculum curriculum = getServiciosGlobales().descargarCurriculum(getCurriculumKeyFromCandidatoAndId());
		setFileMetaData(curriculum.getFichero().getBytes(), curriculum.getFileName(), curriculum.getContentType());

		return "success";
	}

	public String eliminarCurriculum() {
		String resultado = "ERROR";
		Key key = getCurriculumKeyFromCandidatoAndId();
		resultado = getServiciosGlobales().eliminarCurriculum(candidato, key);
		mensaje = "eliminarCurriculumExito";
		if (resultado.equals("ERROR")) {
			mensaje = "eliminarCurriculumError";
			resultado = "SUCCESS";
		}
		return resultado;
	}

	public String guardar(File fichero, String ruta) {
		String	resultado = "ERROR";
		try {
			String rutaFichero = "/fotos/" + ruta;
			File lugarCopia = new File(rutaFichero);
			System.out.println(lugarCopia.getAbsolutePath());
			FileUtils.copyFile(fichero, lugarCopia);
			resultado = "SUCCESS";
		} catch	(Exception e) {
			System.out.println("LOLA");
			addActionError(e.getMessage());
			resultado = "INPUT";
		}
		return resultado;
	}


	@Override
	public void validate() {
//		if (!getServiciosGlobales().comprobarDni(candidato.getDni())) {
//			addActionError("El dni introducido es erróneo");
//			addFieldError("candidato.dni", "");
//		}
//		if(!candidato.getEmail().equals(email)) {
//			addActionError("Los emails no coinciden");
//			addFieldError("candidato.email","");
//			addFieldError("email","");
//		}
	}

	public String mostrarCandidatos() {
		String resultado = "ERROR";
		setCandidatos(getCandidatosServicios().mostrarCandidatos());
		resultado = "SUCCESS";
		return resultado;
	}

	public String eliminarCandidato() {
		String resultado = "ERROR";
		if (palabraClave.equals("ELIMINAR")) {
			Map session = ActionContext.getContext().getSession();
			String dni = session.get("dniUsuario").toString();
			resultado = getCandidatosServicios().eliminarCandidato(dni);
		} else {
			addFieldError("palabraClave", "Debes introducir la palabra: " + "ELIMINAR");
		}
		return resultado;
	}

	public String mostrarInscripciones() {
		String resultado = "ERROR";
		candidato = getServiciosGlobales().cargarCandidato();
		inscripciones = getCandidatosServicios().getInscripciones(candidato);
		resultado = "SUCCESS";
		return resultado;
	}

	public String modificarPerfilCandidato() {
		cargarDatos();
		return "SUCCESS";
	}

	private void cargarDatos() {
		candidato = getServiciosGlobales().cargarCandidato();
		setEmail(candidato.getEmail());
		listaCursos = getServiciosGlobales().cargarCursos();
		listaIdiomas = getServiciosGlobales().cargarIdiomas();
		setListaConocimientos(getServiciosGlobales().cargarConocimientos());
	}

	private ServiciosGlobales getServiciosGlobales() {
		return serviciosGlobales;
	}

	public void setServiciosGlobales(ServiciosGlobales serviciosGlobales) {
		this.serviciosGlobales = serviciosGlobales;
	}
	
	public String modificarDatosPersonalesCandidato() {
		
		if(fichero!=null)
			candidato.setFoto(getServiciosGlobales().fileToBlob(fichero));

		return getCandidatosServicios().modificarDatosPersonales(candidato);
	}

	public String crearFormacionCandidato() {
		String resultado = "ERROR";
		modificarFormacionError = true;
		candidato = getServiciosGlobales().cargarCandidato();
//			String nombreCurso = formacion.getCurso().getNombre();
		
		formacion.setExpedienteContentType(ficheroContentType);
		formacion.setExpedienteFileName(ficheroFileName);
//		resultado = getServiciosGlobales().crearFormacionCandidato(formacion, fichero, candidato, "");

		return resultado;
	}

//	public String eliminarFormacionCandidato() {
//		String resultado = "ERROR";
//			modificarFormacionError = true;
//			resultado = serviciosGlobales.eliminarFormacionCandidato(id);
//		return resultado;
//	}

	public String crearExperienciaCandidato() {
		String resultado = "ERROR";
		modificarExperienciaError = true;
		candidato = getServiciosGlobales().cargarCandidato();
		resultado = getServiciosGlobales().crearExperienciaCandidato(experiencia, candidato);
		return resultado;
	}

	public String eliminarExperienciaCandidato() {
		Key key = getExperienciaKeyFromCandidatoAndId();
		String resultado = getServiciosGlobales().eliminarExperienciaCandidato(candidato, key);
		return resultado;
	}

	private Key getExperienciaKeyFromCandidatoAndId() {
		candidato = getCandidatoFromIdOrSession();
		Key key = candidato.getKey().getChild("Experiencia", experienciaId);
		return key;
	}
	
	public String crearIdiomaCandidato() {
		String resultado = "ERROR";
		modificarFormacionError = true;
		candidato = getServiciosGlobales().cargarCandidato();
		String nombreIdioma = idiomaEnCandidato.getIdioma().getNombre();
		resultado = getServiciosGlobales().crearIdiomaCandidato(nombreIdioma, idiomaEnCandidato, candidato);
		return resultado;
	}

	public String eliminarIdiomaEnCandidato() {
//		modificarFormacionError = true;
		Key key = getIdiomaEnCandidatoKeyFromCandidatoAndId();
		String resultado = getServiciosGlobales().eliminarIdiomaEnCandidatoByKey(key);
		return resultado;
	}

	public String crearConocimientoCandidato() {
		candidato = getServiciosGlobales().cargarCandidato();
		String nombreConocimiento = conocimientoEnCandidato.getConocimiento().getNombre();
		String resultado = getServiciosGlobales().crearConocimientoCandidato(nombreConocimiento, conocimientoEnCandidato, candidato);
		return resultado;
	}

	public String eliminarConocimientoEnCandidato() {
		modificarFormacionError = true;

		Candidato candidato = getCandidatoFromIdOrSession();
		Key key = getConocimientoEnCandidatoKeyFromCandidatoAndId(candidato);
		String resultado = candidatosServicios.eliminarConocimientoEnCandidatoByKey(candidato, key);
		return resultado;
	}

	public String cambiarPassword() {
		String resultado = "ERROR";
		mensaje = "cambioPasswordError";
		modificarPasswordError = true;
		cargarDatos();
		if (candidato.getPassword().equals(passwordAntigua)) {

			if (password.equals(passwordNueva)) {
				resultado = candidatosServicios.cambiarPassword(candidato, password);
				mensaje = "cambioPasswordExito";
				modificarPasswordError = false;
			}
			/*
			 * Ha introducido mal la segunda contraseña, deberiamos de hacer
			 * esta comprobación por AJAX
			 */
			else {
//				addActionError("Las nuevas contraseñas introducidas no coinciden."); The message is not being showed in the page
				addFieldError("passwordNueva", "Las nuevas contraseñas introducidas no coinciden.");
				addFieldError("password", "");
			}

		}
		/* La contraseña que ha introducido es errónea */
		else {
//			addActionError("La contraseña introducida es errónea.");
			addFieldError("passwordAntigua", "La contraseña introducida es errónea.");
		}
		return resultado;
	}
	
//	public void validate() {
//		if(candidato.getPassword().length() == 0) {
//			addFieldError("passwordAntigua", "Debe introducir la contraseña actual");
//		}
//	}

	private Key getConocimientoEnCandidatoKeyFromCandidatoAndId(Candidato candidato) {
		Key key = candidato.getKey().getChild("ConocimientoEnCandidato", conocimientoEnCandidatoId);
		return key;
	}


	public String verCandidato() {
		String resultado = "ERROR";
		candidato = getCandidatosServicios().buscarCandidatoPorId(id);
		resultado = "SUCCESS";
		return resultado;
	}

	public String descargarExpediente() {

		formacion = getFormacionesServicios().buscarFormacionPorKey(getFormacionKeyFromCandidatoAndId());
		setFileMetaData(formacion.getExpediente().getBytes(), formacion.getExpedienteFileName(), formacion.getExpedienteContentType());

		return "success";
	}

	private void setFileMetaData(byte[] bytes, String fileName, String contentType) {
		ficheroStream = new ByteArrayInputStream(bytes);
		ficheroFileName = fileName;
		ficheroContentType = contentType;
	}
	
	private Key getFormacionKeyFromCandidatoAndId() {
		Candidato candidato = getCandidatoFromIdOrSession();
		Key key = candidato.getKey().getChild("Formacion", formacionId);
		return key;
	}

	private Key getCurriculumKeyFromCandidatoAndId() {
		Candidato candidato = getCandidatoFromIdOrSession();
		Key key = candidato.getKey().getChild("Curriculum", curriculumId);
		return key;
	}
	
	private Key getIdiomaEnCandidatoKeyFromCandidatoAndId() {
		Candidato candidato = getCandidatoFromIdOrSession();
		Key key = candidato.getKey().getChild("IdiomaEnCandidato", idiomaEnCandidatoId);
		return key;
	}
	
	private Candidato getCandidatoFromIdOrSession() {
		Candidato candidato = null;
		if(id == null) {//In this case we come from Candidato
			candidato = getServiciosGlobales().cargarCandidato();
		}
		else {//In this case we come from Responsable
			candidato = getCandidatosServicios().buscarCandidatoPorId(id);
		}
		return candidato;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getPass() {
//		return pass;
//	}
//
//	public void setPass(String pass) {
//		this.pass = pass;
//	}

	public Set<Curriculum> getCurriculums() {
		return curriculums;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public Set<Formacion> getFormaciones() {
		return formaciones;
	}

//	public List<Oferta> getOfertas() {
//		return ofertas;
//	}
//
//	public List<Empresa> getEmpresas() {
//		return empresas;
//	}
//
//	public Set<Oferta> getOfertasEmpresa() {
//		return ofertasEmpresa;
//	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

//	public void setTipoBusqueda(String tipoBusqueda) {
//		this.tipoBusqueda = tipoBusqueda;
//	}
//
//	public boolean getPerfilError() {
//		return perfilError;
//	}
//
	public boolean getRegistroCandidatoError() {
		return registroCandidatoError;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

//	public String getMensaje() {
//		return mensaje;
//	}
//
//	public void setMensaje(String mensaje) {
//		this.mensaje = mensaje;
//	}

	/*
	 * public void setRuta(String ruta) { this.ruta=ruta; }
	 */
	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public String getFicheroContentType() {
		return ficheroContentType;
	}

	public void setFicheroContentType(String ficheroContentType) {
		this.ficheroContentType = ficheroContentType;
	}

	public String getFicheroFileName() {
		return ficheroFileName;
	}

	public void setFicheroFileName(String ficheroFileName) {
		this.ficheroFileName = ficheroFileName;
	}

//	public void setServletResponse(HttpServletResponse response) {
//		this.response = response;
//	}
//
//	public HttpServletResponse getServletResponse() {
//		return response;
//	}
//
//	public Date getHoy() {
//		return hoy;
//	}

	public List<String> getListaCursosTipo() {
		return listaCursosTipo;
	}

	public List<String> getListaCursosNombre() {
		return listaCursosNombre;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public List<Idioma> getListaIdiomas() {
		return listaIdiomas;
	}

	public List<Conocimiento> getListaConocimientos() {
		return listaConocimientos;
	}

	public void setListaConocimientos(List<Conocimiento> listaConocimientos) {
		this.listaConocimientos = listaConocimientos;
	}

	public boolean getModificarFormacionError() {
		return modificarFormacionError;
	}

//	public boolean getModificarExperienciaError() {
//		return modificarExperienciaError;
//	}

	public boolean getModificarPasswordError() {
		return modificarPasswordError;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(Long curriculumId) {
		this.curriculumId = curriculumId;
	}

	public Formacion getFormacion() {
		return formacion;
	}

	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public InputStream getFicheroStream() {
		return ficheroStream;
	}

	public void setFicheroStream(InputStream ficheroStream) {
		this.ficheroStream = ficheroStream;
	}

	public Long getFormacionId() {
		return formacionId;
	}
	
	public void setFormacionId(Long formacionId) {
		this.formacionId = formacionId;
	}
	
	public IdiomaEnCandidato getIdiomaEnCandidato() {
		return idiomaEnCandidato;
	}

	public void setIdiomaEnCandidato(IdiomaEnCandidato idiomaEnCandidato) {
		this.idiomaEnCandidato = idiomaEnCandidato;
	}

	public Long getIdiomaEnCandidatoId() {
		return idiomaEnCandidatoId;
	}

	public void setIdiomaEnCandidatoId(Long idiomaEnCandidatoId) {
		this.idiomaEnCandidatoId = idiomaEnCandidatoId;
	}

	public ConocimientoEnCandidato getConocimientoEnCandidato() {
		return conocimientoEnCandidato;
	}

	public void setConocimientoEnCandidato(ConocimientoEnCandidato conocimientoEnCandidato) {
		this.conocimientoEnCandidato = conocimientoEnCandidato;
	}

	public Long getConocimientoEnCandidatoId() {
		return conocimientoEnCandidatoId;
	}

	public void setConocimientoEnCandidatoId(Long conocimientoEnCandidatoId) {
		this.conocimientoEnCandidatoId = conocimientoEnCandidatoId;
	}

	public long getExperienciaId() {
		return experienciaId;
	}

	public void setExperienciaId(long experienciaId) {
		this.experienciaId = experienciaId;
	}

	public void setCandidatosServicios(CandidatosServicios candidatosServicios) {
		this.candidatosServicios = candidatosServicios;
	}

	public EmpresaServicios getEmpresaServicios() {
		return empresaServicios;
	}

	public void setEmpresaServicios(EmpresaServicios empresaServicios) {
		this.empresaServicios = empresaServicios;
	}

	public FormacionesServicios getFormacionesServicios() {
		return formacionesServicios;
	}

	public void setFormacionesServicios(FormacionesServicios formacionesServicios) {
		this.formacionesServicios = formacionesServicios;
	}

	public void setPasswordAntigua(String passwordAntigua) {
		this.passwordAntigua = passwordAntigua;
	}

	public void setPasswordNueva(String passwordNueva) {
		this.passwordNueva = passwordNueva;
	}

	public void setPassword(String password) {
		this.password = password;
	}


//	public void setIdiomaCurriculum(String idiomaCurriculum) {
//		this.idiomaCurriculum = idiomaCurriculum;
//	}
//
//	public void setIdCurriculum(Integer idCurriculum) {
//		this.idCurriculum = idCurriculum;
//	}
//
//	public String getUrlFoto() {
//		return urlFoto;
//	}
//
//	public void setUrlFoto(String urlFoto) {
//		this.urlFoto = urlFoto;
//	}

	/*
	 * public String ajaxLista() { String resultado="ERROR"; listadoBusqueda=new
	 * ArrayList(); Configuration conf=new Configuration(); conf.configure();
	 * SessionFactory sessionFact=conf.buildSessionFactory();
	 * sesion=sessionFact.openSession(); Criteria
	 * crit=sesion.createCriteria(Empresa.class); List
	 * listaAuxiliar=crit.list(); Iterator it=listaAuxiliar.iterator();
	 * while(it.hasNext()) { Empresa e=(Empresa) it.next();
	 * listadoBusqueda.add(e.getNombre());
	 * 
	 * } crit=sesion.createCriteria(Sector.class); listaAuxiliar=crit.list();
	 * it=listaAuxiliar.iterator(); while(it.hasNext()) { Sector s=(Sector)
	 * it.next(); listaBusqueda.add(s.getNombre()); } resultado="SUCCESS";
	 * return resultado; }
	 */

	/*
	 * public List getListaBusqueda() { return listadoBusqueda; }
	 */

	/*
	 * public void insertarCandidato() { /* try {
	 * 
	 * HibernateUtil hu=HibernateUtil.getInstance(); sesion=hu.currentSession();
	 * transaccion = sesion.beginTransaction(); Criteria
	 * crit=sesion.createCriteria(Candidato.class); Candidato c=new
	 * Candidato(); c.setDni(candidatoBean.getDni());
	 * c.setNombre(candidatoBean.getNombre());
	 * c.setApellidos(candidatoBean.getApellidos());
	 * c.setPassword(candidatoBean.getPassword());
	 * c.setEmail(candidatoBean.getEmail()); sesion.save(c);
	 * System.out.println("Successfully data insert in database");
	 * transaccion.commit(); } catch(Exception e) {
	 * System.out.println(e.getMessage()); } finally { sesion.close(); } }
	 * public void consultarTodosCandidatos() { try { HibernateUtil
	 * hu=HibernateUtil.getInstance(); sesion=hu.currentSession(); Criteria
	 * crit=sesion.createCriteria(Candidato.class); List
	 * candidatos=crit.list(); Iterator it =candidatos.iterator();
	 * while(it.hasNext()) { Sector s=(Sector) it.next();
	 * System.out.println("ID: " + s.getIdsector()); System.out.println("Name: "
	 * + s.getNombre()); } } catch(Exception e) {
	 * System.out.println(e.getMessage()); } finally { sesion.close(); }
	 * 
	 * }
	 */
}