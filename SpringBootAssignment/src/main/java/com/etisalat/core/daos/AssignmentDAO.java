package com.etisalat.core.daos;

import java.util.Hashtable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Session;

import com.etisalat.core.models.EmployeeModel;
import com.etisalat.core.utils.GeneralException;
import com.etisalat.core.utils.LogUtil;
import com.etisalat.core.constants.Constants;

public class AssignmentDAO {

	private static final String CLASS_NAME = "com.etisalat.core.daos.AssignmentDAO";
	
	public static Long addEmployee(Session session, EmployeeModel employeeModel)throws GeneralException
	{
		String methodName = "addEmployee";
		
		LogUtil.logger.debug("Method has been started");
		
		Long employeeId = null ;
		
		try 
		{
			employeeId = (Long)session.save(employeeModel);
		}
		catch (JDBCException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_JDBC, "Database Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e.getSQLException());    
        }
        catch (HibernateException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_UNKNOWN, "Hibernate Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        catch (Exception e)
        {
        	throw new GeneralException(GeneralException.ERROR_UNKNOWN, "Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        
		LogUtil.logger.debug("Method has been ended");
        
		return employeeId;
	}
	
	public static void updateEmployee(Session session, EmployeeModel employeeModel)throws GeneralException
	{
		String methodName = "updateEmployee";
		
		LogUtil.logger.debug("Method has been started");
		try
		{
			session.update(employeeModel);
			
		}
		catch (JDBCException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_JDBC, "Database Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e.getSQLException());    
        }
        catch (HibernateException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_UNKNOWN, "Hibernate Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        catch (Exception e)
        {
        	throw new GeneralException(GeneralException.ERROR_UNKNOWN, "Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        
		LogUtil.logger.debug("Method has been ended");
	}
	
	
	public static void deleteEmployee(Session session, EmployeeModel employeeModel)throws GeneralException
	{	
		String methodName = "deleteEmployee";
		
		LogUtil.logger.debug("Method has been started");
		try
		{
			session.delete(employeeModel);	
	        
		}
		catch (JDBCException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_JDBC, "Database Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e.getSQLException());    
        }
        catch (HibernateException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_UNKNOWN, "Hibernate Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        catch (Exception e)
        {
        	throw new GeneralException(GeneralException.ERROR_UNKNOWN, "Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        
		LogUtil.logger.debug("Method has been ended");
		
	}
	
	public static List<EmployeeModel> retrieveEmployeesList(Session session, Hashtable<String, String> criteria)throws GeneralException
	{
		String methodName = "retrieveEmployeesList";
		
		LogUtil.logger.debug("Method has been started");
		
		List<EmployeeModel> employessList ;
		try
		{
			Criteria hibernateCriteria = session.createCriteria(EmployeeModel.class.getName());
			if(criteria != null ) {
				if(criteria.get(Constants.FIRST_INDEX) != null && criteria.get(Constants.FIRST_INDEX) != "")
				{
					hibernateCriteria.setFirstResult(Integer.valueOf(criteria.get(Constants.FIRST_INDEX)));
				}
				if(criteria.get(Constants.MAX_INDEX) != null && criteria.get(Constants.MAX_INDEX) != "")
				{
					hibernateCriteria.setMaxResults(Integer.valueOf(criteria.get(Constants.MAX_INDEX)));
				}
			}
			
			employessList = hibernateCriteria.list();
		}
		catch (JDBCException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_JDBC, "Database Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e.getSQLException());    
        }
        catch (HibernateException e)
        {
        	throw new GeneralException(GeneralException.ERROR_HIBERNATE_UNKNOWN, "Hibernate Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        catch (Exception e)
        {
        	throw new GeneralException(GeneralException.ERROR_UNKNOWN, "Unknown Error# CLASS:" + CLASS_NAME + " METHOD:" + methodName, e);     
        }
        
        LogUtil.logger.debug("Method has been ended");
        
		return employessList;
	}

}
