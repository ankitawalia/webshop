package com.tacton.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tacton.dao.Dao;


/**
 * Abstract base implementation of {@link Dao}.
 * Provides default implementation of commonly used methods for database operations.
 * 
 * @param <T>
 *            the underlying entity type.
 */
public abstract class AbstractBaseDaoImpl<T> extends AbstractHibernateDaoImpl<T> {

	/** The underlying entity manager. */
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager em() {
		return em;
	}

	/** Default constructor. */
	public AbstractBaseDaoImpl() {
	}

}
