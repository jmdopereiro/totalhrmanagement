package com.thrm.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.thrm.domain.Candidato;
import com.thrm.domain.Empresa;
import com.thrm.domain.Oferta;
import com.thrm.domain.Responsable;
import com.thrm.services.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Pattern;

public class ActionResponsable extends ActionSupport {
	
	private static final Log log = LogFactory.getLog(ActionResponsable.class);

	// private List listadoBusqueda;
	private List<Responsable> responsables = null;
	private List<Candidato> candidatos = null;
	private List<Candidato> ultimosCandidatos = null;
	private List<Oferta> ultimasOfertas = null;
	private Responsable responsable = null;
	private String tipoBusqueda = null;
	private String palabraClave = null;
	private ResponsablesServicios responsableServicio = null;
	private EmpresaServicios empresaServicios;
	private CandidatosServicios candidatosServicios;
	private String codigo = null;
	private String cif = null;
	private String email = null;
	private String pass = null;
	private boolean perfilError = false;
	private Set<Oferta> ofertas = null;
	private ServiciosGlobales sg = null;
	private String passwordAntigua = null;
	private String passwordNueva = null;
	private String password = null;
	private String mensaje = null;
	private boolean modificarPerfilError = false;
	private boolean modificarPasswordError = false;
	private Integer idCurriculum = null;
	private Integer idCandidato = null;
	private HttpServletResponse response = null;
	private OfertaServicios os = null;
	private Date hoy = null;

	private OfertaServicios ofertaServicios;

	private ResponsablesServicios responsablesServicios;

	private ServiciosGlobales serviciosGlobales;
	
	private static final Pattern cifPattern = Pattern.compile("[[A-H][J-N][P-S]UVW][0-9]{7}[0-9A-J]");
	private static final String CONTROL_SOLO_NUMEROS = "ABEH"; // S�lo admiten
	// n�meros como
	// caracter de
	// control
	private static final String CONTROL_SOLO_LETRAS = "KPQS"; // S�lo admiten
	// letras como
	// caracter de
	// control
	private static final String CONTROL_NUMERO_A_LETRA = "JABCDEFGHI"; // Conversi�n
	// de
	// d�gito
	// a
	// letra
	// de
	// control.
	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

	public String principalResponsable() {
		String resultado = "ERROR";
		responsable = getServiciosGlobales().cargarResponsable();
		List<Oferta> listaOfertas = getOfertaServicios().misUltimasOfertas(responsable);
		ofertas = new HashSet<Oferta>();
		ofertas.addAll(listaOfertas);
//			ultimosCandidatos = candidatosServicios.ultimosCandidatos();
		hoy = Calendar.getInstance().getTime();
		resultado = "SUCCESS";
		return resultado;
	}

	public String perfilResponsable() {
		String resultado = "ERROR";
		responsable = getServiciosGlobales().cargarResponsable();
		resultado = "SUCCESS";
		return resultado;
	}

//	public String mostrarCandidatos() {
//		String resultado = "ERROR";
//		sg = serviciosGlobales;
//		if (sg.comprobarLogin()) {
//			candidatosServicios = CandidatosServicios.getInstance();
//			candidatos = candidatosServicios.mostrarCandidatos();
//			resultado = this.ultimosCandidatos();
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public String ultimosCandidatos() {
//		String resultado = "ERROR";
//		ultimosCandidatos = candidatosServicios.ultimosCandidatos();
//		resultado = "SUCCESS";
//		return resultado;
//	}
//
	public String mostrarOfertasResponsable() {
		String resultado = "ERROR";
		responsable = getServiciosGlobales().cargarResponsable();
		ofertas = getServiciosGlobales().mostrarOfertasResponsable(responsable);
		ultimasOfertas = ofertaServicios.misUltimasOfertas(responsable);
		resultado = "SUCCESS";
		return resultado;
	}

//	public String recargarPagina() {
//		String resultado = "ERROR";
//		resultado = this.ultimosCandidatos();
//		return resultado;
//	}
//
	public String registrarResponsable() {
		String resultado = "ERROR";
//		if (validateCif(cif)) {
			if (!getEmpresaServicios().verificarExistenciaCif(cif)) {
				addActionError("El cif introducido no existe en nuestra BD.");
				addFieldError("cif", "");
			} else {
				if (!getEmpresaServicios().verificarCodigo(cif, codigo)) {
					addActionError("La clave introducida no corresponde con el cif de la empresa.");
					addFieldError("codigo", "");
				} else {
					Empresa empresa = getEmpresaServicios().buscarEmpresaPorCif(cif);

					resultado = getResponsablesServicios().registrar(empresa, responsable);
					if (resultado.equals("ERROR")){
						addActionError("El dni introducido ya existe en nuestra base de datos.");
						addFieldError("dni", "");
					}
//					resultado = responsableServicio.registrar(responsable);
					
				}
			}
//		} else {
//			addActionError("El cif introducido no es v�lido.");
//			addFieldError("cif", "");
//		}
		return resultado;
	}
//
//	public String eliminarResponsable() {
//		String resultado = "ERROR";
//		sg = serviciosGlobales;
//		if (sg.comprobarLogin()) {
//			perfilError = true;
//			String palabraAIntroducir = "ELIMINAR";
//			if (palabraClave.equals(palabraAIntroducir)) {
//				Map session = ActionContext.getContext().getSession();
//				String dni = session.get("dniUsuario").toString();
//				rs = responsablesServicios;
//				resultado = rs.eliminarResponsable(dni);
//				perfilError = false;
//			} else {
//				addFieldError("palabraClave", "Debes introducir la palabra: " + palabraAIntroducir);
//			}
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public String modificarPerfilResponsable() {
//		String resultado = "ERROR";
//		sg = serviciosGlobales;
//		if (sg.comprobarLogin()) {
//			modificarPerfilError = true;
//			rs = responsablesServicios;
//			resultado = rs.modificarPerfil(responsable);
//			modificarPerfilError = false;
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public String cambiarPasswordResponsable() {
//		String resultado = "ERROR";
//		sg = serviciosGlobales;
//		if (sg.comprobarLogin()) {
//			mensaje = "cambioPasswordError";
//			modificarPasswordError = true;
//			responsable = sg.cargarResponsable();
//			if (responsable.getPassword().equals(passwordAntigua)) {
//
//				if (password.equals(passwordNueva)) {
//					rs = responsablesServicios;
//					resultado = rs.cambiarPassword(responsable, password);
//					mensaje = "cambioPasswordExito";
//					modificarPasswordError = false;
//				}
//				/*
//				 * Ha introducido mal la segunda contrase�a, deberiamos de hacer
//				 * esta comprobaci�n por AJAX
//				 */
//				else {
//					addActionError("Las nuevas contrase�as introducidas no coinciden.");
//					addFieldError("passwordNueva", "");
//					addFieldError("password", "");
//				}
//
//			}
//			/* La contrase�a que ha introducido es err�nea */
//			else {
//				addActionError("La contrase�a introducida es err�nea.");
//				addFieldError("passwordAntigua", "");
//			}
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public String descargarCurriculumResponsable() {
//		String resultado = "ERROR";
//		sg = serviciosGlobales;
//		if (sg.comprobarLogin()) {
//			try {
//				Curriculum curriculum = sg.descargarCurriculum(idCurriculum);
//				InputStream is = curriculum.getFichero().getBinaryStream();
//				response = ServletActionContext.getResponse();
//				OutputStream os = response.getOutputStream();
//				response.setContentType("application/pdf");
//				candidatosServicios = CandidatosServicios.getInstance();
//				Candidato candidato = candidatosServicios.buscarCandidatoPorId(idCandidato);
//				response.setHeader("Content-disposition", "attachment; filename=" + "Curriculum_"
//						+ candidato.getNombre() + "" + candidato.getApellidos());
//				int i;
//				while ((i = is.read()) != -1) {
//					os.write(i);
//				}
//				is.close();
//				os.close();
//				resultado = "SUCCESS";
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			resultado = "LOGIN";
//		}
//		return resultado;
//	}
//
//	public static boolean comprobarDni(String dni) {
//		boolean resultado = false;
//		try {
//			int longitud = dni.length();
//			if (longitud <= 9 && longitud > 1) {
//				String dniSinLetra = dni.substring(0, longitud - 1);
//				char letra = dni.charAt(longitud - 1);
//				Integer numero = Integer.parseInt(dniSinLetra);
//				char letraCorrecta = NIF_STRING_ASOCIATION.charAt(numero % 23);
//				if (letra == letraCorrecta) {
//					resultado = true;
//				}
//			}
//		} catch (NumberFormatException excepcion) {
//			excepcion.printStackTrace();
//		}
//		return resultado;
//	}
//
	public static boolean validateCif(String cif) {
		try {
			if (!cifPattern.matcher(cif).matches()) {
				// No cumple el patr�n
				return false;
			}

			int parA = 0;
			for (int i = 2; i < 8; i += 2) {
				final int digito = Character.digit(cif.charAt(i), 10);
				if (digito < 0) {
					return false;
				}
				parA += digito;
			}

			int nonB = 0;
			for (int i = 1; i < 9; i += 2) {
				final int digito = Character.digit(cif.charAt(i), 10);
				if (digito < 0) {
					return false;
				}
				int nn = 2 * digito;
				if (nn > 9) {
					nn = 1 + (nn - 10);
				}
				nonB += nn;
			}

			final int parcialC = parA + nonB;
			final int digitoE = parcialC % 10;
			final int digitoD = (digitoE > 0) ? (10 - digitoE) : 0;
			final char letraIni = cif.charAt(0);
			final char caracterFin = cif.charAt(8);

			final boolean esControlValido =
			// �el caracter de control es v�lido como letra?
			(CONTROL_SOLO_NUMEROS.indexOf(letraIni) < 0 && CONTROL_NUMERO_A_LETRA.charAt(digitoD) == caracterFin) ||
			// �el caracter de control es v�lido como d�gito?
					(CONTROL_SOLO_LETRAS.indexOf(letraIni) < 0 && digitoD == Character.digit(caracterFin, 10));
			return esControlValido;

		} catch (Exception e) {
			return false;
		}
	}
//
	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
//
//	public List<Candidato> getCandidatos() {
//		return candidatos;
//	}
//
//	public List<Candidato> getUltimosCandidatos() {
//		return ultimosCandidatos;
//	}
//
//	public List<Oferta> getUltimasOfertas() {
//		return ultimasOfertas;
//	}
//
//	public void setPalabraClave(String palabraClave) {
//		this.palabraClave = palabraClave;
//	}
//
//	public void setTipoBusqueda(String tipoBusqueda) {
//		this.tipoBusqueda = tipoBusqueda;
//	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPass() {
//		return pass;
//	}
//
//	public void setPass(String pass) {
//		this.pass = pass;
//	}

	public Set<Oferta> getOfertas() {
		return ofertas;
	}

	public CandidatosServicios getCandidatosServicios() {
		return candidatosServicios;
	}

	public void setCandidatosServicios(CandidatosServicios candidatosServicios) {
		this.candidatosServicios = candidatosServicios;
	}

	public OfertaServicios getOfertaServicios() {
		return ofertaServicios;
	}

	public void setOfertaServicios(OfertaServicios ofertaServicios) {
		this.ofertaServicios = ofertaServicios;
	}

	public ResponsablesServicios getResponsablesServicios() {
		return responsablesServicios;
	}

	public void setResponsablesServicios(ResponsablesServicios responsablesServicios) {
		this.responsablesServicios = responsablesServicios;
	}

	public EmpresaServicios getEmpresaServicios() {
		return empresaServicios;
	}

	public void setEmpresaServicios(EmpresaServicios empresaServicios) {
		this.empresaServicios = empresaServicios;
	}

	public ServiciosGlobales getServiciosGlobales() {
		return serviciosGlobales;
	}

	public void setServiciosGlobales(ServiciosGlobales serviciosGlobales) {
		this.serviciosGlobales = serviciosGlobales;
	}

//	public void setPasswordAntigua(String passwordAntigua) {
//		this.passwordAntigua = passwordAntigua;
//	}
//
//	public void setPasswordNueva(String passwordNueva) {
//		this.passwordNueva = passwordNueva;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getMensaje() {
//		return mensaje;
//	}
//
//	public void setMensaje(String mensaje) {
//		this.mensaje = mensaje;
//	}
//
//	public boolean getModificarPerfilError() {
//		return modificarPerfilError;
//	}
//
//	public boolean getModificarPasswordError() {
//		return modificarPasswordError;
//	}
//
//	public void setServletResponse(HttpServletResponse response) {
//		this.response = response;
//	}
//
//	public HttpServletResponse getServletResponse() {
//		return response;
//	}
//
//	public void setIdCurriculum(Integer idCurriculum) {
//		this.idCurriculum = idCurriculum;
//	}
//
//	public void setIdCandidato(Integer idCandidato) {
//		this.idCandidato = idCandidato;
//	}
//
//	public Date getHoy() {
//		return hoy;
//	}
}
