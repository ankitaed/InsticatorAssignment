package org.insticator.employeemanagement.repository;

import org.insticator.employeemanagement.db.entities.EmployeeSalaryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSalaryTypeRepository extends CrudRepository<EmployeeSalaryType, Long> {
	
}
