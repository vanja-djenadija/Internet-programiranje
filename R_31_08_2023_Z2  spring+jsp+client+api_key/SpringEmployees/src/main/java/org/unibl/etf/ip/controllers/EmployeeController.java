package org.unibl.etf.ip.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unibl.etf.ip.models.entities.Employee;
import org.unibl.etf.ip.models.entities.requests.DateRangeRequest;
import org.unibl.etf.ip.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public @ResponseBody Iterable<Employee> getAll() {
		return service.getAll();
	}
	
	// a
	@GetMapping("/{jobId}")
	public @ResponseBody List<Map.Entry<Integer, List<Employee>>> getAllByJobId(@PathVariable String jobId){
		return service.getAllByJobIdGroupedByDepartment(jobId);
	}
	
	
	// b
	@GetMapping("/salary/{salary}")
	public @ResponseBody List<Employee> getAllBySalary(@PathVariable Double salary){
		return service.getAllBySalaryLessThan(salary);
	}
	
	// f
	@PostMapping("/hired")
	public @ResponseBody List<Employee> getAllBetweenHireDates(@RequestBody DateRangeRequest request){
		return service.getAllBetweenHireDates(request);
	}
	
	// g
	@PutMapping("/{employeeId}")
	public @ResponseBody Employee update(@PathVariable Integer employeeId, @RequestBody Employee request) throws NotFoundException {
		return service.update(employeeId, request);
	}
}
