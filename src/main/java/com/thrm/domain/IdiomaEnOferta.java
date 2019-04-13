package com.thrm.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;

/**
 * Idiomasenofertas entity provides the base persistence definition of the
 * Idiomasenofertas entity.
 */
@Entity
public class IdiomaEnOferta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Integer ididiomasenofertas;
	private String escrito;
	private String hablado;
	private String traduccion;
	private String tecnico;

	@ManyToOne
	private Idioma idioma;
	@ManyToOne
	private Oferta oferta;
	// Constructors

	public IdiomaEnOferta() {
	}

	/** minimal constructor */
	public IdiomaEnOferta(Integer ididiomasenofertas, Idioma idioma, Oferta oferta, String hablado) {
		this.ididiomasenofertas = ididiomasenofertas;
		this.idioma = idioma;
		this.oferta = oferta;
		this.hablado = hablado;
	}

	/** full constructor */
	public IdiomaEnOferta(Integer ididiomasenofertas, Idioma idioma, Oferta oferta, String escrito,
			String hablado, String traduccion, String tecnico) {
		this.ididiomasenofertas = ididiomasenofertas;
		this.idioma = idioma;
		this.oferta = oferta;
		this.escrito = escrito;
		this.hablado = hablado;
		this.traduccion = traduccion;
		this.tecnico = tecnico;
	}

	// Property accessors

	public Integer getIdidiomasenofertas() {
		return this.ididiomasenofertas;
	}

	public void setIdidiomasenofertas(Integer ididiomasenofertas) {
		this.ididiomasenofertas = ididiomasenofertas;
	}

	public Idioma getIdiomas() {
		return this.idioma;
	}

	public void setIdiomas(Idioma idioma) {
		this.idioma = idioma;
	}

	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
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

}