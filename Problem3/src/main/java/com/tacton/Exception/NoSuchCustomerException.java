package com.tacton.Exception;


public class NoSuchCustomerException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCustomerException(String message) {
        super(message);
    }
}
