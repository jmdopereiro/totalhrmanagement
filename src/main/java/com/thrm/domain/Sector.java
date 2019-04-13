package com.thrm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Sector entity provides the base persistence definition of the Sector
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class Sector implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Integer idsector;
	private String nombre;
	private Set empresases = new HashSet(0);
	private Set experienciases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sector() {
	}

	/** minimal constructor */
	public Sector(String nombre) {
		this.nombre = nombre;
	}

	/** full constructor */
	public Sector(String nombre, Set empresases, Set experienciases) {
		this.nombre = nombre;
		this.empresases = empresases;
		this.experienciases = experienciases;
	}

	// Property accessors

	public Integer getIdsector() {
		return this.idsector;
	}

	public void setIdsector(Integer idsector) {
		this.idsector = idsector;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getEmpresases() {
		return this.empresases;
	}

	public void setEmpresases(Set empresases) {
		this.empresases = empresases;
	}

	public Set getExperienciases() {
		return this.experienciases;
	}

	public void setExperienciases(Set experienciases) {
		this.experienciases = experienciases;
	}

}