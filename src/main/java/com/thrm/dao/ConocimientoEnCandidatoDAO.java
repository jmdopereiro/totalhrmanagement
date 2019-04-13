package com.thrm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Key;
import com.thrm.domain.ConocimientoEnCandidato;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConocimientoEnCandidato entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see ConocimientoEnCandidato.Conocimientosencandidatos
 * @author MyEclipse Persistence Tools
 */

public class ConocimientoEnCandidatoDAO extends GenericDAO{

	private static final Log log = LogFactory.getLog(ConocimientoEnCandidatoDAO.class);
	// property constants
	public static final String NIVEL = "nivel";
	
	private EntityManager entityManager;

	public void save(ConocimientoEnCandidato transientInstance) {
		log.debug("saving ConocimientoEnCandidato instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConocimientoEnCandidato persistentInstance) {
		log.debug("deleting ConocimientoEnCandidato instance");
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

	public ConocimientoEnCandidato findByKey(Key key) {
		log.debug("getting ConocimientoEnCandidato instance with id: " + key.getId());
		try {
			String queryString = "select i from ConocimientoEnCandidato i where key = ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1, key);
			return (ConocimientoEnCandidato) queryObject.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public ConocimientoEnCandidato findById(java.lang.Integer id) {
//		log.debug("getting ConocimientoEnCandidato instance with id: " + id);
//		try {
//			ConocimientoEnCandidato instance = (ConocimientoEnCandidato) getSession().get(
//					"dao.Conocimientosencandidatos", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(ConocimientoEnCandidato instance) {
//		log.debug("finding ConocimientoEnCandidato instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Conocimientosencandidatos").add(Example.create(instance))
//					.list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding ConocimientoEnCandidato instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from ConocimientoEnCandidato as model where model." + propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByNivel(Object nivel) {
//		return findByProperty(NIVEL, nivel);
//	}
//
//	public List findAll() {
//		log.debug("finding all ConocimientoEnCandidato instances");
//		try {
//			String queryString = "from ConocimientoEnCandidato";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public ConocimientoEnCandidato merge(ConocimientoEnCandidato detachedInstance) {
//		log.debug("merging ConocimientoEnCandidato instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			ConocimientoEnCandidato result = (ConocimientoEnCandidato) session.merge(detachedInstance);
//
//			tx.commit();
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(ConocimientoEnCandidato instance) {
//		log.debug("attaching dirty ConocimientoEnCandidato instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(ConocimientoEnCandidato instance) {
//		log.debug("attaching clean ConocimientoEnCandidato instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}