package com.thrm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thrm.domain.Candidato;

//import dao.utils.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Candidato entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Candidato.Candidatos
 *
 */

public class CandidatosDAO extends GenericDAO {

	private static final Log log = LogFactory.getLog(CandidatosDAO.class);

	// property constants
	public static final String DNI = "dni";
	public static final String NOMBRE = "nombre";
	public static final String APELLIDOS = "apellidos";
	public static final String DIRECCION = "direccion";
	public static final String FIJO = "fijo";
	public static final String MOVIL = "movil";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String ANNOSEXPERIENCIA = "annosexperiencia";
	public static final String GENERO = "genero";
	public static final String NACIONALIDAD = "nacionalidad";
	public static final String ESTADOCIVIL = "estadocivil";
	public static final String CARNETCONDUCIR = "carnetconducir";
	public static final String VEHICULOPROPIO = "vehiculopropio";
	public static final String TRABAJAACTUALMENTE = "trabajaactualmente";
	public static final String MOVILIDAD = "movilidad";
	public static final String OTROSDATOS = "otrosdatos";

	public void save(Candidato candidato) {
		log.debug("saving Candidato instance");
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().persist(candidato);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
//			getEntityManager().close();
		}
	}

	public void delete(Candidato persistentInstance) {
		log.debug("deleting Candidato instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().remove(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Candidato findByKey(Key key) {
		log.debug("getting Candidato instance with key id: " + key.getId());
		try {
			Candidato instance = getEntityManager().find(Candidato.class, key);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	// public List findByExample(Candidato instance) {
	// log.debug("finding Candidato instance by example");
	// try {
	// // List results =
	// getSession().createCriteria("dao.Candidatos").add(Example.create(instance)).list();
	// // log.debug("find by example successful, result size: " +
	// results.size());
	// // return results;
	// } catch (RuntimeException re) {
	// log.error("find by example failed", re);
	// throw re;
	// }
	// }

	public List<Candidato> findByProperty(String propertyName, Object value) {
		log.debug("finding Candidato instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "select c from Candidato c where " + propertyName + "= ?1";
			 Query query = getEntityManager().createQuery(queryString);
			 query.setParameter(1, value);
			 return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Candidato> findByDni(Object dni) {
		return findByProperty(DNI, dni);
	}
	//
	// public List findByNombre(Object nombre) {
	// return findByProperty(NOMBRE, nombre);
	// }
	//
	// public List findByApellidos(Object apellidos) {
	// return findByProperty(APELLIDOS, apellidos);
	// }
	//
	// public List findByDireccion(Object direccion) {
	// return findByProperty(DIRECCION, direccion);
	// }
	//
	// public List findByFijo(Object fijo) {
	// return findByProperty(FIJO, fijo);
	// }
	//
	// public List findByMovil(Object movil) {
	// return findByProperty(MOVIL, movil);
	// }
	//
	// public List findByFax(Object fax) {
	// return findByProperty(FAX, fax);
	// }
	//
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	// public List findByPassword(Object password) {
	// return findByProperty(PASSWORD, password);
	// }
	//
	// public List findByAnnosexperiencia(Object annosexperiencia) {
	// return findByProperty(ANNOSEXPERIENCIA, annosexperiencia);
	// }
	//
	// public List findByGenero(Object genero) {
	// return findByProperty(GENERO, genero);
	// }
	//
	// public List findByNacionalidad(Object nacionalidad) {
	// return findByProperty(NACIONALIDAD, nacionalidad);
	// }
	//
	// public List findByEstadocivil(Object estadocivil) {
	// return findByProperty(ESTADOCIVIL, estadocivil);
	// }
	//
	// public List findByCarnetconducir(Object carnetconducir) {
	// return findByProperty(CARNETCONDUCIR, carnetconducir);
	// }
	//
	// public List findByVehiculopropio(Object vehiculopropio) {
	// return findByProperty(VEHICULOPROPIO, vehiculopropio);
	// }
	//
	// public List findByTrabajaactualmente(Object trabajaactualmente) {
	// return findByProperty(TRABAJAACTUALMENTE, trabajaactualmente);
	// }
	//
	// public List findByMovilidad(Object movilidad) {
	// return findByProperty(MOVILIDAD, movilidad);
	// }
	//
	// public List findByOtrosdatos(Object otrosdatos) {
	// return findByProperty(OTROSDATOS, otrosdatos);
	// }

	public List findAll() {
		log.debug("finding all Candidato instances");
		try {
			String queryString = "select c from Candidato c";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	// public List findLastFive() {
	// log.debug("finding last five Candidato instances ");
	// try {
	// String queryString = "from Candidato order by idcandidato desc";
	// // Query queryObject = getSession().createQuery(queryString);
	// queryObject.setMaxResults(5);
	// return queryObject.list();
	// } catch (RuntimeException re) {
	// log.error("find last five failed", re);
	// throw re;
	// }
	// }
	
	public Candidato merge(Candidato detachedInstance) {
		log.debug("merging Candidato instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();

			Candidato result = (Candidato) getEntityManager().merge(detachedInstance);

			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}