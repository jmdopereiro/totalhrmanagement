package com.thrm.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.google.appengine.api.datastore.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Oferta;

/**
 * A data access object (DAO) providing persistence and search support for
 * Oferta entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Oferta.Ofertas
 * @author MyEclipse Persistence Tools
 */

public class OfertaDAO extends GenericDAO {

	// property constants
	public static final String TIPOOFERTA = "tipoOferta";
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	public static final String REMUNERACIONMINIMA = "remuneracionminima";
	public static final String REMUNERACIONMAXIMA = "remuneracionmaxima";
	public static final String OTRASRETRIBUCIONES = "otrasretribuciones";
	public static final String TIPOCONTRATO = "tipoContrato";
	public static final String DURACION = "duracion";
	public static final String JORNADA = "jornada";
	public static final String POBLACION = "poblacion";
	public static final String PAIS = "pais";
	public static final String EXPERIENCIAMINIMA = "experienciaminima";
	public static final String EXPERIENCIAMAXIMA = "experienciaMaxima";
	public static final String EDADMINIMA = "edadMinima";
	public static final String EDADMAXIMA = "edadMaxima";
	public static final String CARNETCONDUCIR = "carnetconducir";
	public static final String VEHICULOPROPIO = "vehiculopropio";
	public static final String TRABAJAACTUALMENTE = "trabajaactualmente";
	public static final String MOVILIDAD = "movilidad";
	public static final String OTROSDATOS = "otrosdatos";
	public static final String ESTADO = "estado";

	static final Logger logger = Logger.getLogger("OfertasDAO");
	private static final Log log = LogFactory.getLog(OfertaDAO.class);

	public void save(Oferta oferta) {
		logger.info("saving Oferta instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(oferta);
			tx.commit();
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE,"save failed", re);
			throw re;
		}
	}

//	public void save(Oferta oferta) {
//		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//		TransactionOptions options = TransactionOptions.Builder.withXG(true);
//		Transaction transaction = datastore.beginTransaction(options);
//
//		datastore.put(tx, new Entity(oferta));
//	}

	//	public void delete(Oferta persistentInstance) {
//		log.debug("deleting Oferta instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			session.delete(persistentInstance);
//
//			tx.commit();
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}

/**
 * Is not possible to get an entity from the id, you need to get it from the key which is extracted from the parent entity.
 */
//	public Oferta findById(java.lang.Long id) {
//		logger.info("getting Oferta instance with id: " + id);
//		Key key = KeyFactory.createKey("Oferta", id);
//		try {
//			Oferta instance = getEntityManager().find(Oferta.class, key);
////			String queryString = "select o from Oferta o where key = ?1";
////			Query queryObject = entityManager.createQuery(queryString);
////			queryObject.setParameter(1, key);
////			return (Oferta)queryObject.getSingleResult();
//			return instance;
//		} catch (RuntimeException re) {
//			logger.log(Level.SEVERE, "get failed", re);
//			throw re;
//		}
//	}

	public Oferta findByKey(Key key){
		Oferta instance = getEntityManager().find(Oferta.class, key);
		return instance;
	}

//	public List findByExample(Oferta instance) {
//		log.debug("finding Oferta instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Ofertas").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}

	public List<Oferta> findByProperty(String propertyName, Object value) {
		log.debug("finding Oferta instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "select e from Oferta e where " + propertyName + "= ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1, value);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<Oferta> findByExample(Oferta oferta) {
		log.debug("finding Oferta instances with : "+ oferta);
		try {
			StringBuilder builder = new StringBuilder("select e from Oferta e where ");
			if (oferta.getDuracion() != null) {
				builder.append("duracion = ?1");
			}

			String queryString = builder.toString();
			Query query = getEntityManager().createQuery(queryString);
			if (oferta.getDuracion() != null) {
				query.setParameter(1, oferta.getDuracion());
			}
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by example failed", e);
			throw e;
		}
	}
	
//	public List findByTipooferta(Object tipoOferta) {
//		return findByProperty(TIPOOFERTA, tipoOferta);
//	}

	public List<Oferta> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

//	public List findByDescripcion(Object descripcion) {
//		return findByProperty(DESCRIPCION, descripcion);
//	}
//
//	public List findByRemuneracionminima(Object remuneracionminima) {
//		return findByProperty(REMUNERACIONMINIMA, remuneracionminima);
//	}
//
//	public List findByRemuneracionmaxima(Object remuneracionmaxima) {
//		return findByProperty(REMUNERACIONMAXIMA, remuneracionmaxima);
//	}
//
//	public List findByOtrasretribuciones(Object otrasretribuciones) {
//		return findByProperty(OTRASRETRIBUCIONES, otrasretribuciones);
//	}
//
	public List findByTipoContrato(Object tipoContrato) {
		return findByProperty(TIPOCONTRATO, tipoContrato);
	}

//	public List findByDuracion(Object duracion) {
//		return findByProperty(DURACION, duracion);
//	}
//
//	public List findByJornada(Object jornada) {
//		return findByProperty(JORNADA, jornada);
//	}
//
//	public List findByPoblacion(Object poblacion) {
//		return findByProperty(POBLACION, poblacion);
//	}
//
//	public List findByPais(Object pais) {
//		return findByProperty(PAIS, pais);
//	}
//
//	public List findByExperienciaminima(Object experienciaminima) {
//		return findByProperty(EXPERIENCIAMINIMA, experienciaminima);
//	}
//
//	public List findByexperienciaMaxima(Object experienciaMaxima) {
//		return findByProperty(EXPERIENCIAMAXIMA, experienciaMaxima);
//	}
//
//	public List findByEdadminima(Object edadMinima) {
//		return findByProperty(EDADMINIMA, edadMinima);
//	}
//
//	public List findByEdadmaxima(Object edadMaxima) {
//		return findByProperty(EDADMAXIMA, edadMaxima);
//	}
//
//	public List findByCarnetconducir(Object carnetconducir) {
//		return findByProperty(CARNETCONDUCIR, carnetconducir);
//	}
//
//	public List findByVehiculopropio(Object vehiculopropio) {
//		return findByProperty(VEHICULOPROPIO, vehiculopropio);
//	}
//
//	public List findByTrabajaactualmente(Object trabajaactualmente) {
//		return findByProperty(TRABAJAACTUALMENTE, trabajaactualmente);
//	}
//
//	public List findByMovilidad(Object movilidad) {
//		return findByProperty(MOVILIDAD, movilidad);
//	}
//
//	public List findByOtrosdatos(Object otrosdatos) {
//		return findByProperty(OTROSDATOS, otrosdatos);
//	}
//
	public List findByEstado(Oferta.Estados estado) {
		return findByProperty(ESTADO, estado);
	}

	public List<Oferta> findAll() {
//		log.debug("finding all Oferta instances");
		try {
			String queryString = "select o from Oferta o";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		}
	}

//	public List findLastFive() {
//		log.debug("finding last five Oferta instances ");
//		try {
//			String queryString = "from Oferta order by idoferta desc";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setMaxResults(5);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find last five failed", re);
//			throw re;
//		}
//	}

	public Oferta merge(Oferta detachedInstance) {
//		log.debug("merging Oferta instance");
		try {
			
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			Oferta result = (Oferta) getEntityManager().merge(detachedInstance);
			tx.commit();
//			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
//			log.error("merge failed", re);
			throw re;
		}
	}

//	public void attachDirty(Oferta instance) {
//		log.debug("attaching dirty Oferta instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Oferta instance) {
//		log.debug("attaching clean Oferta instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}