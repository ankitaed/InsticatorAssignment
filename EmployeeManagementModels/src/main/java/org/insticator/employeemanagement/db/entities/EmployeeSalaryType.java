package org.insticator.employeemanagement.db.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
/**
 * This table corresponds to employee_salary_type table in database
 * @author Ankita
 *
 */

@Entity
@Table(name="employee_salary_type")
public class EmployeeSalaryType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="salary_type_id")
	private Long salaryTypeId;
	
	@Column(name="type_name")
	private String typeName;

	public Long getSalaryTypeId() {
		return salaryTypeId;
	}

	public void setSalaryTypeId(Long salaryTypeId) {
		this.salaryTypeId = salaryTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
