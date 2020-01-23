package com.etisalat.core.utils;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.GenericJDBCException;


/**
 * Utility class for managing Hibernate sessions and transactions. All methods in this class are static.
 * The class must be initialized by invoking initialize().
 */
public class HibernateUtil {
	// Session factory
	private static SessionFactory sessionFactory;
	
	/**
	 * Initializes HibernateUtil session factory.
	 * @throws GeneralException
	 */
	@SuppressWarnings("deprecation")
	public static synchronized void initialize() throws GeneralException {
		if (sessionFactory == null) {
			try {
				// Log
				LogUtil.logger.info("Initializing HibernateUtil");
				
				// Configure
				Configuration configuration = new Configuration();
				configuration.configure();
				
				
				// Build session factory
				sessionFactory = configuration.buildSessionFactory();
				
				// Log
				LogUtil.logger.info("HibernateUtil Initialized Successfully");
			}
			
			catch (Exception e) {
				e.printStackTrace();
				throw processException("Error while initializing HibernateUtil", e);
			}
			catch (Throwable e) {
				e.printStackTrace();
				//throw processException("Error while initializing HibernateUtil", e.g);
			}
		}
	}
	

	/**
	 * Opens a new Hibernate session.
	 * @return
	 * @throws GeneralException
	 */
	public static Session getSession() throws GeneralException {
		try { return sessionFactory.openSession(); }

		catch (GenericJDBCException e) {
			throw new GeneralException(GeneralException.ERROR_HIBERNATE_JDBC, "Error opening Hibernate session", e);
		}
		
		catch (Exception e) {
			throw processException("Error opening Hibernate session", e);
		}
	}

	/**
	 * Closes a Hibernate session.
	 * @param session Hibernate session to be closed
	 * @throws GeneralException
	 */
	public static void closeSession(Session session) throws GeneralException {
		try { session.close(); }
		
		catch (Exception e) {
			throw processException("Error while closing Hibernate session", e);
		}
	}

	/**
	 * Begins a new Hibernate transaction.
	 * @param session Hibernate session
	 * @return Hibernate transaction
	 * @throws Exception
	 */
	public static Transaction startTransaction(Session session) throws GeneralException {
		try { return session.beginTransaction(); }
		
		catch (Exception e) {
			e.printStackTrace();
			throw processException("Error starting Hibernate transaction", e);
		}
	}

	/**
	 * Commits a Hibernate transaction.
	 * @param transaction Hibernate transaction to be committed
	 * @throws GeneralException
	 */
	public static void commitTransaction(Transaction transaction) throws GeneralException {
		try { transaction.commit(); }
		
		catch (Exception e) {
			throw processException("Error while committing Hibernate transaction", e);
		}
	}

	/**
	 * Rolls back a Hibernate transaction.
	 * @param transaction Hibernate transaction to be rolled back
	 * @throws GeneralException
	 */
	public static void rollbackTransaction(Transaction transaction) throws GeneralException {
		try { transaction.rollback(); }
		
		catch (Exception e) {
			throw processException("Error rolling back Hibernate transaction", e);
		}
	}

	/**
	 * Removes the given object from the given Hibernate session.
	 * @param session Hibernate session
	 * @param object Object to be removed
	 * @throws GeneralException
	 */
	public static void evictObject(Session session, Object object) throws GeneralException {
		try { session.evict(object); }
		
		catch (Exception e) {
			throw processException("Error evicting object from Hibernate session", e);
		}
	}
	
	public static final GeneralException processException(Exception e) {
		return processException(null, e);
	}
	
	public static final GeneralException processException(String message, Exception e) {
		// General Exception
		if (e instanceof GeneralException) {
			if (message == null) { return (GeneralException) e; }
			else { return new GeneralException(GeneralException.ERROR_UNKNOWN, message, e); }
		}
		
		// Set default message
		if (message == null) { message = "An unknown error has occurred"; }
		
		// Default error codes
		String errorCode = GeneralException.ERROR_UNKNOWN;
		
		// Hibernate error codes
		if (e instanceof GenericJDBCException) { errorCode = GeneralException.ERROR_HIBERNATE_JDBC; }
		else if (e instanceof HibernateException) { errorCode = GeneralException.ERROR_HIBERNATE_UNKNOWN; }
		
		// Done
		return new GeneralException(errorCode, message, e);
	}
}
