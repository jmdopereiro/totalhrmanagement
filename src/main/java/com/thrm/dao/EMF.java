package com.thrm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
	
	private static EntityManager entityManager;

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	
	private EMF() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}

	public static EntityManager getEntityManager(){
		if(entityManager != null){
			return entityManager;
		}
		entityManager = get().createEntityManager();
		return entityManager;
	}
}
