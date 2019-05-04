package com.thrm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

/**
 * Responsables entity provides the base persistence definition of the
 * Responsables entity
 */

@Entity
public class Responsable implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;


	private Integer idresponsable;

	@ManyToOne(targetEntity=Empresa.class, cascade=CascadeType.PERSIST)
    private Empresa empresa;
	
	private String dni;
	private String nombre;
	private String apellidos;
	private Integer fijo;
	private Integer movil;
	private String fax;
	private String email;
	private String password;

	// Constructors

	/** default constructor */
	public Responsable() {
	}

	/** minimal constructor */
	public Responsable(Empresa empresas, String dni, String nombre, String apellidos, String email, String password) {
		this.empresa = empresas;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
	}

	/** full constructor */
	public Responsable(Empresa empresas, String dni, String nombre, String apellidos, Integer fijo, Integer movil,
			String fax, String email, String password) {
		this.empresa = empresas;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fijo = fijo;
		this.movil = movil;
		this.fax = fax;
		this.email = email;
		this.password = password;
	}

	// Property accessors

	public Integer getIdresponsable() {
		return this.idresponsable;
	}

	public void setIdresponsable(Integer idresponsable) {
		this.idresponsable = idresponsable;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getFijo() {
		return this.fijo;
	}

	public void setFijo(Integer fijo) {
		this.fijo = fijo;
	}

	public Integer getMovil() {
		return this.movil;
	}

	public void setMovil(Integer movil) {
		this.movil = movil;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}