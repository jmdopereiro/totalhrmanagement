package com.thrm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

/**
 * IdiomaEnCandidato entity provides the base persistence definition of the
 * IdiomaEnCandidato entity. @author MyEclipse Persistence Tools
 */

@Entity
public class IdiomaEnCandidato implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	@ManyToOne(targetEntity=Idioma.class, cascade=CascadeType.PERSIST)
	private Idioma idioma;

	@ManyToOne
	private Candidato candidato;

	private String escrito;
	private String hablado;
	private String traduccion;
	private String tecnico;

	// Constructors

	/** default constructor */
	public IdiomaEnCandidato() {
	}

	/** minimal constructor */
	public IdiomaEnCandidato(Idioma idioma, Candidato candidatos, String hablado) {
		this.idioma = idioma;
		this.candidato = candidatos;
		this.hablado = hablado;
	}

	/** full constructor */
	public IdiomaEnCandidato(Integer ididiomasencandidatos, Idioma idioma, Candidato candidato, String escrito,
			String hablado, String traduccion, String tecnico) {
		this.idioma = idioma;
		this.candidato = candidato;
		this.escrito = escrito;
		this.hablado = hablado;
		this.traduccion = traduccion;
		this.tecnico = tecnico;
	}

	// Property accessors

	public Idioma getIdioma() {
		return this.idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public String getEscrito() {
		return this.escrito;
	}

	public void setEscrito(String escrito) {
		this.escrito = escrito;
	}

	public String getHablado() {
		return this.hablado;
	}

	public void setHablado(String hablado) {
		this.hablado = hablado;
	}

	public String getTraduccion() {
		return this.traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public String getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public Key getKey() {
		return key;
	}

}