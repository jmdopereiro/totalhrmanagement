package com.thrm.services;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ActionContext;
import com.thrm.dao.*;
import com.thrm.domain.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.multipart.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ServiciosGlobales {

    private static final Log log = LogFactory.getLog(ServiciosGlobales.class);

    private ResponsablesServicios responsablesServicios = null;
    private InscripcionDAO inscripcionDAO;
    private OfertaDAO ofertaDAO;
    private FormacionesServicios fs = null;
    private CursosServicios cursosServicios;
    private ExperienciasServicios es = null;
    private IdiomasServicios is = null;
    private ConocimientosServicios cos = null;
    private IdiomasencandidatosDAO icd = new IdiomasencandidatosDAO();
    ;
    private ConocimientoEnCandidatoDAO conocimientoEnCandidatoDAO = null;
    private IdiomasenofertasDAO iod = null;
    private ConocimientoEnOfertaDAO cod = null;
    private CandidatosDAO cd = new CandidatosDAO();
    private CurriculumsDAO cud = new CurriculumsDAO();


    private List<Idioma> listaIdiomas = null;
    private List<Conocimiento> listaConocimientos = null;
    private List<Curso> listaCursos = null;
    private Map session = null;
    private CandidatosServicios candidatosServicios;
    private ConocimientosServicios conocimientosServicios;

    public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

    public String eliminarInscripcionCandidato(Candidato candidato, Oferta oferta) {
        String resultado = "ERROR";
        boolean existeInscripcion = comprobarExistenciaInscripcion(candidato, oferta);
        if (existeInscripcion) {

            Set<Inscripcion> inscripciones = oferta.getInscripciones();
            for (Inscripcion inscripcion : inscripciones) {
                if (inscripcion.getCandidato().getKey() == candidato.getKey())
                    inscripciones.remove(inscripcion);
            }
            getOfertaDAO().merge(oferta);

        }
        return resultado;
    }

//	public String aceptarCandidatura(Candidato candidato, Oferta oferta) {
//		String resultado = "ERROR";
//		boolean existeInscripcion = this.comprobarExistenciaInscripcion(candidato, oferta);
//		if (existeInscripcion) {
//			Inscripcion inscripcion = new Inscripcion();
//			inscripcion.setCandidatos(candidato);
//			inscripcion.setOfertas(oferta);
//			List<Inscripcion> listaInscripciones = id.findByExample(inscripcion);
//			Iterator<Inscripcion> it = listaInscripciones.iterator();
//			boolean salirBucle = false;
//			while (it.hasNext() && salirBucle == false) {
//				Inscripcion ins = it.next();
//				if (ins.getCandidatos() == candidato && ins.getOfertas() == oferta) {
//					ins.setEstado("Aceptada");
//					id.attachClean(ins);
//					id.merge(ins);
//					resultado = "SUCCESS";
//					salirBucle = true;
//				}
//			}
//		}
//		return resultado;
//	}

//	public String desestimarCandidatura(Candidato candidato, Oferta oferta) {
//		String resultado = "ERROR";
//		boolean existeInscripcion = this.comprobarExistenciaInscripcion(candidato, oferta);
//		if (existeInscripcion) {
//			Inscripcion inscripcion = new Inscripcion();
//			inscripcion.setCandidatos(candidato);
//			inscripcion.setOfertas(oferta);
//			List<Inscripcion> listaInscripciones = id.findByExample(inscripcion);
//			Iterator<Inscripcion> it = listaInscripciones.iterator();
//			boolean salirBucle = false;
//			while (it.hasNext() && salirBucle == false) {
//				Inscripcion ins = it.next();
//				if (ins.getCandidatos() == candidato && ins.getOfertas() == oferta) {
//					ins.setEstado("Desestimada");
//					id.attachClean(ins);
//					id.merge(ins);
//					resultado = "SUCCESS";
//					salirBucle = true;
//				}
//			}
//		}
//		return resultado;
//	}
//

    /**
     * Comprueba si existe la inscripcion para un candidato y una oferta dada
     */
    public boolean comprobarExistenciaInscripcion(Candidato candidato, Oferta oferta) {

        Set inscripciones = oferta.getInscripciones();
        Iterator it = inscripciones.iterator();
        while (it.hasNext()) {
            Inscripcion inscripcion = (Inscripcion) it.next();
            if (inscripcion.getCandidato().getKey() == candidato.getKey())
                return true;
        }

        return false;

//		List<Inscripcion> listaInscripciones = id.findByExample(inscripcion);
//		Iterator<Inscripcion> it = listaInscripciones.iterator();
//		while (it.hasNext() && resultado == false) {
//			Inscripcion ins = it.next();
//			if (ins.getCandidatos() == candidato && ins.getOfertas() == oferta) {
//				resultado = true;
//			}
//		}
//		return resultado;
    }

    /**
     * Muestra las ofertas de la empresa a la que el responsable pertenece
     */
    public Set<Oferta> mostrarOfertasResponsable(Responsable responsable) {
        Empresa empresa = responsable.getEmpresa();
        Set<Oferta> ofertas = empresa.getOfertas();
        return ofertas;
    }

    public String crearFormacionCandidato(Formacion formacion, String contenidoFichero, Candidato candidato, String nombreCurso) {
        String resultado = "ERROR";
//		try {
        if (contenidoFichero != null) {
            Blob ficheroBlob = stringToBlob(contenidoFichero);
            formacion.setExpediente(ficheroBlob);
        }
//			Curso curso = cursosServicios.buscarCursoPorNombre(nombreCurso);
//			if (formacion != null && candidato != null && curso != null) {
        candidato.getFormaciones().add(formacion);
//				formacion.setCursos(curso);
        fs = FormacionesServicios.getInstance();
        resultado = fs.guardarFormacion(formacion);
//			}
        return resultado;
    }

    Blob stringToBlob(String stringFile) {

        InputStream inputStream;
        byte[] bytes = new byte[524288];
        Blob blob = null;

        try {
            inputStream = IOUtils.toInputStream(stringFile, "UTF-8");
            int bytesRead = inputStream.read(bytes);
            log.info("Number of bytes read: " + bytesRead);
            blob = new Blob(bytes);
        } catch (IOException e) {
            log.error("Streaming failed", e);
        }
        return blob;
    }

    public Blob uploadedFileToBlob(UploadedFile file) {

        byte[] bytes = (byte[]) file.getContent();
        Blob blob;

        blob = new Blob(bytes);
        return blob;
    }

//	public String eliminarFormacionCandidato(int identificador) {
//		String resultado = "ERROR";
//		fs = FormacionesServicios.getInstance();
//		Formacion formacion = fs.buscarFormacionPorId(identificador);
//		resultado = fs.eliminarFormacion(formacion);
//		return resultado;
//	}

    public String crearExperienciaCandidato(Experiencia experiencia, Candidato candidato) {
        String resultado = "ERROR";
        if (experiencia != null && candidato != null) {
//			experiencia.setCandidatos(candidato);
            candidato.getExperiencias().add(experiencia);
            resultado = getExperienciasServicios().guardarExperiencia(experiencia);
        }
        return resultado;
    }


    public String eliminarExperienciaCandidato(Candidato candidato, Key key) {

        Experiencia experiencia = ExperienciasServicios.getInstance().buscarExperienciaPorKey(key);
        candidato.getExperiencias().remove(experiencia);
        String resultado = getExperienciasServicios().eliminarExperiencia(experiencia);
        return resultado;
    }

    private ExperienciasServicios getExperienciasServicios() {
        return ExperienciasServicios.getInstance();
    }

    public String crearIdiomaCandidato(String nombreIdioma, IdiomaEnCandidato idiomaEnCandidato, Candidato candidato) {
        is = IdiomasServicios.getInstance();
//		Idioma i = is.buscarIdiomaPorNombre(nombreIdioma);
        Idioma i = new Idioma(nombreIdioma);
        idiomaEnCandidato.setIdioma(i);
        candidato.getIdiomasEnCandidato().add(idiomaEnCandidato);
//		idiomaEnCandidato.setCandidatos(candidato);
        icd.save(idiomaEnCandidato);
        return "SUCCESS";
    }

    public String eliminarIdiomaEnCandidatoByKey(Key key) {
        String resultado = "ERROR";
        icd = new IdiomasencandidatosDAO();
        IdiomaEnCandidato ic = icd.findByKey(key);
        if (ic != null) {
            icd.delete(ic);
            resultado = "SUCCESS";
        }
        return resultado;
    }

    public String crearConocimientoCandidato(String nombreConocimiento,
                                             ConocimientoEnCandidato conocimientoEnCandidato, Candidato candidato) {
//		Conocimiento c = cos.buscarConocimientoPorNombre(nombreConocimiento);
        candidato.getConocimientosEnCandidato().add(conocimientoEnCandidato);
        CandidatosDAO candidatosDAO = new CandidatosDAO();
        candidatosDAO.save(candidato);

        return "SUCCESS";
    }

//	public String crearIdiomaOferta(String nombreIdioma, Idiomasenofertas idiomaenoferta, Oferta oferta) {
//		String resultado = "ERROR";
//		is = IdiomasServicios.getInstance();
//		Idioma i = is.buscarIdiomaPorNombre(nombreIdioma);
//		idiomaenoferta.setIdiomas(i);
//		idiomaenoferta.setOfertas(oferta);
//		iod = new IdiomasenofertasDAO();
//		iod.save(idiomaenoferta);
//		resultado = "SUCCESS";
//		return resultado;
//	}
//
//	public String eliminarIdiomaOferta(int identificador) {
//		String resultado = "ERROR";
//		iod = new IdiomasenofertasDAO();
//		Idiomasenofertas io = iod.findById(identificador);
//		if (io != null) {
//			iod.delete(io);
//			resultado = "SUCCESS";
//		}
//		return resultado;
//	}
//
//	public String crearConocimientoOferta(String nombreConocimiento, ConocimientosEnOfertas conocimientoenoferta,
//			Oferta oferta) {
//		String resultado = "ERROR";
//		cos = ConocimientosServicios.getInstance();
//		Conocimientos c = cos.buscarConocimientoPorNombre(nombreConocimiento);
//		conocimientoenoferta.setConocimientos(c);
//		conocimientoenoferta.setOfertas(oferta);
//		cod = new ConocimientoEnOfertaDAO();
//		cod.save(conocimientoenoferta);
//		resultado = "SUCCESS";
//		return resultado;
//	}
//
//	public String eliminarConocimientoOferta(int identificador) {
//		String resultado = "ERROR";
//		cod = new ConocimientoEnOfertaDAO();
//		ConocimientosEnOfertas co = cod.findById(identificador);
//		if (co != null) {
//			cod.delete(co);
//			resultado = "SUCCESS";
//		}
//		return resultado;
//	}

    public List<Candidato> buscarCandidatosInscritos(Oferta oferta) {

        List<Candidato> candidatos = null;
        if (oferta != null) {
            Set<Inscripcion> inscripciones = oferta.getInscripciones();
            if (inscripciones.size() > 0) {
                candidatos = new ArrayList();
                Iterator<Inscripcion> it = inscripciones.iterator();
                while (it.hasNext()) {
                    Inscripcion inscripcion = (Inscripcion) it.next();
                    if (!(inscripcion.getEstado().equals("Eliminada"))) {

                        Candidato candidato = getCandidatosServicios().buscarCandidatoPorId(inscripcion.getCandidato().getKey().getId());

                        candidatos.add(candidato);
                    }
                }
            }
        }
        return candidatos;
    }

    public List<Curso> cargarCursos() {
        listaCursos = getCursosServicios().mostrarCursos();
        /*
         * Iterator <Curso> i=cursos.iterator(); if(cursos.size()>0) {
         * listaCursos=new ArrayList(); while(i.hasNext()) { Curso c= (Curso)
         * i.next(); listaCursos.add(c.getTipo()); } }
         */
        return listaCursos;
    }

    public List<Idioma> cargarIdiomas() {
        listaIdiomas = getIdiomasServicios().mostrarIdiomas();
        return listaIdiomas;
    }

    private IdiomasServicios getIdiomasServicios() {
        return IdiomasServicios.getInstance();
    }

    public List<Conocimiento> cargarConocimientos() {
        listaConocimientos = getConocimientosServicios().mostrarConocimientos();
        return listaConocimientos;
    }

    private ConocimientosServicios getConocimientosServicios() {
        return conocimientosServicios;
    }

    /**
     * Carga el candidato a partir del dni almacenado en la sesi�n
     */
    public Candidato cargarCandidato() {
        Map session = ActionContext.getContext().getSession();
        Candidato candidato = null;
        if (session != null) {
            String dni = session.get("dniUsuario").toString();
            candidato = getCandidatosServicios().buscarCandidatoPorDni(dni);
        }
        return candidato;
    }

    /**
     * Carga el responsable a partir del dni almacenado en la sesión
     */
    public Responsable cargarResponsable() {
        Map session = ActionContext.getContext().getSession();
        Responsable responsable = null;
        if (session != null) {
            String dni = session.get("dniUsuario").toString();
            responsable = responsablesServicios.buscarResponsablePorDni(dni);
            log.info("responsable cargado: " + responsable.toString());
            log.info("empresa asociada a responsable: " + responsable.getEmpresa());
        }
        return responsable;
    }

    public Curriculum descargarCurriculum(Key key) {
        CurriculumsDAO cud = new CurriculumsDAO();
        Curriculum curriculum = cud.findByKey(key);
        return curriculum;
    }

    public String guardarCurriculum(String fichero, Candidato candidato, String idioma, String fileName, String contentType) {
        String resultado = "ERROR";
        Set<Curriculum> curriculums = candidato.getCurriculums();

        for (Curriculum curriculum : curriculums) {
            if (!curriculum.getIdioma().equals(idioma))
                return resultado;
        }

        Blob ficheroBlob = stringToBlob(fichero);
        Curriculum curriculum = new Curriculum(idioma, Calendar.getInstance().getTime(), ficheroBlob, fileName, contentType, candidato);
        curriculums.add(curriculum);
        cud.save(curriculum);
        resultado = "SUCCESS";
        return resultado;
    }

    public CandidatosServicios getCandidatosServicios() {
        return candidatosServicios;
    }

    public void setCandidatosServicios(CandidatosServicios candidatosServicios) {
        this.candidatosServicios = candidatosServicios;
    }

    public String eliminarCurriculum(Candidato candidato, Key key) {
        String resultado = "ERROR";
//		Set<Curriculum> curriculums = candidato.getCurriculums();

        Curriculum curriculum = cud.findByKey(key);
        cud.delete(curriculum);
        resultado = "SUCCESS";
        return resultado;
    }

    /**
     * security could be enhanced here.
     */
    public boolean comprobarLogin() {
        boolean resultado = false;
        session = ActionContext.getContext().getSession();
        if (session != null) {
            if ((session.get("logueado") != null) && (session.get("logueado").toString().equals("true"))
                    && (session.get("usuario") != null)) {
                resultado = true;
            }
        }
        return resultado;
    }
//
//	public boolean comprobarPermisosResponsable(Oferta oferta) {
//		boolean resultado = false;
//		session = ActionContext.getContext().getSession();
//		if (session != null) {
//			rs = ResponsablesServicios.getInstance();
//			Responsable responsable = rs.buscarResponsablePorNombre(session.get("usuario").toString());
//			if (responsable != null) {
//				if (responsable.getEmpresas() == oferta.getEmpresas()) {
//					resultado = true;
//				}
//			}
//		}
//		return resultado;
//	}

    public boolean comprobarDni(String dni) {
        boolean resultado = false;
        try {
            int longitud = dni.length();
            if (longitud <= 9 && longitud > 1) {
                String dniSinLetra = dni.substring(0, longitud - 1);
                char letra = dni.charAt(longitud - 1);
                Integer numero = Integer.parseInt(dniSinLetra);
                char letraCorrecta = NIF_STRING_ASOCIATION.charAt(numero % 23);
                if (letra == letraCorrecta)
                    resultado = true;
                else
                    log.info("letra correcta: " + letraCorrecta);
            }
        } catch (NumberFormatException excepcion) {
            excepcion.printStackTrace();
        }
        return resultado;
    }

    public InscripcionDAO getInscripcionDAO() {
        return inscripcionDAO;
    }

    public void setInscripcionDAO(InscripcionDAO inscripcionDAO) {
        this.inscripcionDAO = inscripcionDAO;
    }

    public OfertaDAO getOfertaDAO() {
        return ofertaDAO;
    }

    public void setOfertaDAO(OfertaDAO ofertaDAO) {
        this.ofertaDAO = ofertaDAO;
    }

    public void setConocimientosServicios(ConocimientosServicios conocimientosServicios) {
        this.conocimientosServicios = conocimientosServicios;
    }

    public CursosServicios getCursosServicios() {
        return cursosServicios;
    }

    public void setCursosServicios(CursosServicios cursosServicios) {
        this.cursosServicios = cursosServicios;
    }

    public ResponsablesServicios getResponsablesServicios() {
        return responsablesServicios;
    }

    public void setResponsablesServicios(ResponsablesServicios responsablesServicios) {
        this.responsablesServicios = responsablesServicios;
    }

    /*
     * Eliminar inscripcion del sistema public String
     * eliminarInscripcionCandidato(Candidato candidato, Oferta oferta) {
     * String resultado="ERROR"; boolean
     * existeInscripcion=this.comprobarExistenciaInscripcion(candidato, oferta);
     * if(existeInscripcion) { Inscripcion inscripcion=new Inscripcion();
     * inscripcion.setCandidatos(candidato); inscripcion.setOfertas(oferta);
     * List <Inscripcion> listaInscripciones=id.findByExample(inscripcion);
     * Iterator <Inscripcion> it=listaInscripciones.iterator(); boolean
     * salirBucle=false; while(it.hasNext() && salirBucle==false) {
     * Inscripcion ins=it.next(); if(ins.getCandidatos()==candidato &&
     * ins.getOfertas()==oferta) { id.delete(ins); resultado="SUCCESS";
     * salirBucle=true; } } } return resultado; }
     */
}
