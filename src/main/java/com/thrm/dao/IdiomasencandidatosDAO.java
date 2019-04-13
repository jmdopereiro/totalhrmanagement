package com.thrm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Key;
import com.thrm.domain.IdiomaEnCandidato;

/**
 * A data access object (DAO) providing persistence and search support for
 * IdiomaEnCandidato entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see IdiomaEnCandidato.Idiomasencandidatos
 * @author MyEclipse Persistence Tools
 */

public class IdiomasencandidatosDAO {

	private static final Log log = LogFactory.getLog(IdiomasencandidatosDAO.class);
	// property constants
	public static final String ESCRITO = "escrito";
	public static final String HABLADO = "hablado";
	public static final String TRADUCCION = "traduccion";
	public static final String TECNICO = "tecnico";
	
	private EntityManager entityManager; 

	public void save(IdiomaEnCandidato transientInstance) {
		log.debug("saving IdiomaEnCandidato instance");
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

	public void delete(IdiomaEnCandidato persistentInstance) {
		log.debug("deleting IdiomaEnCandidato instance");
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
	
	public IdiomaEnCandidato findByKey(Key key) {
		log.debug("getting IdiomaEnCandidato instance with id: " + key.getId());
		try {
			String queryString = "select i from IdiomaEnCandidato i where key = ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1, key);
			return (IdiomaEnCandidato) queryObject.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
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

//	public IdiomaEnCandidato findById(java.lang.Integer id) {
//		log.debug("getting IdiomaEnCandidato instance with id: " + id);
//		try {
//			IdiomaEnCandidato instance = (IdiomaEnCandidato) getSession().get("dao.Idiomasencandidatos", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}

//	public List findByExample(IdiomaEnCandidato instance) {
//		log.debug("finding IdiomaEnCandidato instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Idiomasencandidatos").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding IdiomaEnCandidato instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from IdiomaEnCandidato as model where model." + propertyName + "= ?";
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
//		log.debug("finding all IdiomaEnCandidato instances");
//		try {
//			String queryString = "from IdiomaEnCandidato";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public IdiomaEnCandidato merge(IdiomaEnCandidato detachedInstance) {
//		log.debug("merging IdiomaEnCandidato instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			IdiomaEnCandidato result = (IdiomaEnCandidato) session.merge(detachedInstance);
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
//	public void attachDirty(IdiomaEnCandidato instance) {
//		log.debug("attaching dirty IdiomaEnCandidato instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(IdiomaEnCandidato instance) {
//		log.debug("attaching clean IdiomaEnCandidato instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}