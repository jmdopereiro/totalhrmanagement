package com.thrm.services;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thrm.dao.CandidatosDAO;
import com.thrm.dao.ConocimientoEnCandidatoDAO;
import com.thrm.dao.InscripcionDAO;
import com.thrm.domain.Candidato;
import com.thrm.domain.ConocimientoEnCandidato;
import com.thrm.domain.Inscripcion;
import org.apache.struts2.dispatcher.multipart.UploadedFile;

public class CandidatosServicios {

    private Candidato candidato = null;
    private List<Candidato> candidatos = null;
    private CandidatosDAO candidatoDAO;//    private DSCandidateDAO candidateDAO;
    private InscripcionDAO inscripcionDAO = null;
    private ServiciosGlobales serviciosGlobales;
    private ConocimientoEnCandidatoDAO conocimientoEnCandidatoDAO = null;

    private CandidatosServicios() {
        candidatoDAO = new CandidatosDAO();//        candidateDAO = new DSCandidateDAO();
        inscripcionDAO = new InscripcionDAO();
        conocimientoEnCandidatoDAO = new ConocimientoEnCandidatoDAO();
    }

    public String registrar(Candidato candidato) {
        String resultado = "ERROR";
        candidatoDAO.save(candidato);//        candidateDAO.createCandidate(candidato);
        resultado = "SUCCESS";
        return resultado;
    }

    public Candidato buscarCandidatoPorId(long id) {
        Key key = KeyFactory.createKey("Candidato", id);
        Candidato candidato = candidatoDAO.findByKey(key);
        return candidato;
    }

    public Candidato buscarCandidatoPorDni(String dni) {
        Candidato candidato = null;
        candidatos = candidatoDAO.findByDni(dni);
        if (candidatos.size() >= 1) {
            candidato = candidatos.get(0);
        }
        return candidato;
    }
//
//	public Candidato buscarCandidatoPorEmail(String email) {
//		Candidato candidato = null;
//		candidatos = candidatoDAO.findByEmail(email);
//		if (candidatos.size() >= 1) {
//			candidato = candidatos.get(0);
//		}
//		return candidato;
//	}

//

    /**
     * Comprueba la existencia del email y dni en la tabla candidatos
     * Devolviendo true en caso de que exista
     */
    public boolean verificarExistenciaDniEmail(String dni, String email) {
        boolean resultado = true;
        candidatos = candidatoDAO.findByDni(dni);
        if (candidatos.size() == 0) {
            candidatos = candidatoDAO.findByEmail(email);
        }
        if (candidatos.size() == 0) {
            resultado = false;
        }
        return resultado;
    }

    public List<Candidato> mostrarCandidatos() {
        candidatos = candidatoDAO.findAll();
        return candidatos;
    }
//	public List<Candidato> ultimosCandidatos() {
//		candidatos = candidatoDAO.findLastFive();
//		return candidatos;

//	}

    public String eliminarCandidato(String dni) {
        String resultado = "ERROR";
        candidatos = candidatoDAO.findByDni(dni);
        if (candidatos.size() == 1) {
            Candidato candidato = candidatos.get(0);
            candidatoDAO.delete(candidato);
            resultado = "SUCCESS";
        }
        return resultado;
    }

    public List<Inscripcion> getInscripciones(Candidato candidato) {
//		Set<Inscripcion> inscripciones = candidato.getInscripciones();

        List<Inscripcion> inscripciones = inscripcionDAO.findByProperty("candidato", candidato);

        return inscripciones;
    }
//	public Set<Formacion> getFormacion(Candidato candidato) {
//		Set<Formacion> formaciones = candidato.getformaciones();
//		return formaciones;

//	}

    public String modificarDatosPersonales(Candidato candidato) {
        String resultado = "ERROR";
        Candidato candidatoAlmacenado = getServiciosGlobales().cargarCandidato();
        // Candidato
        // candidatoAlmacenado=this.buscarCandidatoPorDni(candidato.getDni());

        String password = candidatoAlmacenado.getPassword();
        candidato.setKey(candidatoAlmacenado.getKey());

        candidato.setPassword(password);
        candidato.setFoto(candidatoAlmacenado.getFoto());

        candidatoDAO.merge(candidato);
        resultado = "SUCCESS";
        return resultado;
    }

    public String eliminarConocimientoEnCandidatoByKey(Candidato candidato, Key key) {
        String result = "ERROR";

        conocimientoEnCandidatoDAO = new ConocimientoEnCandidatoDAO();
        ConocimientoEnCandidato conocimientoEnCandidato = conocimientoEnCandidatoDAO.findByKey(key);
        candidato.getConocimientosEnCandidato().remove(conocimientoEnCandidato);

        if (conocimientoEnCandidato != null) {
            candidatoDAO.merge(candidato);
            result = "SUCCESS";
        }
        return result;
    }

    private ServiciosGlobales getServiciosGlobales() {
        return serviciosGlobales;
    }

    public String cambiarPassword(Candidato candidato, String nuevaPassword) {
        String resultado = "ERROR";
        candidato.setPassword(nuevaPassword);
//		candidatoDAO.attachDirty(candidato);
        candidatoDAO.merge(candidato);
        resultado = "SUCCESS";
        return resultado;
    }

    public String guardarFoto(Candidato candidato, UploadedFile file) {
        String resultado = "ERROR";
        candidato.setFoto(getServiciosGlobales().uploadedFileToBlob(file));

        candidatoDAO.merge(candidato);
        resultado = "SUCCESS";
        return resultado;
    }

    public String eliminarFoto(Candidato candidato) {
        String resultado = "ERROR";
        candidato.setFoto(null);
        candidatoDAO.merge(candidato);
        resultado = "SUCCESS";
        return resultado;
    }

    public void setServiciosGlobales(ServiciosGlobales serviciosGlobales) {
        this.serviciosGlobales = serviciosGlobales;
    }

//	public String subirFoto() {
//		String resultado = "ERROR";
//		/*
//		 * final Logger logger = Logger.getLogger(ActionCandidato.class);
//		 * FileUpload fu=new FileUpload() { public String execute() {
//		 * System.out.println("Se va a ejecutar esto"); File uploadedFile =
//		 * this.getUpload(); String contentType = this.getUploadContentType();
//		 * String fileName = this.getUploadFileName();
//		 * System.out.println(fileName + contentType + uploadedFile.toString());
//		 * candidato.setFoto(fileName); candidatoDAO.save(candidato); return SUCCESS; } };
//		 * resultado=fu.execute();
//		 */
//		return resultado;
//
//	}
}