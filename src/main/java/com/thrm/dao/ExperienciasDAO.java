package com.thrm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Key;
import com.thrm.domain.Experiencia;

/**
 * A data access object (DAO) providing persistence and search support for
 * Experiencia entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Experiencia.Experiencias
 * @author MyEclipse Persistence Tools
 */

public class ExperienciasDAO extends GenericDAO {

	private static final Log log = LogFactory.getLog(ExperienciasDAO.class);
	// property constants
	public static final String TIPO = "tipo";
	public static final String PUESTOTRABAJO = "puestotrabajo";
	public static final String EMPRESA = "empresa";
	public static final String DEPARTAMENTO = "departamento";
	public static final String ANNOINICIO = "annoinicio";
	public static final String ANNOFIN = "annofin";
	public static final String DURACION = "duracion";
	
	public void save(Experiencia transientInstance) {
		log.debug("saving Experiencia instance");
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

	public void delete(Experiencia persistentInstance) {
		log.debug("deleting Experiencia instance");
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

	public Experiencia findByKey(Key key) {
		log.debug("getting Experiencia instance with id: " + key.getId());
		try {
			String queryString = "select i from Experiencia i where key = ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1, key);
			return (Experiencia) queryObject.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public Experiencia findById(java.lang.Integer id) {
//		log.debug("getting Experiencia instance with id: " + id);
//		try {
//			Experiencia instance = (Experiencia) getSession().get("dao.Experiencias", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Experiencia instance) {
//		log.debug("finding Experiencia instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Experiencias").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Experiencia instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Experiencia as model where model." + propertyName + "= ?";
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
//
//	public List findByPuestotrabajo(Object puestotrabajo) {
//		return findByProperty(PUESTOTRABAJO, puestotrabajo);
//	}
//
//	public List findByEmpresa(Object empresa) {
//		return findByProperty(EMPRESA, empresa);
//	}
//
//	public List findByDepartamento(Object departamento) {
//		return findByProperty(DEPARTAMENTO, departamento);
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
//	public List findByDuracion(Object duracion) {
//		return findByProperty(DURACION, duracion);
//	}
//
//	public List findAll() {
//		log.debug("finding all Experiencia instances");
//		try {
//			String queryString = "from Experiencia";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Experiencia merge(Experiencia detachedInstance) {
//		log.debug("merging Experiencia instance");
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction tx = session.beginTransaction();
//			tx.begin();
//
//			Experiencia result = (Experiencia) session.merge(detachedInstance);
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
//	public void attachDirty(Experiencia instance) {
//		log.debug("attaching dirty Experiencia instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Experiencia instance) {
//		log.debug("attaching clean Experiencia instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}