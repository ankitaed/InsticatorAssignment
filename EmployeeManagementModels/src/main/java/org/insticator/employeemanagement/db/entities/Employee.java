package org.insticator.employeemanagement.db.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private EmployeeSalaryType employeeSalaryType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private EmployeeType employeeType;
	
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

	public EmployeeSalaryType getEmployeeSalaryType() {
		return employeeSalaryType;
	}

	public void setEmployeeSalaryType(EmployeeSalaryType employeeSalaryType) {
		this.employeeSalaryType = employeeSalaryType;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
}
