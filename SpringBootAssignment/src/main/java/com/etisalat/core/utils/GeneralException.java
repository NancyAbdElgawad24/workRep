package com.etisalat.core.utils;

public class GeneralException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	// Error code
	private String errorCode;
	
	// General error codes
	public static final String ERROR_UNKNOWN				= "APP0001";
	public static final String ERROR_LOGIN_FAILED			= "APP0002";
	public static final String ERROR_USER_LOCKED			= "APP0003";
	public static final String ERROR_USER_LOGGED_IN			= "APP0004";
	
	// Log errors
	public static final String ERROR_LOG_UNKNOWN			= "LOG0001";
	
	// Hibernate errors
	public static final String ERROR_HIBERNATE_JDBC					= "HIB0001";
	public static final String ERROR_HIBERNATE_UNKNOWN				= "HIB0002";
	public static final String ERROR_HIBERNATE_CONNECTION_CLOSED	= "HIB0003";
	
	// Mail errors
	public static final String ERROR_MAIL_UNKNOWN			= "Mail0001";
	
	// SMS errors
	public static final String ERROR_SMS_UNKNOWN			= "SMS0001";

	public GeneralException(String errorCode, String message, Throwable cause) {
		// Invoke super constructor
		super(message, cause);
		
		// Set error code
		this.errorCode = errorCode;
		
		// Log exception
		LogUtil.logger.error(String.format("%s: %s", errorCode, message));
		LogUtil.logger.error(this);
	}
	
	public GeneralException(String errorCode, String message) {
		// Invoke super constructor
		super(message);
		
		// Set error code
		this.errorCode = errorCode;
		
		// Log exception
		LogUtil.logger.error(String.format("%s: %s", errorCode, message));
		LogUtil.logger.error(this);
	}
	
	public String getErrorCode() {
		return errorCode;
	}

}
