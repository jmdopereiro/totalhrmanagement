package com.thrm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thrm.domain.Curso;

/**
 * A data access object (DAO) providing persistence and search support for
 * Curso entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Curso.Cursos
 * @author MyEclipse Persistence Tools
 */

public class CursosDAO extends GenericDAO { 

	private static final Log log = LogFactory.getLog(CursosDAO.class);
	// property constants
	public static final String TIPO = "tipo";
	public static final String CURSO = "curso";
	
	private EntityManager entityManager;

	public void save(Curso transientInstance) {
		log.debug("saving Curso instance");
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

//	public void delete(Curso persistentInstance) {
//		log.debug("deleting Curso instance");
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
//	public Curso findById(java.lang.Integer id) {
//		log.debug("getting Curso instance with id: " + id);
//		try {
//			Curso instance = (Curso) getSession().get("dao.Cursos", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Curso instance) {
//		log.debug("finding Curso instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Cursos").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Curso instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Curso as model where model." + propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByTipo(Object tipo) {
//		return findByProperty(TIPO, tipo);
//	}

//	public List findByCurso(Object curso) {
//		return findByProperty(CURSO, curso);
//	}

	public List findAll() {
		log.debug("finding all Curso instances");
		try {
			String queryString = "select c from Curso c";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

//	public Curso merge(Curso detachedInstance) {
//		log.debug("merging Curso instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Curso result = (Curso) session.merge(detachedInstance);
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
//	public void attachDirty(Curso instance) {
//		log.debug("attaching dirty Curso instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Curso instance) {
//		log.debug("attaching clean Curso instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}