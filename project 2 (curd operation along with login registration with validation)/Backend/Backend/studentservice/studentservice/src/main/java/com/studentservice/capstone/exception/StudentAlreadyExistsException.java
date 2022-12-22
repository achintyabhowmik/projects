package com.studentservice.capstone.exception;

public class StudentAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -2547317032607976157L;

	public StudentAlreadyExistsException(String message) {
		super(message);
	}

}