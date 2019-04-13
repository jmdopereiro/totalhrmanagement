package com.thrm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thrm.domain.Formacion;

/**
 * A data access object (DAO) providing persistence and search support for
 * Formacion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Formacion.Formaciones
 * @author MyEclipse Persistence Tools
 */

public class FormacionesDAO extends GenericDAO {

	private static final Log log = LogFactory.getLog(FormacionesDAO.class);
	// property constants
	public static final String CENTRO = "centro";
	public static final String ANNOINICIO = "annoinicio";
	public static final String ANNOFIN = "annofin";
	public static final String NOTAMEDIA = "notamedia";
	
	public void save(Formacion transientInstance) {
		log.debug("saving Formacion instance");
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

//	public void delete(Formacion persistentInstance) {
//		log.debug("deleting Formacion instance");
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
	
	public Formacion findByKey(Key key) {
		log.debug("getting Formacion instance with key id: " + key.getId());
		try {
			Formacion instance = getEntityManager().find(Formacion.class, key);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Formacion findById(java.lang.Integer id) {
		log.debug("getting Formacion instance with id: " + id);
		Key key = KeyFactory.createKey("Formacion", id);
		try {
			String queryString = "select f from Formacion f where key = ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1, key);
			return (Formacion) queryObject.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List findByExample(Formacion instance) {
//		log.debug("finding Formacion instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Formaciones").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Formacion instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Formacion as model where model." + propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByCentro(Object centro) {
//		return findByProperty(CENTRO, centro);
//	}
//
//	public List findByAnnoinicio(Object annoinicio) {
//		return findByProperty(ANNOINICIO, annoinicio);
//	}
//
//	public List findByAnnofin(Object annofin) {
//		return findByProperty(ANNOFIN, annofin);
//	}
//
//	public List findByNotamedia(Object notamedia) {
//		return findByProperty(NOTAMEDIA, notamedia);
//	}
//
//	public List findAll() {
//		log.debug("finding all Formacion instances");
//		try {
//			String queryString = "from Formacion";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Formacion merge(Formacion detachedInstance) {
//		log.debug("merging Formacion instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Formacion result = (Formacion) session.merge(detachedInstance);
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
//	public void attachDirty(Formacion instance) {
//		log.debug("attaching dirty Formacion instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Formacion instance) {
//		log.debug("attaching clean Formacion instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}