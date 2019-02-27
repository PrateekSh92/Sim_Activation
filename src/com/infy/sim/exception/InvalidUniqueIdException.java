package com.infy.sim.exception;

@SuppressWarnings("serial")
public class InvalidUniqueIdException extends Exception{

	public InvalidUniqueIdException(String message) {
		super(message);
		System.out.println("exception assign kr diya " + message);
	}

}
