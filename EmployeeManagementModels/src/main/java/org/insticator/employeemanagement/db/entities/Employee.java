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

@Data
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
}
