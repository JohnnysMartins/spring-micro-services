package br.com.app.microservices.currencyexchangeservice.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private String excetionName;
	private LocalDateTime timestamp;
	private String message;
	private String detail;
	
	public ExceptionResponse(String excetionName, LocalDateTime timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.excetionName = excetionName;
		this.message = message;
		this.detail = detail;
	}
	
	public String getExcetionName() {
		return excetionName;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getDetail() {
		return detail;
	}	
}
