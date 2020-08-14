package com.prueba.exception;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @author hernanC <dropimax@gmail.com>
	 * @date 13/08/2020
	 */
	public CustomException(String message) {
	        super(message);
	 }
}
