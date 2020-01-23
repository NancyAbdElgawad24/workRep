package com.etisalat.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.etisalat.core.models.EmployeeModel;
import com.etisalat.core.services.AssignmentService;
import com.etisalat.core.utils.GeneralException;
import com.etisalat.core.utils.HibernateUtil;
import com.etisalat.core.utils.LogUtil;

public class ApplicationFacade {

private static final String CLASS_NAME = "com.etisalat.core.ApplicationFacade";
	
	public Long addEmployee(EmployeeModel employeeModel)throws GeneralException
	{	
		String methodName = "addEmployee";
		
		LogUtil.logger.debug("Method has been started");
		
		Long employeeId ;
		Transaction transaction = null;
		Session session = null;
		
		try 
		{
			/*---- Get Hibernate Session ----*/
			session = HibernateUtil.getSession();
			AssignmentService assignmentService = new AssignmentService();
			/* -----Start Transaction----- */
			transaction=HibernateUtil.startTransaction(session);
			/* ----  Add Employee Record--- */
			employeeId = assignmentService.addEmployee(session, employeeModel);
			/* -----Commit Transaction----- */
			HibernateUtil.commitTransaction(transaction);

		} 
		catch (GeneralException exception) 
		{
			/* -----RollBack Transaction----- */
			HibernateUtil.rollbackTransaction(transaction);
			throw exception; 
		}
		catch (Exception exception) 
		{
			/* -----RollBack Transaction----- */
			HibernateUtil.rollbackTransaction(transaction);
			throw new GeneralException(GeneralException.ERROR_UNKNOWN,"Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, exception); 
		}
		finally
		{
			/* -----Close Transaction----- */
			HibernateUtil.closeSession(session);
		}
		
		LogUtil.logger.debug("Method has been ended");
		
		return employeeId;
		
	}
	
	public void deleteEmployee(EmployeeModel employeeModel)throws GeneralException
	{	
		String methodName = "deleteEmployee";
		
		LogUtil.logger.debug("Method has been started");
		
		Transaction transaction = null;
		Session session = null;
		
		try 
		{
			/*---- Get Hibernate Session ----*/
			session = HibernateUtil.getSession();
			AssignmentService assignmentService = new AssignmentService();
			/* -----Start Transaction----- */
			transaction=HibernateUtil.startTransaction(session);
			/* ----  Add Employee Record--- */
			assignmentService.deleteEmployee(session, employeeModel);
			/* -----Commit Transaction----- */
			HibernateUtil.commitTransaction(transaction);

		} 
		catch (GeneralException exception) 
		{
			/* -----RollBack Transaction----- */
			HibernateUtil.rollbackTransaction(transaction);
			throw exception; 
		}
		catch (Exception exception) 
		{
			/* -----RollBack Transaction----- */
			HibernateUtil.rollbackTransaction(transaction);
			throw new GeneralException(GeneralException.ERROR_UNKNOWN,"Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, exception); 
		}
		finally
		{
			/* -----Close Transaction----- */
			HibernateUtil.closeSession(session);
		}
		
		LogUtil.logger.debug("Method has been ended");
		
	}
	
	public void updateEmployee(EmployeeModel employeeModel)throws GeneralException
	{	
		String methodName = "updateEmployee";
		
		LogUtil.logger.debug("Method has been started");
		
		Long employeeId ;
		Transaction transaction = null;
		Session session = null;
		
		try 
		{
			/*---- Get Hibernate Session ----*/
			session = HibernateUtil.getSession();
			AssignmentService assignmentService = new AssignmentService();
			/* -----Start Transaction----- */
			transaction=HibernateUtil.startTransaction(session);
			/* ----  Update Employee Record--- */
			assignmentService.updateEmployee(session, employeeModel);
			/* -----Commit Transaction----- */
			HibernateUtil.commitTransaction(transaction);

		} 
		catch (GeneralException exception) 
		{
			/* -----RollBack Transaction----- */
			HibernateUtil.rollbackTransaction(transaction);
			throw exception; 
		}
		catch (Exception exception) 
		{
			/* -----RollBack Transaction----- */
			HibernateUtil.rollbackTransaction(transaction);
			throw new GeneralException(GeneralException.ERROR_UNKNOWN,"Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, exception); 
		}
		finally
		{
			/* -----Close Transaction----- */
			HibernateUtil.closeSession(session);
		}
		
		LogUtil.logger.debug("Method has been ended");
		
		
	}
	
    public List<EmployeeModel> retrieveEmployeesList(Hashtable<String, String> criteria) throws GeneralException {
		String methodName = "retrieveEmployeesList";

		LogUtil.logger.debug("Method has been started");
		List<EmployeeModel> employeesList;
		Session session = null;
		
		try
		{
			session = HibernateUtil.getSession();
			AssignmentService assignmentService = new AssignmentService();
			employeesList = assignmentService.retrieveEmployeesList(session, criteria);
		} catch (GeneralException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new GeneralException(GeneralException.ERROR_UNKNOWN,
					"Unknown Error# CLASS:" + CLASS_NAME + " METHOD:"
							+ methodName, exception);
		} finally {
			/* -----Close Transaction----- */
			HibernateUtil.closeSession(session);
		}

		LogUtil.logger.debug("Method has been ended");
		
		return employeesList;
    }
	
	
	
}
