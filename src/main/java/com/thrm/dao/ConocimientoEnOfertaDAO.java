package com.thrm.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConocimientosEnOfertas entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ConocimientoEnOferta
 * @author MyEclipse Persistence Tools
 */

public class ConocimientoEnOfertaDAO {

	private static final Log log = LogFactory.getLog(ConocimientoEnOfertaDAO.class);
	// property constants
	public static final String NIVEL = "nivel";

//	public void save(ConocimientosEnOfertas transientInstance) {
//		log.debug("saving ConocimientosEnOfertas instance");
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
//	public void delete(ConocimientosEnOfertas persistentInstance) {
//		log.debug("deleting ConocimientosEnOfertas instance");
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
//	public ConocimientosEnOfertas findById(java.lang.Integer id) {
//		log.debug("getting ConocimientosEnOfertas instance with id: " + id);
//		try {
//			ConocimientosEnOfertas instance = (ConocimientosEnOfertas) getSession().get("dao.Conocimientosenofertas",
//					id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(ConocimientosEnOfertas instance) {
//		log.debug("finding ConocimientosEnOfertas instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Conocimientosenofertas").add(Example.create(instance))
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
//		log.debug("finding ConocimientosEnOfertas instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from ConocimientosEnOfertas as model where model." + propertyName + "= ?";
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
//		log.debug("finding all ConocimientosEnOfertas instances");
//		try {
//			String queryString = "from ConocimientosEnOfertas";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public ConocimientosEnOfertas merge(ConocimientosEnOfertas detachedInstance) {
//		log.debug("merging ConocimientosEnOfertas instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			ConocimientosEnOfertas result = (ConocimientosEnOfertas) session.merge(detachedInstance);
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
//	public void attachDirty(ConocimientosEnOfertas instance) {
//		log.debug("attaching dirty ConocimientosEnOfertas instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(ConocimientosEnOfertas instance) {
//		log.debug("attaching clean ConocimientosEnOfertas instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}