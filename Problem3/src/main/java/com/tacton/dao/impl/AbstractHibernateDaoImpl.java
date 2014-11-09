package com.tacton.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.tacton.dao.Dao;
import com.tacton.util.ClassUtil;


/**
 * Abstract base implementation of {@link Dao}.
 * Provides default implementation of commonly used methods for database operations.
 * 
 * @param <T>
 *            the underlying entity type.
 */
public abstract class AbstractHibernateDaoImpl<T> implements Dao<T> {

	
	/** The logger for logging messages. **/
	private static Logger logger = Logger
			.getLogger(AbstractHibernateDaoImpl.class);

	/** Named query string for the find query.
	 */
	private String namedQueryString;
	
	/**
	 * entityClass.
	 */
	private Class<? extends T> entityClass;

	/**
	 * Abstract method to be implemented by {@link AbstractBaseDaoImpl} as we
	 * are using em as persistent provider
	 * @return Entity manager instance
	 */
	protected abstract EntityManager em();

	/** Default constructor. */
	public AbstractHibernateDaoImpl() {
	}
	
	/**
	 * This can be overridden, if used with caution.
	 * 
	 * @return the underlying entity class
	 */
	protected final Class<? extends T> getEntityClass() {
		if (this.entityClass == null) {
			this.entityClass = ClassUtil.getEntityClass(this.getClass());
		}
		return this.entityClass;
	}
	
	/*
	 * @see se.paxport.airshop.dao.Dao#find(java.lang.String, java.lang.Object)
	 * Method to find the entity. Queries are cached so as to take advantage of
	 * Hibernate 2nd level cache
	 */
	@Override
	public final List<T> find(final String propertyName, final Object value) {
		logger.debug("Finding " + propertyName + " with value " + value);
		List<T> products = getHibernateSession()
				.getNamedQuery(this.getNamedQueryString()).setCacheable(true)
				.setString(propertyName, value.toString()).list();

		return products;
	}

	@Override
	public T findSingle(Serializable id) {
		return em().find(getEntityClass(), id);
	}
	
	@Override
	public final T load(final Serializable id) {
		return (T) getHibernateSession().load(this.getClass(), id);
	}

	@Override
	public final void saveOrUpdate(final T objectToSave) {
		getHibernateSession().saveOrUpdate(objectToSave);
	}
	
	@Override
    public void save(final T type) {
        em().persist(type);
    }

    @Override
    public T update(final T type) {
        return em().merge(type);
    }

    @Override
    public void remove(final T type) {
        em().remove(type);
    }

	/**
	 * @return the hibernate session
	 */
	public Session getHibernateSession() {
		return em().unwrap(Session.class);
	}
	
	/**
	 * @return the named query String
	 */
	protected String getNamedQueryString() {
		return namedQueryString;
	}

	/**
	 * @param namedQueryString
	 */
	public void setNamedQueryString(final String namedQueryString) {
		this.namedQueryString = namedQueryString;
	}
	
	@Override
	public void findAll(T type) {
		
	}
	
	public Criteria getCriteria(Class<T> clazz) {
		return getHibernateSession().createCriteria(clazz);
	}

}
