package com.thrm.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thrm.domain.Candidato;
import com.thrm.domain.Responsable;
import com.thrm.services.CandidatosServicios;
import com.thrm.services.ResponsablesServicios;

import java.util.Map;


public class ActionLogin extends ActionSupport {

	private String dni = null;
	private String email = null;
	private String password = null;
	private Candidato candidato = null;
	private Responsable responsable = null;
	
	private ResponsablesServicios rs = null;
	private String registroEmpresaError = null;
	private Map session = null;
	private boolean validacion1 = false;
	private boolean validacion2 = false;
//	private Batch procesoBatch = null;
	private CandidatosServicios candidatosServicios;
	private ResponsablesServicios responsablesServicios;

	public String login() {
		String resultado = "ERROR";
		Object objetoAplicacion = ActionContext.getContext().get("actualizarEstados");
//		if (objetoAplicacion == null) {
//			procesoBatch = Batch.getInstance();
//			boolean actualizado = procesoBatch.actualizarEstados();
//			if (actualizado == true) {
//				ActionContext.getContext().put("actualizarEstados", true);
//			} else {
//				ActionContext.getContext().put("actualizarEstados", false);
//			}
//		}

		candidato = getCandidatosServicios().buscarCandidatoPorDni(dni);
		if (candidato != null) {
			validacion1 = email.equals(candidato.getEmail());
			validacion2 = password.equals(candidato.getPassword());
			if (validacion1 == true && validacion2 == true) {
				this.comenzarSesionCandidato();
				resultado = "candidatoLogueado";
			}
		}
//		/* Si no existe el dni por candidato */
		else {
			responsable = getResponsablesServicios().buscarResponsablePorDni(dni);
			/* Si existe el dni por responsable */
			if (responsable != null) {
				if (email.equals(responsable.getEmail()) && password.equals(responsable.getPassword())) {
					this.comenzarSesionResponsable();
					resultado = "responsableLogueado";
				}
			}
		}
		if (resultado.equals("ERROR")) {
			addActionError("Los datos introducidos son incorrectos");
		}
		if (dni.equals("")) {
			addFieldError("dni", "Debe introducir su dni");
		} else if (candidato == null && responsable == null) {
			// addFieldError("dni","Debe introducir su dni correctamente.");
		}
		if (email.equals("")) {
			addFieldError("email", "Debe introducir su email");
		} else if ((candidato != null || responsable != null) && validacion1 == false) {
			// addFieldError("email","Debe introducir su email correctamente.");
		}
		if (password.equals("")) {
			addFieldError("password", "Debe introducir su contraseña");
		} else if ((candidato != null || responsable != null) && validacion2 == false) {
			// addFieldError("password","Debe introducir su contrase�a correctamente.");
		}
		return resultado;

	}

	private CandidatosServicios getCandidatosServicios() {
		return candidatosServicios;
	}

	public String logout() {
		String resultado = "ERROR";
		session = ActionContext.getContext().getSession();
		session.clear();
		resultado = "SUCCESS";
		return resultado;
	}

	public void comenzarSesionCandidato() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("logueado", "true");
		session.put("usuario", candidato.getNombre());
		session.put("dniUsuario", candidato.getDni());
		session.put("rol", "candidato");
	}

	public void comenzarSesionResponsable() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("logueado", "true");
		session.put("usuario", responsable.getNombre());
		session.put("dniUsuario", responsable.getDni());
		session.put("rol", "responsable");
		session.put("empresa", responsable.getEmpresa());
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCandidatosServicios(CandidatosServicios candidatosServicios) {
		this.candidatosServicios = candidatosServicios;
	}

	public ResponsablesServicios getResponsablesServicios() {
		return responsablesServicios;
	}

	public void setResponsablesServicios(ResponsablesServicios responsablesServicios) {
		this.responsablesServicios = responsablesServicios;
	}

//	public String getRegistroEmpresaError() {
//		return registroEmpresaError;
//	}
//
//	public void setRegistroEmpresaError(String registroEmpresaError) {
//		this.registroEmpresaError = registroEmpresaError;
//	}

}
