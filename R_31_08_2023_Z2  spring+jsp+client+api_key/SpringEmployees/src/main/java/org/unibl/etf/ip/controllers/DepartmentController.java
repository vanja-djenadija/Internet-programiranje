package org.unibl.etf.ip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unibl.etf.ip.models.entities.Department;
import org.unibl.etf.ip.services.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	// d
	@GetMapping("/{locationId}")
	public @ResponseBody List<Department> getAllByLocation(@PathVariable Integer locationId) {
		return service.getAllByLocation(locationId);
	}
}
