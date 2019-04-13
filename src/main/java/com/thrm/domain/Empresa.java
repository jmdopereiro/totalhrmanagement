package com.thrm.domain;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

/**
 * Empresa entity provides the base persistence definition of the Empresa
 * entity.
 */

@Entity
public class Empresa implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String cif;
	private String nombre;
	private String tipoSociedad;
	private String domicilio;
//	private Blob logo;
	private Integer numTrabajadores;
	private String web;
	private String codigo;
//	private Set sectoreses = new HashSet(0);
	
	@OneToMany(targetEntity=Responsable.class, cascade=CascadeType.PERSIST, mappedBy="empresa")
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	
	@OneToMany(targetEntity=Oferta.class, cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="empresa")
	private Set<Oferta> ofertas = new HashSet<Oferta>(10);

	// Constructors

	/** default constructor */
	public Empresa() {
	}

	/** minimal constructor */
	public Empresa(String cif, String nombre, String codigo) {
		this.cif = cif;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	/** full constructor */
	public Empresa(String cif, String nombre, String tipoSociedad, String domicilio, Blob logo,
			Integer numTrabajadores, String web, String codigo, Set sectoreses, Set<Responsable> responsables, Set ofertas) {
		this.cif = cif;
		this.nombre = nombre;
		this.tipoSociedad = tipoSociedad;
		this.domicilio = domicilio;
//		this.logo = logo;
		this.numTrabajadores = numTrabajadores;
		this.web = web;
		this.codigo = codigo;
//		this.sectoreses = sectoreses;
		this.responsables = responsables;
		this.ofertas = ofertas;
	}

	// Property accessors

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSociedad() {
		return this.tipoSociedad;
	}

	public void setTipoSociedad(String tipoSociedad) {
		this.tipoSociedad = tipoSociedad;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

//	public Blob getLogo() {
//		return this.logo;
//	}
//
//	public void setLogo(Blob logo) {
//		this.logo = logo;
//	}

	public Integer getNumTrabajadores() {
		return this.numTrabajadores;
	}

	public void setNumTrabajadores(Integer numTrabajadores) {
		this.numTrabajadores = numTrabajadores;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

//	public Set getSectoreses() {
//		return this.sectoreses;
//	}
//
//	public void setSectoreses(Set sectoreses) {
//		this.sectoreses = sectoreses;
//	}

	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}
	
	public void addResponsable(Responsable responsable){
		responsables.add(responsable);
	}

	public Key getKey() {
		return key;
	}

	public Set<Oferta> getOfertas() {
		return this.ofertas;
	}

	public void setOfertas(Set ofertas) {
		this.ofertas = ofertas;
	}
	
	public void addOferta(Oferta oferta){
		ofertas.add(oferta);
	}

}