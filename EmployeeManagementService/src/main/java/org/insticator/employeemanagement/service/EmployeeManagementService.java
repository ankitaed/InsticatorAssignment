package org.insticator.employeemanagement.service;

import java.util.Arrays;
import java.util.List;

import org.insticator.employeemanagement.db.entities.Employee;
import org.insticator.employeemanagement.db.service.EmployeeManagementDBService;
import org.insticator.employeemanagment.service.interfaces.EmployeeManagementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeManagementService implements EmployeeManagementServiceInterface {

	@Autowired
	private EmployeeManagementDBService employeeManagementDBService;
	
	@Override
	public void createEmployee(Employee employee) {
		employeeManagementDBService.createEmployee(employee);
	}

	@Override
	public List<Employee> searchEmployee(Employee employee) {
		return Arrays.asList(employeeManagementDBService.findByEmployeeId(employee.getEmployeeId()));
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeManagementDBService.updateEmployee(employee);

	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employeeManagementDBService.deleteEmployee(employee);
	}

}
