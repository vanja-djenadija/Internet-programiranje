package org.unibl.etf.ip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.models.entities.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

	List<JobHistory> findByEmployeeId(Integer employeeId);
}
