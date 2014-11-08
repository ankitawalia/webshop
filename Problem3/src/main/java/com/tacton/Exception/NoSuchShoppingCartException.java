package com.tacton.Exception;


public class NoSuchShoppingCartException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchShoppingCartException(String message) {
        super(message);
    }
}
