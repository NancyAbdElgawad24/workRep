package com.etisalat.core.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")

public class EmployeeModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name = "empSeqGen", sequenceName = "empSeq")
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "SALARY")
	private String salary;

	@Column(name = "HIRE_DATE")
	private Date hireDate;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private DepartmentModel depertment;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public DepartmentModel getDepertment() {
		return depertment;
	}

	public void setDepertment(DepartmentModel depertment) {
		this.depertment = depertment;
	}
	
	

}
