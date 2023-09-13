package org.unibl.etf.ip.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.models.entities.Employee;
import org.unibl.etf.ip.models.entities.requests.DateRangeRequest;
import org.unibl.etf.ip.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public List<Map.Entry<Integer, List<Employee>>> getAllByJobIdGroupedByDepartment(String jobId) {
		List<Employee> employees = employeeRepository.findByJobId(jobId);
		Map<Integer, List<Employee>> grouped = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId));
		return grouped.entrySet().stream().collect(Collectors.toList());
	}

	public List<Employee> getAllBySalaryLessThan(Double salary) {
		return employeeRepository.findBySalaryLessThanEqual(salary);
	}

	public Employee update(Integer employeeId, Employee request) throws NotFoundException {
		Employee employeeEntity = employeeRepository.findById(employeeId).orElseThrow(NotFoundException::new);
		employeeEntity.setCommisionPct(request.getCommisionPct());
		employeeEntity.setDepartmentId(request.getDepartmentId());
		employeeEntity.setEmail(request.getEmail());
		employeeEntity.setFirstName(request.getFirstName());
		employeeEntity.setHireDate(request.getHireDate());
		employeeEntity.setJobId(request.getJobId());
		employeeEntity.setLastName(request.getLastName());
		employeeEntity.setManagerId(request.getManagerId());
		employeeEntity.setPhone(request.getPhone());
		employeeEntity.setSalary(request.getSalary());
		employeeRepository.saveAndFlush(employeeEntity);
		return employeeEntity;
	}

	public List<Employee> getAllBetweenHireDates(DateRangeRequest request) {
		return employeeRepository.findByHireDateBetween(request.getStart(), request.getEnd());
	}
}
