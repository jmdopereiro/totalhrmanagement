package com.thrm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Conocimiento entity provides the base persistence definition of the
 * Conocimiento entity.
 */

@Entity
public class Conocimiento implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String nombre;

	// Constructors

	/** default constructor */
	public Conocimiento() {
	}

	/** minimal constructor */
	public Conocimiento(String nombre) {
		this.nombre = nombre;
	}

	// Property accessors

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}