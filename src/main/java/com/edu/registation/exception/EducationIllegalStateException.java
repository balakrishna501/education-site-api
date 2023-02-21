package com.edu.registation.exception;
/**
 * @author Bala
 *
 */
public class EducationIllegalStateException extends IllegalStateException {
	private static final long serialVersionUID = 1L;

	public EducationIllegalStateException(String message) {
		super(message);
	}

	public EducationIllegalStateException(Throwable e) {
		super(e);
	}

}
