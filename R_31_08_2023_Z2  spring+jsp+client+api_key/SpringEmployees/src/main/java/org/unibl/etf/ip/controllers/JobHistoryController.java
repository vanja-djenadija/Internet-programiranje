package org.unibl.etf.ip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unibl.etf.ip.models.entities.JobHistory;
import org.unibl.etf.ip.services.JobHistoryService;

@Controller
@RequestMapping("/job-history")
public class JobHistoryController {

	
	@Autowired
	private JobHistoryService service;
	
	// e
	@GetMapping("/{employeeId}")
	public @ResponseBody List<JobHistory> getAllByEmployee(@PathVariable Integer employeeId){
		return service.getAllByEmployee(employeeId);
	}
}
