package com.thrm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thrm.domain.Candidato;
import com.thrm.domain.Curriculum;

/**
 * A data access object (DAO) providing persistence and search support for
 * Curriculum entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Curriculum.Curriculums
 * @author MyEclipse Persistence Tools
 */

public class CurriculumsDAO extends GenericDAO{

	private static final Log log = LogFactory.getLog(CurriculumsDAO.class);
	// property constants
	public static final String IDIOMA = "idioma";
	
	public void save(Curriculum transientInstance) {
		log.debug("saving Curriculum instance");
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

	public void delete(Curriculum persistentInstance) {
		log.debug("deleting Curriculum instance");
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

	public Curriculum findByKey(Key key) {
		log.debug("getting Curriculum instance with key id: " + key.getId());
		try {
			Curriculum instance = getEntityManager().find(Curriculum.class, key);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	
	public Curriculum findById(Long id) {
		log.debug("getting Curriculum instance with id: " + id);
		
		Key key = KeyFactory.createKey("Curriculum", id);
		try {

			String queryString = "select c from Curriculum c where key = ?1";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter(1, key);
			Curriculum instance = (Curriculum) query.getSingleResult();
			
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List findByExample(Curriculum instance) {
//		log.debug("finding Curriculum instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Curriculums").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Curriculum instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Curriculum as model where model." + propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByIdioma(Object idioma) {
//		return findByProperty(IDIOMA, idioma);
//	}
//
//	public List findAll() {
//		log.debug("finding all Curriculum instances");
//		try {
//			String queryString = "from Curriculum";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Curriculum merge(Curriculum detachedInstance) {
//		log.debug("merging Curriculum instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Curriculum result = (Curriculum) session.merge(detachedInstance);
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
//	public void attachDirty(Curriculum instance) {
//		log.debug("attaching dirty Curriculum instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Curriculum instance) {
//		log.debug("attaching clean Curriculum instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}