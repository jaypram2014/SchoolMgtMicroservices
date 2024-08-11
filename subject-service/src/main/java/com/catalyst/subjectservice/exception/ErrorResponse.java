package com.catalyst.subjectservice.exception;

public class ErrorResponse {
    	
	private String errorMessage;
    private int status;
    
    
    public ErrorResponse(String errorMessage, int status) {
		super();
		this.errorMessage = errorMessage;
		this.status = status;
	}
    
    
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
    
}
