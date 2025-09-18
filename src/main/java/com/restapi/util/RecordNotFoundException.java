package com.restapi.util;

public class RecordNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return this.toString();
	}
	
	public String toString() {
		return "Record with the given ID doesnot exist";
	}
	
}
