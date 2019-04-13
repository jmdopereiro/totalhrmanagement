package com.thrm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Idioma;

/**
 * A data access object (DAO) providing persistence and search support for
 * Idioma entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Idioma.Idiomas
 * @author MyEclipse Persistence Tools
 */

public class IdiomasDAO {

	private static final Log log = LogFactory.getLog(IdiomasDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	
	private EntityManager entityManager;

	public void save(Idioma transientInstance) {
		log.debug("saving Idioma instance");
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

//	public void delete(Idioma persistentInstance) {
//		log.debug("deleting Idioma instance");
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
//	public Idioma findById(java.lang.Integer id) {
//		log.debug("getting Idioma instance with id: " + id);
//		try {
//			Idioma instance = (Idioma) getSession().get("dao.Idiomas", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}

//	public List findByExample(Idioma instance) {
//		log.debug("finding Idioma instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Idiomas").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Idioma instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Idioma as model where model." + propertyName + "= ?";
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
		log.debug("finding all Idioma instances");
		try {
			String queryString = "select i from Idioma i";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

//	public Idioma merge(Idioma detachedInstance) {
//		log.debug("merging Idioma instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Idioma result = (Idioma) session.merge(detachedInstance);
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
//	public void attachDirty(Idioma instance) {
//		log.debug("attaching dirty Idioma instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Idioma instance) {
//		log.debug("attaching clean Idioma instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}