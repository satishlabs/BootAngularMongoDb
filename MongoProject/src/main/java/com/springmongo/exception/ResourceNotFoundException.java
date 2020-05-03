package com.springmongo.exception;

public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messgae;
	public ResourceNotFoundException(String messgae){
		this.messgae = messgae;
	}
}
