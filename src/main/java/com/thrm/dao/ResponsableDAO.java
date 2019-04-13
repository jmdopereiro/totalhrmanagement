package com.thrm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Responsable;

/**
 * A data access object (DAO) providing persistence and search support for
 * Responsables entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Responsable.Responsables
 * @author MyEclipse Persistence Tools
 */

public class ResponsableDAO extends GenericDAO{

	private static final Log log = LogFactory.getLog(ResponsableDAO.class);
	// property constants
	public static final String DNI = "dni";
	public static final String NOMBRE = "nombre";
	public static final String APELLIDOS = "apellidos";
	public static final String FIJO = "fijo";
	public static final String MOVIL = "movil";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";

	private EntityManager entityManager;

	public void save(Responsable responsable) {
		log.debug("saving Responsables instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(responsable);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
//
//	public void delete(Responsables persistentInstance) {
//		log.debug("deleting Responsables instance");
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
//	public Responsables findById(java.lang.Integer id) {
//		log.debug("getting Responsables instance with id: " + id);
//		try {
//			Responsables instance = (Responsables) getSession().get("dao.Responsables", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Responsables instance) {
//		log.debug("finding Responsables instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Responsables").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Responsables instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "select r from Responsable r where " + propertyName + "= ?1";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter(1, value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Responsable> findByDni(Object dni) {
		return findByProperty(DNI, dni);
	}
//
//	public List findByNombre(Object nombre) {
//		return findByProperty(NOMBRE, nombre);
//	}
//
//	public List findByApellidos(Object apellidos) {
//		return findByProperty(APELLIDOS, apellidos);
//	}
//
//	public List findByFijo(Object fijo) {
//		return findByProperty(FIJO, fijo);
//	}
//
//	public List findByMovil(Object movil) {
//		return findByProperty(MOVIL, movil);
//	}
//
//	public List findByFax(Object fax) {
//		return findByProperty(FAX, fax);
//	}
//
//	public List findByEmail(Object email) {
//		return findByProperty(EMAIL, email);
//	}
//
//	public List findByPassword(Object password) {
//		return findByProperty(PASSWORD, password);
//	}

	public List findAll() {
		log.debug("finding all Responsables instances");
		try {
			String queryString = "select r from Responsables r";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

//	public Responsables merge(Responsables detachedInstance) {
//		log.debug("merging Responsables instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Responsables result = (Responsables) session.merge(detachedInstance);
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
//	public void attachDirty(Responsables instance) {
//		log.debug("attaching dirty Responsables instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Responsables instance) {
//		log.debug("attaching clean Responsables instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}