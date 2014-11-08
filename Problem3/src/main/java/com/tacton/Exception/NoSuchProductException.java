package com.tacton.Exception;


public class NoSuchProductException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchProductException(String message) {
        super(message);
    }
}
