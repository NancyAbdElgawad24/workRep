package com.etisalat.core.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Departments")
@JsonIgnoreProperties(value= {"employees"})
public class DepartmentModel implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	@Column(name = "Manager_ID")
	private Long managerId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@OneToMany(mappedBy="depertment")
	private List<EmployeeModel> employees;
	
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public List<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}
	

}
