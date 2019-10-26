package com.thrm.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

/**
 * Candidato entity provides the base persistence definition of the Candidato entity
 */
@Entity
public class Candidato implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String direccion;
    private Integer fijo;
    private Integer movil;
    private Integer fax;
    private String email;
    private Blob foto;
    private String fotoFileName;
    private String fotoContentType;


    private String password;
    private Integer annosExperiencia;
    private String genero;
    private String nacionalidad;
    private String estadoCivil;
    private Boolean carnetConducir;
    private Boolean vehiculoPropio;
    private Boolean trabajaActualmente;
    private String movilidad;
    private String otrosDatos;

    @OneToMany
    private Set<IdiomaEnCandidato> idiomasEnCandidato = new HashSet<>(0);

    @OneToMany
    private Set<ConocimientoEnCandidato> conocimientosEnCandidato = new HashSet<>(0);

    @OneToMany
    private Set<Formacion> formaciones = new HashSet<>(0);

    @OneToMany
    private Set<Experiencia> experiencias = new HashSet<>(0);

    @OneToMany(targetEntity = Inscripcion.class, cascade = CascadeType.MERGE, mappedBy = "candidato")
    @Unowned
    private Set<Inscripcion> inscripciones = new HashSet<>(0);

    @OneToMany(targetEntity = Curriculum.class, cascade = CascadeType.MERGE, mappedBy = "candidato")
    private Set<Curriculum> curriculums = new HashSet<Curriculum>(0);

    // Constructors

    /**
     * default constructor
     */
    public Candidato() {
    }

    /**
     * minimal constructor
     */
    public Candidato(String dni, String nombre, String apellidos, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    /**
     * full constructor
     */
    public Candidato(String dni, String nombre, String apellidos, Date fechaNacimiento, String direccion,
                     Integer fijo, Integer movil, Integer fax, String email, Blob foto, String password,
                     Integer annosexperiencia, String genero, String nacionalidad, String estadocivil, Boolean carnetconducir,
                     Boolean vehiculopropio, Boolean trabajaactualmente, String movilidad, String otrosdatos,
                     Set<IdiomaEnCandidato> idiomasEnCandidato, Set<ConocimientoEnCandidato> conocimientosEnCandidato, Set formaciones, Set<Experiencia> experiencias,
                     Set inscripciones, Set<Curriculum> curriculums) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.fijo = fijo;
        this.movil = movil;
        this.fax = fax;
        this.email = email;
        this.foto = foto;
        this.password = password;
        this.annosExperiencia = annosexperiencia;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadocivil;
        this.carnetConducir = carnetconducir;
        this.vehiculoPropio = vehiculopropio;
        this.trabajaActualmente = trabajaactualmente;
        this.movilidad = movilidad;
        this.otrosDatos = otrosdatos;
        this.idiomasEnCandidato = idiomasEnCandidato;
        this.conocimientosEnCandidato = conocimientosEnCandidato;
        this.formaciones = formaciones;
        this.experiencias = experiencias;
        this.inscripciones = inscripciones;
        this.curriculums = curriculums;
    }

    // Property accessors

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

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void setFechaNacimiento(String fechaNacimiento) {
        try {
            if (!fechaNacimiento.equals("")) {
                this.fechaNacimiento = sdf.parse(fechaNacimiento);
            }
        } catch (ParseException e) {
//			logger.info("ParseException");
            e.printStackTrace();
        }
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Integer getFax() {
        return this.fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getFoto() {
        return this.foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAnnosexperiencia() {
        return this.annosExperiencia;
    }

    public void setAnnosexperiencia(Integer annosexperiencia) {
        this.annosExperiencia = annosexperiencia;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadocivil() {
        return this.estadoCivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadoCivil = estadocivil;
    }

    public Boolean getCarnetconducir() {
        return this.carnetConducir;
    }

    public void setCarnetconducir(Boolean carnetconducir) {
        this.carnetConducir = carnetconducir;
    }

    public Boolean getVehiculopropio() {
        return this.vehiculoPropio;
    }

    public void setVehiculopropio(Boolean vehiculopropio) {
        this.vehiculoPropio = vehiculopropio;
    }

    public Boolean getTrabajaactualmente() {
        return this.trabajaActualmente;
    }

    public void setTrabajaactualmente(Boolean trabajaactualmente) {
        this.trabajaActualmente = trabajaactualmente;
    }

    public String getMovilidad() {
        return this.movilidad;
    }

    public void setMovilidad(String movilidad) {
        this.movilidad = movilidad;
    }

    public String getOtrosdatos() {
        return this.otrosDatos;
    }

    public void setOtrosdatos(String otrosdatos) {
        this.otrosDatos = otrosdatos;
    }

    public Set<IdiomaEnCandidato> getIdiomasEnCandidato() {
        return this.idiomasEnCandidato;
    }

    public void setIdiomasEnCandidato(Set<IdiomaEnCandidato> idiomasEnCandidato) {
        this.idiomasEnCandidato = idiomasEnCandidato;
    }

    public Set<ConocimientoEnCandidato> getConocimientosEnCandidato() {
        return this.conocimientosEnCandidato;
    }

    public void setConocimientosEnCandidato(Set<ConocimientoEnCandidato> conocimientosEnCandidato) {
        this.conocimientosEnCandidato = conocimientosEnCandidato;
    }

    public Set getFormaciones() {
        return this.formaciones;
    }

    public void setFormaciones(Set formaciones) {
        this.formaciones = formaciones;
    }

    public Set<Experiencia> getExperiencias() {
        return this.experiencias;
    }

    public void setExperiencias(Set<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void addInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public Set<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(Set<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public String getFotoFileName() {
        return fotoFileName;
    }

    public void setFotoFileName(String fotoFileName) {
        this.fotoFileName = fotoFileName;
    }

    public String getFotoContentType() {
        return fotoContentType;
    }

    public void setFotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
    }
}