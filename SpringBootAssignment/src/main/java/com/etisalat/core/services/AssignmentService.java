package com.etisalat.core.services;

import java.util.Hashtable;
import java.util.List;

import org.hibernate.Session;

import com.etisalat.core.constants.ErrorCodes;
import com.etisalat.core.daos.AssignmentDAO;
import com.etisalat.core.models.EmployeeModel;
import com.etisalat.core.utils.GeneralException;
import com.etisalat.core.utils.LogUtil;

public class AssignmentService {
	
	private static final String CLASS_NAME = "com.asset.vacancies.core.services.VacanciesService";
	
	public Long addEmployee(Session session, EmployeeModel employeeModel) throws GeneralException
	{
		String methodName = "addEmployee";
		
		LogUtil.logger.debug("Method has been started");
		
		/*Check if employee first name is empty */
		if(employeeModel.getFirstName().equals(null) || employeeModel.getFirstName().equals(""))
			throw new GeneralException(ErrorCodes.EMPLOYEE_FIRST_NAME_IS_NULL, "Employee First Name Empty# CLASS:" + CLASS_NAME + " METHOD:" + methodName);  
		
		/*Check if employee last name is empty */
		if(employeeModel.getLastName().equals(null) || employeeModel.getLastName().equals(""))
			throw new GeneralException(ErrorCodes.EMPLOYEE_LAST_NAME_IS_NULL, "Employee Last Name Empty# CLASS:" + CLASS_NAME + " METHOD:" + methodName);  
		
		/*Add Employee Model*/
		Long employeeId = AssignmentDAO.addEmployee(session, employeeModel);
		
		LogUtil.logger.debug("Method has been ended");
		
		return employeeId;
	}
	
	public void updateEmployee(Session session, EmployeeModel employeeModel) throws GeneralException
	{
		String methodName = "updateEmployee";
		
		LogUtil.logger.debug("Method has been started");
		
		/*Check if employee first name is empty */
		if(employeeModel.getFirstName().equals(null) || employeeModel.getFirstName().equals(""))
			throw new GeneralException(ErrorCodes.EMPLOYEE_FIRST_NAME_IS_NULL, "Employee First Name Empty# CLASS:" + CLASS_NAME + " METHOD:" + methodName);  
		
		/*Check if employee last name is empty */
		if(employeeModel.getLastName().equals(null) || employeeModel.getLastName().equals(""))
			throw new GeneralException(ErrorCodes.EMPLOYEE_LAST_NAME_IS_NULL, "Employee Last Name Empty# CLASS:" + CLASS_NAME + " METHOD:" + methodName);  
		
		/*update Employee Model*/
		AssignmentDAO.updateEmployee(session, employeeModel);
		
		LogUtil.logger.debug("Method has been ended");
		
	}
	
	public void deleteEmployee(Session session, EmployeeModel employeeModel) throws GeneralException
	{
		String methodName = "deleteEmployee";
		
		LogUtil.logger.debug("Method "+methodName+" has been started");
		
		/*delete Employee Model*/
		AssignmentDAO.deleteEmployee(session, employeeModel);
		
		LogUtil.logger.debug("Method "+methodName+" has been ended");
		
	}
	
	public List<EmployeeModel> retrieveEmployeesList(Session session, Hashtable<String, String> criteria)throws GeneralException
	{
		LogUtil.logger.debug("Method has been started");
		
		List<EmployeeModel> testsList = AssignmentDAO.retrieveEmployeesList(session, criteria);
		
		LogUtil.logger.debug("Method has been ended");
		
		return testsList;
	}
	
	

}
