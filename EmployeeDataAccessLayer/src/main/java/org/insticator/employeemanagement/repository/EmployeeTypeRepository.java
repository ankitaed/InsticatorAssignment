package org.insticator.employeemanagement.repository;

import org.insticator.employeemanagement.db.entities.EmployeeType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Long> {

}
