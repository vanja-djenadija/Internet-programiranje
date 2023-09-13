package org.unibl.etf.ip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.models.entities.Department;
import org.unibl.etf.ip.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	
	@Autowired
	private DepartmentRepository repository;

	public List<Department> getAllByLocation(Integer locationId) {
		return repository.findByLocationId(locationId);
	}
}
