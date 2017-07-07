package org.insticator.employeemanagment.service.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.insticator.employeemanagement.db.entities.Employee;

@Path("/employee")
@Consumes("")
@Produces("")
public interface EmployeeManagementServiceInterface {
	
	@POST
	public void createEmployee(Employee employee);
	
	@GET
	public void searchEmployee(Employee employee);
	
	@PUT
	public void updateEmployee(Employee employee);
	
	@DELETE
	@Path("/{employeeId}")
	public void deleteEmployee();
}
