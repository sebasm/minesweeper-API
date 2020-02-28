package com.challenge.minesweeper.exception;

public class TooManyMinesException extends RuntimeException{
	
	private static final long serialVersionUID = -7435699145923624624L;

	public TooManyMinesException() {
		super();
	}
	
	public TooManyMinesException(String message) {
		super(message);
	}
	
	public TooManyMinesException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
