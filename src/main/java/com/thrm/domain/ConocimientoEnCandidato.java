package com.thrm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

/**
 * ConocimientoEnCandidato entity provides the base persistence definition of
 * the ConocimientoEnCandidato entity.
 * 
 */
@Entity
public class ConocimientoEnCandidato implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String nivel;

	@ManyToOne
	private Candidato candidato;

	@ManyToOne(targetEntity=Conocimiento.class, cascade=CascadeType.PERSIST)
	private Conocimiento conocimiento;

	// Constructors
	/** default constructor */
	public ConocimientoEnCandidato() {
	}

	/** full constructor */
	public ConocimientoEnCandidato(Conocimiento conocimiento, String nivel) {
		this.conocimiento = conocimiento;
		this.nivel = nivel;
	}

	// Property accessors
	public Key getKey() {
		return key;
	}

	public Conocimiento getConocimiento() {
		return this.conocimiento;
	}

	public void setConocimiento(Conocimiento conocimiento) {
		this.conocimiento = conocimiento;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}