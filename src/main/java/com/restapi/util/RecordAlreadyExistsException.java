package com.restapi.util;

public class RecordAlreadyExistsException  extends Exception{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return this.toString();
	}
	
	public String toString() {
		return "Record Already there with given cno";
	}
}
