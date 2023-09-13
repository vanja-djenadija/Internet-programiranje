<%@page import="org.unibl.etf.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="employeeBean" type="org.unibl.etf.beans.EmployeeBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Search</title>
</head>
<body>
	<h2>Employee Search</h2>

	<form action="?action=search" method="post">
		<label for="startDate">Start Date:</label> 
		<input type="date" id="startDate" name="startDate" required> 
		<label for="endDate">End Date:</label> 
		<input type="date" id="endDate" name="endDate" required> 
		<input type="submit" value="Search">
	</form>

	<br>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Hire Date</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Employee e : employeeBean.getEmployees()) {
			%>
			<tr>
				<td><%= e.getEmployeeId() %></td>
				<td><%=e.getFirstName()%></td>
				<td><%=e.getHireDate()%></td>
				<td><%=e.getSalary()%></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>
