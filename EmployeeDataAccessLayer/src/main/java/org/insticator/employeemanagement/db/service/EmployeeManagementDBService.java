package org.insticator.employeemanagement.db.service;

import org.apache.commons.lang.StringUtils;
import org.insticator.employeemanagement.db.entities.Employee;
import org.insticator.employeemanagement.db.entities.EmployeeSalaryType;
import org.insticator.employeemanagement.db.entities.EmployeeType;
import org.insticator.employeemanagement.repository.EmployeeRepository;
import org.insticator.employeemanagement.repository.EmployeeSalaryTypeRepository;
import org.insticator.employeemanagement.repository.EmployeeTypeRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeManagementDBService {
	@Resource
	private EmployeeRepository employeeRepository;
	
	@Resource
	private EmployeeSalaryTypeRepository salaryTypeRepository;
	
	@Resource
	private EmployeeTypeRepository employeeTypeRepository;
	
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee findByEmployeeId(Long id) {
		return employeeRepository.findOne(id);
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeRepository.findOne(employee.getEmployeeId());
		if(updatedEmployee == null) {
			throw new IllegalArgumentException("Employee: " + employee.getEmployeeId() + " not found in DB" );
		}
		if(StringUtils.isNotEmpty(employee.getFirstName())) {
			updatedEmployee.setFirstName(employee.getFirstName());
		}
		
		if(StringUtils.isNotEmpty(employee.getLastName())) {
			updatedEmployee.setLastName(employee.getLastName());
		}
		if(employee.getEmployeeSalaryType() != null) {
			EmployeeSalaryType employeeSalaryType = salaryTypeRepository.findOne(employee.getEmployeeSalaryType().getSalaryTypeId());
			if(employeeSalaryType != null) {
				updatedEmployee.setEmployeeSalaryType(employeeSalaryType);
			}
		}
		
		if(employee.getEmployeeSalaryType() != null) {
			EmployeeType employeeType = employeeTypeRepository.findOne(employee.getEmployeeType().getEmployeeTypeId());
			if(employeeType != null) {
				updatedEmployee.setEmployeeType(employeeType);
			}
		}
		
		employeeRepository.save(updatedEmployee);
		return updatedEmployee;
	}
	
	public Employee deleteEmployee(Employee employee) {
		if(employee.getEmployeeId() == null) {
			Employee savedEmployee = employeeRepository.findOne(employee.getEmployeeId());
			if(savedEmployee != null) {
				employeeRepository.delete(savedEmployee);
			} else {
				throw new IllegalArgumentException("Employee: " + employee.getEmployeeId() + " not found in DB");
			}
			return savedEmployee;
		} else {
			throw new IllegalArgumentException("Cannot delete as employee id is null");
		}
		
	}
}
