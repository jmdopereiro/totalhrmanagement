package com.thrm.dao;

import java.util.List;

import javax.mail.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Certificados;

/**
 * A data access object (DAO) providing persistence and search support for
 * Certificados entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.Certificados
 * @author MyEclipse Persistence Tools
 */

public class CertificadosDAO {

	private static final Log log = LogFactory.getLog(CertificadosDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String CENTRO = "centro";
	public static final String NOTA = "nota";

//	public void save(Certificados transientInstance) {
//		log.debug("saving Certificados instance");
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
//	public void delete(Certificados persistentInstance) {
//		log.debug("deleting Certificados instance");
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
//	public Certificados findById(java.lang.Integer id) {
//		log.debug("getting Certificados instance with id: " + id);
//		try {
//			Certificados instance = (Certificados) getSession().get("dao.Certificados", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Certificados instance) {
//		log.debug("finding Certificados instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Certificados").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Certificados instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Certificados as model where model." + propertyName + "= ?";
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
//
//	public List findByCentro(Object centro) {
//		return findByProperty(CENTRO, centro);
//	}
//
//	public List findByNota(Object nota) {
//		return findByProperty(NOTA, nota);
//	}
//
//	public List findAll() {
//		log.debug("finding all Certificados instances");
//		try {
//			String queryString = "from Certificados";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Certificados merge(Certificados detachedInstance) {
//		log.debug("merging Certificados instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Certificados result = (Certificados) session.merge(detachedInstance);
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
//	public void attachDirty(Certificados instance) {
//		log.debug("attaching dirty Certificados instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Certificados instance) {
//		log.debug("attaching clean Certificados instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}