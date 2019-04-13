package com.thrm.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

/**
 * Oferta entity provides the base persistence definition of the Oferta
 * entity.
 */
@Entity
public class Oferta implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private String tipoOferta;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;

    private Integer remuneracionMinima;
    private Integer remuneracionMaxima;
    private String otrasRetribuciones;
    private String tipoContrato;
    private String duracion;
    private String jornada;
    private String poblacion;
    private String pais;
    private Integer experienciaMinima;
    private Integer experienciaMaxima;
    private Integer edadMinima;
    private Integer edadMaxima;
    private Boolean carnetConducir;
    private Boolean vehiculoPropio;
    private Boolean trabajaActualmente;
    private String movilidad;
    private String otrosDatos;
    private Estados estado;
//	private Set cursos = new HashSet(0);

    @ManyToOne(targetEntity = Empresa.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Empresa empresa;

    @OneToMany(targetEntity = IdiomaEnOferta.class, cascade = CascadeType.PERSIST, mappedBy = "oferta")
    private Set<IdiomaEnOferta> idiomasEnOfertas = new HashSet<>(0);

    @OneToMany(targetEntity = ConocimientoEnOferta.class, cascade = CascadeType.PERSIST, mappedBy = "oferta")
    private Set<ConocimientoEnOferta> conocimientosEnOfertas = new HashSet<>(0);

    @OneToMany(targetEntity = Inscripcion.class, cascade = CascadeType.PERSIST)
    private Set<Inscripcion> inscripciones = new HashSet<>(0);

    public Oferta() {
    }

    /**
     * minimal constructor
     */
    public Oferta(Empresa empresa, String tipoOferta, String nombre, String descripcion, String fechaInicio,
                  String fechaFin, String tipoContrato, String duracion, String jornada, Estados estado) {
        this.empresa = empresa;
        this.tipoOferta = tipoOferta;
        this.nombre = nombre;
        this.descripcion = descripcion;
//		this.fechaInicio = fechaInicio;
//		this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
        this.duracion = duracion;
        this.jornada = jornada;
        this.estado = estado;
    }

    /**
     * full constructor
     */
    public Oferta(Empresa empresa, String tipoOferta, String nombre, String descripcion, Date fechaInicio,
                  Date fechaFin, Integer remuneracionminima, Integer remuneracionmaxima, String otrasretribuciones,
                  String tipoContrato, String duracion, String jornada, String poblacion, String pais,
                  Integer experienciaminima, Integer experienciaMaxima, Integer edadMinima, Integer edadMaxima,
                  Boolean carnetconducir, Boolean vehiculopropio, Boolean trabajaactualmente, String movilidad,
                  String otrosdatos, Estados estado, Set cursos, Set idiomasEnOfertas, Set conocimientosEnOfertas,
                  Set inscripciones) {
        this.empresa = empresa;
        this.tipoOferta = tipoOferta;
        this.nombre = nombre;
        this.descripcion = descripcion;
//		this.fechaInicio = fechaInicio;
//		this.fechaFin = fechaFin;
        this.remuneracionMinima = remuneracionminima;
        this.remuneracionMaxima = remuneracionmaxima;
        this.otrasRetribuciones = otrasretribuciones;
        this.tipoContrato = tipoContrato;
        this.duracion = duracion;
        this.jornada = jornada;
        this.poblacion = poblacion;
        this.pais = pais;
        this.experienciaMinima = experienciaminima;
        this.experienciaMaxima = experienciaMaxima;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.carnetConducir = carnetconducir;
        this.vehiculoPropio = vehiculopropio;
        this.trabajaActualmente = trabajaactualmente;
        this.movilidad = movilidad;
        this.otrosDatos = otrosdatos;
        this.estado = estado;
//		this.cursos = cursos;
        this.idiomasEnOfertas = idiomasEnOfertas;
        this.conocimientosEnOfertas = conocimientosEnOfertas;
        this.inscripciones = inscripciones;
    }

    // Property accessors
    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTipoOferta() {
        return this.tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        // logger.info(fechaInicio);
        return fechaInicio;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void setFechaInicio(String fechaInicio) {

        try {
            if (!fechaInicio.equals(""))
                this.fechaInicio = sdf.parse(fechaInicio);
        } catch (ParseException e) {
//			logger.info("ParseException");
            e.printStackTrace();
        }
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
//		logger.info(fechaFin);
        try {
            if (!fechaFin.equals(""))
                this.fechaFin = sdf.parse(fechaFin);
        } catch (ParseException e) {
//			Logger logger = Logger.getLogger(Oferta.class);
//			logger.info("ParseException");
            e.printStackTrace();
        }
    }

//	public void setFechafin(Date fechafin) {
//		// logger.info(fechafin);
//		this.fechaFin = fechaFin;
//	}

    public Integer getRemuneracionminima() {
        return this.remuneracionMinima;
    }

    public void setRemuneracionminima(Integer remuneracionminima) {
        this.remuneracionMinima = remuneracionminima;
    }

    public Integer getRemuneracionmaxima() {
        return this.remuneracionMaxima;
    }

    public void setRemuneracionmaxima(Integer remuneracionmaxima) {
        this.remuneracionMaxima = remuneracionmaxima;
    }

    public String getOtrasretribuciones() {
        return this.otrasRetribuciones;
    }

    public void setOtrasretribuciones(String otrasretribuciones) {
        this.otrasRetribuciones = otrasretribuciones;
    }

    public String getTipoContrato() {
        return this.tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getJornada() {
        return this.jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getExperienciaminima() {
        return this.experienciaMinima;
    }

    public void setExperienciaminima(Integer experienciaminima) {
        this.experienciaMinima = experienciaminima;
    }

    public Integer getExperienciaMaxima() {
        return this.experienciaMaxima;
    }

    public void setExperienciaMaxima(Integer experienciaMaxima) {
        this.experienciaMaxima = experienciaMaxima;
    }

    public Integer getEdadMinima() {
        return this.edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getEdadMaxima() {
        return this.edadMaxima;
    }

    public void setEdadMaxima(Integer edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public Boolean getCarnetConducir() {
        return this.carnetConducir;
    }

    public void setCarnetConducir(Boolean carnetConducir) {
        this.carnetConducir = carnetConducir;
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

    public Estados getEstado() {
        return this.estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

//	public Set getCursos() {
//		return this.cursos;
//	}

//	public void setCursos(Set cursos) {
//		this.cursos = cursos;
//	}

    public Set getIdiomasEnOfertas() {
        return this.idiomasEnOfertas;
    }

    public void setIdiomasEnOfertas(Set idiomasEnOfertas) {
        this.idiomasEnOfertas = idiomasEnOfertas;
    }

//	public Set getConocimientosEnOfertas() {
//		return this.conocimientosEnOfertas;
//	}
//
//	public void setConocimientosEnOfertas(Set conocimientosEnOfertas) {
//		this.conocimientosEnOfertas = conocimientosEnOfertas;
//	}

//	public void addConocimientoEnOferta(conocimientoEnOferta){
//		conocimientosEnOfertas.add(conocimientoEnOferta);
//	}

    public Set<Inscripcion> getInscripciones() {
        return this.inscripciones;
    }

    public void setInscripciones(Set inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void addInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public Key getKey() {
        return key;
    }

    /**
     * Need this method to update, when the object comes from the web it doesn't have the key initialized.
     */
    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public String toString() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Empresa: " + this.getEmpresa().getNombre());
        System.out.println("Tipo de contrato: " + this.getTipoContrato());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("Duracion: " + this.getDuracion());
        System.out.println("Jornada laboral: " + this.getJornada());
        System.out.println("Poblacion: " + this.getPoblacion());
        System.out.println("Pais: " + this.getPais());
        System.out.println("Remuneracion minima: " + this.getRemuneracionminima());
        System.out.println("Otras retribuciones: " + this.getOtrasretribuciones());
        System.out.println("Movilidad: " + this.getMovilidad());

        System.out.println("Fecha fin: " + this.getFechaFin());
        System.out.println("Carne: " + this.getCarnetConducir());
        return super.toString();
    }

    public enum Estados {
        CREADA,
        INICIADA,
        PRESELECCION,
        CERRADA,
        ELIMINADA
    }

}