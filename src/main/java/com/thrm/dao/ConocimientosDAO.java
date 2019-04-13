package com.thrm.dao;

import java.util.List;

import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Conocimiento;

/**
 * A data access object (DAO) providing persistence and search support for
 * Conocimientos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.Conocimientos
 * @author MyEclipse Persistence Tools
 */

public class ConocimientosDAO extends GenericDAO {

	private static final Log log = LogFactory.getLog(ConocimientosDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	
//	public void save(Conocimientos transientInstance) {
//		log.debug("saving Conocimientos instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//			session.save(transientInstance);
//
//			tx.commit();
//
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Conocimientos persistentInstance) {
//		log.debug("deleting Conocimientos instance");
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
//	public Conocimientos findById(java.lang.Integer id) {
//		log.debug("getting Conocimientos instance with id: " + id);
//		try {
//			Conocimientos instance = (Conocimientos) getSession().get("dao.Conocimientos", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Conocimientos instance) {
//		log.debug("finding Conocimientos instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Conocimientos").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Conocimientos instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Conocimientos as model where model." + propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByNombre(Object nombre) {
//		return findByProperty(NOMBRE, nombre);
//	}

	public List findAll() {
		log.debug("finding all Conocimientos instances");
		try {
			String queryString = "select c from Conocimiento c";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

//	public Conocimientos merge(Conocimientos detachedInstance) {
//		log.debug("merging Conocimientos instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Conocimientos result = (Conocimientos) session.merge(detachedInstance);
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
//	public void attachDirty(Conocimientos instance) {
//		log.debug("attaching dirty Conocimientos instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Conocimientos instance) {
//		log.debug("attaching clean Conocimientos instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}