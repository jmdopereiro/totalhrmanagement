package com.thrm.domain;

import java.util.Date;

import javax.persistence.*;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

/**
 * Curriculum entity provides the base persistence definition of the
 * Curriculum entity
 */

@Entity
public class Curriculum implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	

	private String idioma;
	private Date fechainsercion;
	private Blob fichero;
	private String fileName;
	private String contentType;

	@ManyToOne
	private Candidato candidato;

	// Constructors

	/** default constructor */
	public Curriculum() {
	}

	/** full constructor */
	public Curriculum(String idioma, Date fechainsercion, Blob fichero, String fileName, String contentType, Candidato candidato) {
		this.idioma = idioma;
		this.fechainsercion = fechainsercion;
		this.fichero = fichero;
		this.fileName = fileName;
		this.contentType = contentType;
		this.candidato = candidato;
	}

	// Property accessors
	public Key getKey() {
		return key;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Date getFechainsercion() {
		return this.fechainsercion;
	}

	public void setFechainsercion(Date fechainsercion) {
		this.fechainsercion = fechainsercion;
	}

	public Blob getFichero() {
		return this.fichero;
	}

	public void setFichero(Blob fichero) {
		this.fichero = fichero;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}