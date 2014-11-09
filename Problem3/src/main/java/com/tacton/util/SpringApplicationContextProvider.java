package com.tacton.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The singleton class to load the {@link ApplicationContext}. The class is
 * responsible to create all required beans as per definition in app-context.xml
 * 
 * 
 * @version 1.0
 */
public final class SpringApplicationContextProvider {

	/**
	 * The private constructor for ApplicationContextProvider class.
	 */
	private SpringApplicationContextProvider() {
	}

	/** The spring application context. */
	private static ApplicationContext applicationContext;

	/**
	 * The synchronized method to access application context.
	 * 
	 * @return - application context.
	 */
	public static  ApplicationContext getInstance() {
		synchronized (SpringApplicationContextProvider.class) {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext(
					new String[] { "META-INF/app-context.xml" });
		}
		}
		return (ApplicationContext) applicationContext;
	}

	/**
	 * Gets the application context.
	 * 
	 * @return - the application context
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
