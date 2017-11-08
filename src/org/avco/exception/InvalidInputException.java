package org.avco.exception;

public class InvalidInputException extends Exception{

	private String errorCode;
	
	public InvalidInputException(String msg, String errorCode){
		super(msg);
		this.errorCode = errorCode;
	}
	
	public String getMessage(){
		return this.errorCode +":"+ super.getMessage();
	}
}
