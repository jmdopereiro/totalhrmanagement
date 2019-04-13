package com.thrm.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Idiomasenofertas entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.Idiomasenofertas
 * @author MyEclipse Persistence Tools
 */

public class IdiomasenofertasDAO {

	private static final Log log = LogFactory.getLog(IdiomasenofertasDAO.class);
	// property constants
	public static final String ESCRITO = "escrito";
	public static final String HABLADO = "hablado";
	public static final String TRADUCCION = "traduccion";
	public static final String TECNICO = "tecnico";

//	public void save(Idiomasenofertas transientInstance) {
//		log.debug("saving Idiomasenofertas instance");
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
//	public void delete(Idiomasenofertas persistentInstance) {
//		log.debug("deleting Idiomasenofertas instance");
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
//	public Idiomasenofertas findById(java.lang.Integer id) {
//		log.debug("getting Idiomasenofertas instance with id: " + id);
//		try {
//			Idiomasenofertas instance = (Idiomasenofertas) getSession().get("dao.Idiomasenofertas", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Idiomasenofertas instance) {
//		log.debug("finding Idiomasenofertas instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Idiomasenofertas").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Idiomasenofertas instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Idiomasenofertas as model where model." + propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByEscrito(Object escrito) {
//		return findByProperty(ESCRITO, escrito);
//	}
//
//	public List findByHablado(Object hablado) {
//		return findByProperty(HABLADO, hablado);
//	}
//
//	public List findByTraduccion(Object traduccion) {
//		return findByProperty(TRADUCCION, traduccion);
//	}
//
//	public List findByTecnico(Object tecnico) {
//		return findByProperty(TECNICO, tecnico);
//	}
//
//	public List findAll() {
//		log.debug("finding all Idiomasenofertas instances");
//		try {
//			String queryString = "from Idiomasenofertas";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Idiomasenofertas merge(Idiomasenofertas detachedInstance) {
//		log.debug("merging Idiomasenofertas instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Idiomasenofertas result = (Idiomasenofertas) session.merge(detachedInstance);
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
//	public void attachDirty(Idiomasenofertas instance) {
//		log.debug("attaching dirty Idiomasenofertas instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Idiomasenofertas instance) {
//		log.debug("attaching clean Idiomasenofertas instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}