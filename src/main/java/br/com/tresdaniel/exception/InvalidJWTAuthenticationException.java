package br.com.tresdaniel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJWTAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public InvalidJWTAuthenticationException(String exception) {
		super(exception);
	}
}
