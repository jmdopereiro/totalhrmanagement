package com.thrm.domain;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;

/**
 * ConocimientoEnOferta entity provides the base persistence definition of the
 * ConocimientoEnOferta entity.
 * 
 */
@Entity
public class ConocimientoEnOferta implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private Integer idConocimientosEnOfertas;

	@ManyToOne
	private Oferta oferta;
	@ManyToOne
	private Conocimiento conocimiento;

	private String nivel;

	// Constructors

	/** default constructor */
	public ConocimientoEnOferta() {
	}

	/** full constructor */
	public ConocimientoEnOferta(Integer idConocimientosEnOfertas, Oferta oferta, Conocimiento conocimientos,
			String nivel) {
		this.idConocimientosEnOfertas = idConocimientosEnOfertas;
		this.oferta = oferta;
		this.conocimiento = conocimientos;
		this.nivel = nivel;
	}

	// Property accessors

	public Integer getIdConocimientosEnOfertas() {
		return this.idConocimientosEnOfertas;
	}

	public void setIdConocimientosEnOfertas(Integer idConocimientosEnOfertas) {
		this.idConocimientosEnOfertas = idConocimientosEnOfertas;
	}

	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Conocimiento getConocimiento() {
		return this.conocimiento;
	}

	public void setConocimientos(Conocimiento conocimiento) {
		this.conocimiento = conocimiento;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}