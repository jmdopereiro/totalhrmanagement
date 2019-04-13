package com.thrm.dao;

import javax.mail.Session;

/**
 * Data access interface for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO {

	public Session getSession();
}