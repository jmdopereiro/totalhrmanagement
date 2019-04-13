package com.thrm.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Inscripcion;

/**
 * A data access object (DAO) providing persistence and search support for
 * Inscripcion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Inscripcion.Inscripciones
 * @author MyEclipse Persistence Tools
 */

public class InscripcionDAO extends GenericDAO{

	private static final Log logger = LogFactory.getLog(InscripcionDAO.class);
	// property constants
	public static final String ESTADO = "estado";

	public void save(Inscripcion transientInstance) {

		logger.debug("saving Inscripcion instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(transientInstance);
			tx.commit();
			logger.debug("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

//	public void delete(Inscripcion persistentInstance) {
//		log.debug("deleting Inscripcion instance");
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
//
//	public Inscripcion findById(java.lang.Integer id) {
//		log.debug("getting Inscripcion instance with id: " + id);
//		try {
//			Inscripcion instance = (Inscripcion) getSession().get("dao.Inscripciones", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}

	public boolean findByExample(Inscripcion instance) {
		logger.debug("finding Inscripcion instance by example");
		try {

			return getEntityManager().contains(instance);
			
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}

	public List<Inscripcion> findByProperty(String propertyName, Object value) {
		logger.debug("finding Inscripcion instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "select i from Inscripcion i where " + propertyName + "= ?1";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter(1, value);
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

//	public List findByEstado(Object estado) {
//		return findByProperty(ESTADO, estado);
//	}
//
//	public List findAll() {
//		log.debug("finding all Inscripcion instances");
//		try {
//			String queryString = "from Inscripcion";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}

	public Inscripcion merge(Inscripcion detachedInstance) {
		logger.debug("merging Inscripcion instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			Inscripcion inscripcion = (Inscripcion) getEntityManager().merge(detachedInstance);
			tx.commit();
			logger.debug("merge successful");
			return inscripcion;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

//	public void attachDirty(Inscripcion instance) {
//		log.debug("attaching dirty Inscripcion instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Inscripcion instance) {
//		log.debug("attaching clean Inscripcion instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}