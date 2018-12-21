package br.com.app.microservices.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExchangeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -8998200344511631943L;

	public ExchangeNotFoundException(String message) {
		super(message);
	}

}
