package org.unibl.etf.ip.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.models.entities.Employee;


public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	List<Employee> findByJobId(String jobId);
	List<Employee> findBySalaryLessThanEqual(double maxSalary);
	List<Employee> findByHireDateBetween(Date startDate, Date endDate);
}
