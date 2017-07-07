package org.insticator.employeemanagement.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This entity corresponds to employee_type table in database
 * @author Ankita
 *
 */
@Data
@Entity
@Table(name="employee_type")
public class EmployeeType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_type_id")
	private Long employeeTypeId;
	
	@Column(name="type_name")
	private String typeName;
}
