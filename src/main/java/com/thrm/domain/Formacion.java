package com.thrm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

/**
 * Formacion entity provides the base persistence definition of the
 * Formacion entity.
 */

@Entity
public class Formacion implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Curso curso;
	private Candidato candidatos;
	private String centro;
	private Integer annoinicio;
	private Integer annofin;
	private String notamedia;
	private Blob expediente;
	private String expedienteContentType;
	private String expedienteFileName;

	// Constructors

	/** default constructor */
	public Formacion() {
	}

	/** minimal constructor */
	public Formacion(Curso curso, Candidato candidatos) {
		this.curso = curso;
		this.candidatos = candidatos;
	}

	/** full constructor */
	public Formacion(Curso curso, Candidato candidatos, String centro, Integer annoinicio,
			Integer annofin, String notamedia, Blob expediente) {
		this.curso = curso;
		this.candidatos = candidatos;
		this.centro = centro;
		this.annoinicio = annoinicio;
		this.annofin = annofin;
		this.notamedia = notamedia;
		this.expediente = expediente;
	}

	// Property accessors

	public Key getKey() {
		return key;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Candidato getCandidatos() {
		return this.candidatos;
	}

	public void setCandidatos(Candidato candidatos) {
		this.candidatos = candidatos;
	}

	public String getCentro() {
		return this.centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public Integer getAnnoinicio() {
		return this.annoinicio;
	}

	public void setAnnoinicio(Integer annoinicio) {
		this.annoinicio = annoinicio;
	}

	public Integer getAnnofin() {
		return this.annofin;
	}

	public void setAnnofin(Integer annofin) {
		this.annofin = annofin;
	}

	public String getNotamedia() {
		return this.notamedia;
	}

	public void setNotamedia(String notamedia) {
		this.notamedia = notamedia;
	}

	public Blob getExpediente() {
		return this.expediente;
	}

	public void setExpediente(Blob expediente) {
		this.expediente = expediente;
	}

	public String getExpedienteContentType() {
		return expedienteContentType;
	}

	public void setExpedienteContentType(String expedienteContentType) {
		this.expedienteContentType = expedienteContentType;
	}

	public String getExpedienteFileName() {
		return expedienteFileName;
	}

	public void setExpedienteFileName(String expedienteFileName) {
		this.expedienteFileName = expedienteFileName;
	}

}