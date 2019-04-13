package com.thrm.domain;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

/**
 * Inscripcion entity provides the base persistence definition of the
 * Inscripcion entity.
 */
@Entity
public class Inscripcion implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String estado = "Abierta";

	@ManyToOne//(targetEntity=Oferta.class, cascade=CascadeType.PERSIST)
	@Unowned
	private Oferta oferta;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Unowned
	private Candidato candidato;

	public Inscripcion() {
	}

	/** full constructor */
	public Inscripcion(Oferta oferta, int candidatoId, Candidato candidato, String estado) {
//		this.oferta = oferta;
		this.candidato = candidato;
		this.estado = estado;
	}

	// Property accessors
	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}