package com.tacton.util;

import java.lang.reflect.ParameterizedType;

/** Provides access to class-related utility operations. */
public final class ClassUtil {

	/**
	 * Constructor.
	 */
	private ClassUtil() {
		// private constructor for utility class
	}

	/**
	 * @param <T>
	 *            the type of the class
	 * @param targetClass
	 *            the requested target class
	 * @return the generic type of {@code targetClass}
	 * @throws IllegalArgumentException
	 *             if the underlying parameterized class could not be inferred
	 *             via reflection.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getEntityClass(final Class<?> targetClass)
			throws IllegalArgumentException {
		return	 (Class<T>)	((ParameterizedType) targetClass.getGenericSuperclass())
			.getActualTypeArguments()[0];
	}
}
