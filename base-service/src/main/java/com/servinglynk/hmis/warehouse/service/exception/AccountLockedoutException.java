package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountLockedoutException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account is locked";

		super(DEFAULT_MESSAGE);
	}

	public AccountLockedoutException(String message) {
		super(message);
	}

	public AccountLockedoutException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountLockedoutException(String message, Throwable cause) {
		super(message, cause);
	}
}