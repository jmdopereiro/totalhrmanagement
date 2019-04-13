package com.thrm.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.transaction.annotation.Transactional;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thrm.domain.Empresa;

/**
 * A data access object (DAO) providing persistence and search support for
 * Empresa entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Empresa
 * @author MyEclipse Persistence Tools
 */

public class EmpresasDAO extends GenericDAO {

	private static final Log log = LogFactory.getLog(EmpresasDAO.class);
	// property constants
	public static final String CIF = "cif";
	public static final String NOMBRE = "nombre";
	public static final String TIPOSOCIEDAD = "tiposociedad";
	public static final String DOMICILIO = "domicilio";
	public static final String NUMTRABAJADORES = "numtrabajadores";
	public static final String WEB = "web";
	public static final String CODIGO = "codigo";
	
	/** This will result in the object being persisted into the datastore, 
	 * though clearly it will not be persistent until you commit the transaction. 
	 * The LifecycleState of the object changes from Transient to PersistentClean (after persist()), to Hollow (at commit).
	 * @param empresa
	 */
	public void save(Empresa empresa) {
		log.debug("saving Empresa instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(empresa);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Empresa empresa) {
		log.debug("deleting Empresa instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().remove(empresa);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Empresa findById(java.lang.Long id) {
		log.debug("getting Empresa instance with id: " + id);
		Key key = KeyFactory.createKey("Empresa", id);
		try {
			String queryString = "select e from Empresa e where key = ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1,	key);
			return (Empresa) queryObject.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List findByExample(Empresa instance) {
//		log.debug("finding Empresa instance by example");
//		try {
//			List results = getSession().createCriteria("dao.Empresas").add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Empresa instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "select e from Empresa e where " + propertyName + "= ?1";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setParameter(1, value);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Empresa> findByCif(Object cif) {
		return findByProperty(CIF, cif);
	}

	public List findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

//	public List findByTiposociedad(Object tiposociedad) {
//		return findByProperty(TIPOSOCIEDAD, tiposociedad);
//	}
//
//	public List findByDomicilio(Object domicilio) {
//		return findByProperty(DOMICILIO, domicilio);
//	}
//
//	public List findByNumtrabajadores(Object numtrabajadores) {
//		return findByProperty(NUMTRABAJADORES, numtrabajadores);
//	}
//
//	public List findByWeb(Object web) {
//		return findByProperty(WEB, web);
//	}
//
//	public List findByCodigo(Object codigo) {
//		return findByProperty(CODIGO, codigo);
//	}

	public List findAll() {
		log.debug("finding all Empresa instances");
		try {
			String queryString = "select e from Empresa e";
			Query queryObject = getEntityManager().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findLastFive() {
		log.debug("finding last five Empresa instances");
		try {
			String queryString = "select e from Empresa e order by key desc";
			Query queryObject = getEntityManager().createQuery(queryString);
			queryObject.setMaxResults(5);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find last five failed", re);
			throw re;
		}
	}

	public Empresa merge(Empresa detachedInstance) {
		log.debug("merging Empresa instance");
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();

			Empresa result = (Empresa) getEntityManager().merge(detachedInstance);

			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

//	public void attachDirty(Empresa instance) {
//		log.debug("attaching dirty Empresa instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Empresa instance) {
//		log.debug("attaching clean Empresa instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}