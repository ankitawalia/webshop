package com.tacton.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.tacton.dao.Dao;


/**
 * Abstract base implementation of {@link Dao}.
 * Provides default implementation of commonly used methods for database operations.
 * 
 * @param <T>
 *            the underlying entity type.
 */
public abstract class AbstractHibernateDaoImpl<T> implements Dao<T> {

	
	/** The logger for logging messages. **/
	private static Logger logger = Logger.getLogger(
			AbstractHibernateDaoImpl.class);
	
	/**
	 * Abstract method to be implemented by BaseDao as we are using em as
	 * persistent provider
	 */
	protected abstract EntityManager em();

	/** Default constructor. */
	public AbstractHibernateDaoImpl() {
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String propertyName, Object value) {
		List<T> products = getHibernateSession()
				.getNamedQuery(this.getNamedQueryString()).setCacheable(true)
				.setString(propertyName, value.toString()).list();
		logger.info("Instance" + value.toString() +"found");
		return products;
	}

	protected String getNamedQueryString(){
		return "";
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Serializable id) {
		return (T)getHibernateSession().load(this.getClass(), id);
	}

	@Override
	public void saveOrUpdate(T o) {
		 getHibernateSession().saveOrUpdate(o);
	}


	/**
	 * @return the hibernate session
	 */
	private Session getHibernateSession() {
		return em().unwrap(Session.class);
	}

}
