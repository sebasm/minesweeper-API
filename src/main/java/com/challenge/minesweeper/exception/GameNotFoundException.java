package com.challenge.minesweeper.exception;

public class GameNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3450120522867245515L;

	public GameNotFoundException() {
		super();
	}
	
	public GameNotFoundException(String message) {
		super(message);
	}
	
	public GameNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
