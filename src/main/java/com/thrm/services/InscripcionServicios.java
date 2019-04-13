package com.thrm.services;

import com.thrm.dao.CandidatosDAO;
import com.thrm.dao.InscripcionDAO;
import com.thrm.dao.OfertaDAO;
import com.thrm.domain.Candidato;
import com.thrm.domain.Inscripcion;
import com.thrm.domain.Oferta;

public class InscripcionServicios extends AbstractServicios {

    private static InscripcionServicios inscripcionServicios = null;
    private OfertaDAO ofertaDAO;
    private CandidatosDAO candidatosDAO;
    private InscripcionDAO inscripcionDAO;

    private InscripcionServicios() {
        ofertaDAO = new OfertaDAO();
        candidatosDAO = new CandidatosDAO();
        inscripcionDAO = new InscripcionDAO();
    }

    public static InscripcionServicios getInstance() {
        if (inscripcionServicios == null) {
            inscripcionServicios = new InscripcionServicios();
        }
        return inscripcionServicios;
    }

    public String inscribirCandidato(Candidato candidato, Oferta oferta) {

        String resultado = "ERROR";
        boolean existeInscripcion = getServiciosGlobales().comprobarExistenciaInscripcion(candidato, oferta);
        if (!existeInscripcion) {

            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setCandidato(candidato);
			inscripcion.setOferta(oferta); //Illegal attempt to change oferta's parent from empresa to inscripcion

            oferta.addInscripcion(inscripcion);
            candidato.addInscripcion(inscripcion);
            ofertaDAO.save(oferta);


//            inscripcionDAO.merge(inscripcion);
//            candidatosDAO.merge(candidato);
            resultado = "SUCCESS";
        }
        return resultado;
    }


}
