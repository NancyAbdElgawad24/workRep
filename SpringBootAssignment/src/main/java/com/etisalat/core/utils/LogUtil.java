package com.etisalat.core.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
	// Logging configuration keys
		public static final String KEY_LOG_FILE_PATH = "LOG_FILE_PATH";
		
		// Default logging configuration
		public static final String DEFAULT_LOG_FILE_PATH = "/assignment.log";
		
		// File path property
		public static final String LOG_FILE_PATH = "log4j.appender.file.File";
			
			// Log4J logger
		public static Logger logger;
		
		/**
		 * Initializes the logging class. Requires the path of the log file.
		 * @param logFilePath Path of log file
		 */
		public static void initialize() throws GeneralException {
			try {
				
                PropertyConfigurator.configure("log.lcf");
                logger = Logger.getLogger("assignmentDebugLogger");
				
				// Log
				System.out.println("LogUtil Initialized Successfully");
			}
			
			catch (Exception e) {
				throw new GeneralException(GeneralException.ERROR_LOG_UNKNOWN, "Error while initializing LogUtil", e);
			}
		}
		
		
}
