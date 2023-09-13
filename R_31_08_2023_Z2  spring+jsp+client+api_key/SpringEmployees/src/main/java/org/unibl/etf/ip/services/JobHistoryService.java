package org.unibl.etf.ip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.models.entities.JobHistory;
import org.unibl.etf.ip.repositories.JobHistoryRepository;

@Service
public class JobHistoryService {

	
	@Autowired
	private JobHistoryRepository repository;
	
	public List<JobHistory> getAllByEmployee(Integer employeeId) {
		return repository.findByEmployeeId(employeeId);
	}
}
