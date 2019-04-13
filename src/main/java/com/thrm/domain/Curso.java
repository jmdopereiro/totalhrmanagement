package com.thrm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Curso entity provides the base persistence definition of the Curso entity.
 */

@Entity
public class Curso implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Integer idcurso;
	private String tipo;
	private String nombre;
//	private Set formaciones = new HashSet(0);
	private Set ofertases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Curso() {
	}

	/** minimal constructor */
	public Curso(String tipo, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;
	}

	/** full constructor */
	public Curso(String tipo, String nombre, Set formaciones, Set ofertases) {
		this.tipo = tipo;
		this.nombre = nombre;
//		this.formaciones = formaciones;
		this.ofertases = ofertases;
	}

	// Property accessors

	public Integer getIdcurso() {
		return this.idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public Set getFormaciones() {
//		return this.formaciones;
//	}
//
//	public void setFormaciones(Set formaciones) {
//		this.formaciones = formaciones;
//	}
//
	public Set getOfertases() {
		return this.ofertases;
	}

	public void setOfertases(Set ofertases) {
		this.ofertases = ofertases;
	}

}