package org.unibl.etf.ip.dto;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private int employeeId, managerId, departmentId;
	private String firstName, lastName, email, phone, jobId;
	private String hireDate;
	private double salary, commisionPct;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int employeeId, int managerId, int departmentId, String firstName, String lastName, String email,
			String phone, String jobId, String hireDate, double salary, double commisionPct) {
		super();
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.jobId = jobId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commisionPct = commisionPct;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommisionPct() {
		return commisionPct;
	}
	public void setCommisionPct(double commisionPct) {
		this.commisionPct = commisionPct;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ ", jobId=" + jobId + ", hireDate=" + hireDate + ", salary=" + salary + ", commisionPct="
				+ commisionPct + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(commisionPct, departmentId, email, employeeId, firstName, hireDate, jobId, lastName,
				managerId, phone, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(commisionPct) == Double.doubleToLongBits(other.commisionPct)
				&& departmentId == other.departmentId && Objects.equals(email, other.email)
				&& employeeId == other.employeeId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(jobId, other.jobId)
				&& Objects.equals(lastName, other.lastName) && managerId == other.managerId
				&& Objects.equals(phone, other.phone)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	
	
	
}
