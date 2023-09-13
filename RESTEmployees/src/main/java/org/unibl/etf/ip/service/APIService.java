package org.unibl.etf.ip.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.unibl.etf.ip.dto.Employee;

@Path("/employees")
public class APIService {

	private EmployeeService service; 
	
	public APIService() {
		service = new EmployeeService();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Employee> getAll() {
		return service.getAll();
	}
}
