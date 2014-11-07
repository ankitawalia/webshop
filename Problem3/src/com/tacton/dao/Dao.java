package com.tacton.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {


	List<T> find(String propertyName, Object value);

	T load(Serializable id);

	//void save(T o);

	void saveOrUpdate(T o);

	
}
