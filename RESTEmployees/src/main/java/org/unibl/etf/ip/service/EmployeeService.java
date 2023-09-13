package org.unibl.etf.ip.service;

import java.util.ArrayList;

import org.unibl.etf.ip.dao.EmployeeDAO;
import org.unibl.etf.ip.dto.Employee;

public class EmployeeService {

	public ArrayList<Employee> getAll() {
		
		return EmployeeDAO.selectAll();
	}
}
