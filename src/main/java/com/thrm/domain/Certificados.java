package com.thrm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Certificados entity provides the base persistence definition of the
 * Certificados entity.
 */

@Entity
public abstract class Certificados implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Integer idcertificado;
	private String nombre;
	private String centro;
	private String nota;
	private Date caducidad;

	// Constructors

	/** default constructor */
	public Certificados() {
	}

	/** minimal constructor */
	public Certificados(String nombre) {
		this.nombre = nombre;
	}

	/** full constructor */
	public Certificados(String nombre, String centro, String nota, Date caducidad) {
		this.nombre = nombre;
		this.centro = centro;
		this.nota = nota;
		this.caducidad = caducidad;
	}

	// Property accessors

	public Integer getIdcertificado() {
		return this.idcertificado;
	}

	public void setIdcertificado(Integer idcertificado) {
		this.idcertificado = idcertificado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCentro() {
		return this.centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getCaducidad() {
		return this.caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

}