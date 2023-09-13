package org.unibl.etf.beans;

import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dto.Employee;

public class EmployeeBean {

	private List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
