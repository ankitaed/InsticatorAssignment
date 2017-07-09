package org.insticator.employeemanagment.service.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.insticator.employeemanagement.db.entities.Employee;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeManagementServiceInterface {
	
	@POST
	public void createEmployee(Employee employee);
	
	@GET
	public List<Employee> searchEmployee(Employee employee);
	
	@PUT
	public void updateEmployee(Employee employee);
	
	@DELETE
	@Path("/{employeeId}")
	public void deleteEmployee(@PathParam("employeeId") Long employeeId);
}
