package com.thrm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Experiencia entity provides the base persistence definition of the
 * Experiencia entity.
 */

@Entity
public class Experiencia implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Candidato candidato;
	private String tipo;
	private String puestotrabajo;
	private String empresa;
	private String departamento;
	private Integer annoinicio;
	private Integer annofin;
	private String duracion;
	private Set<Sector> sectores = new HashSet<Sector>(0);

	// Constructors

	/** default constructor */
	public Experiencia() {
	}

	/** minimal constructor */
	public Experiencia(Candidato candidatos, String tipo, String puestotrabajo, Integer annoinicio, Integer annofin,
			String duracion) {
		this.candidato = candidatos;
		this.tipo = tipo;
		this.puestotrabajo = puestotrabajo;
		this.annoinicio = annoinicio;
		this.annofin = annofin;
		this.duracion = duracion;
	}

	/** full constructor */
	public Experiencia(Candidato candidatos, String tipo, String puestotrabajo, String empresa, String departamento,
			Integer annoinicio, Integer annofin, String duracion, Set<Sector> sectores) {
		this.candidato = candidatos;
		this.tipo = tipo;
		this.puestotrabajo = puestotrabajo;
		this.empresa = empresa;
		this.departamento = departamento;
		this.annoinicio = annoinicio;
		this.annofin = annofin;
		this.duracion = duracion;
		this.sectores = sectores;
	}

	// Property accessors

	public Candidato getCandidatos() {
		return this.candidato;
	}

	public void setCandidatos(Candidato candidatos) {
		this.candidato = candidatos;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPuestotrabajo() {
		return this.puestotrabajo;
	}

	public void setPuestotrabajo(String puestotrabajo) {
		this.puestotrabajo = puestotrabajo;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Set<Sector> getSectores() {
		return this.sectores;
	}

	public void setSectores(Set sectores) {
		this.sectores = sectores;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}