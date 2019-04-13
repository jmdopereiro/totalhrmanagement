package com.thrm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;

/**
 * Idioma entity provides the base persistence definition of the Idioma
 * entity.
 */

@Entity
public class Idioma implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String nombre;

	@OneToMany
	private Set<IdiomaEnOferta> idiomasenofertases = new HashSet(0);
	@OneToMany
	private Set<IdiomaEnCandidato> idiomasencandidatoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Idioma() {
	}

	/** minimal constructor */
	public Idioma(String nombre) {
		this.nombre = nombre;
	}

	/** full constructor */
	public Idioma(String nombre, Set idiomasenofertases, Set idiomasencandidatoses) {
		this.nombre = nombre;
//		this.idiomasenofertases = idiomasenofertases;
//		this.idiomasencandidatoses = idiomasencandidatoses;
	}

	// Property accessors

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public Set getIdiomasenofertases() {
//		return this.idiomasenofertases;
//	}
//
//	public void setIdiomasenofertases(Set idiomasenofertases) {
//		this.idiomasenofertases = idiomasenofertases;
//	}
//
//	public Set getIdiomasencandidatoses() {
//		return this.idiomasencandidatoses;
//	}
//
//	public void setIdiomasencandidatoses(Set idiomasencandidatoses) {
//		this.idiomasencandidatoses = idiomasencandidatoses;
//	}

}