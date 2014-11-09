package com.tacton.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	/** Method to find the object 
	 * @param propertyName - column property to be found
	 * @param value - entity for a corresponding value.
	 * @return
	 */
	List<T> find(String propertyName, Object value);
	
	/** find single result entity
	 * @param id
	 * @return
	 */
	T findSingle(Serializable id);

	/** Load method to be used to load proxy of an object.
	 * @param id
	 * @return
	 */
	T load(Serializable id);

	/**
	 * Method to either save or update an object depending on if it already
	 * exist in database or not.
	 * 
	 * @param o
	 */
	void saveOrUpdate(T o);

	/** Method to update the object of type T
	 * 
	 * @param type
	 * @return
	 */
	T update(T type);

	/** Method to save an entity of type T.
	 * @param type
	 */
	void save(T type);

	/** Method to delete an entity.
	 * @param type
	 */
	void remove(T type);
	
	void findAll(T type);

	
}
