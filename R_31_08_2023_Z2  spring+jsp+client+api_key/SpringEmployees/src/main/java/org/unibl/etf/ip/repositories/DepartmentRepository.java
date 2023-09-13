package org.unibl.etf.ip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.models.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	List<Department> findByLocationId(Integer regionId);
}