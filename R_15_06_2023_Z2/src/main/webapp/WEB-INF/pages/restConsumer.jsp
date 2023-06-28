<%@page import="java.util.ArrayList"%>
<%@page import="app.dto.Meeting"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REST Consumer</title>
</head>
<body>
	<h1>REST Consumer</h1>
	<form action="?action=konzumirajServis" method="post">
		<label for="username">Korisnicko ime:</label> <input type="text"
			id="username" name="username" required><br> <label
			for="date">Datum:</label> <input type="date" id="date" name="date"
			required><br> <input type="submit"
			value="Konzumiraj servis">
	</form>
	<h3><%=session.getAttribute("response") != null ? session.getAttribute("response").toString() : ""%></h3>
	<h2>Sastanci</h2>
	<table id="sastanciTable">
		<tr>
			<th>Naziv</th>
			<th>Vrijeme</th>
			<th>Tema</th>
			<th>Mjesto</th>
		</tr>
		<tbody>
			<%
			if (session.getAttribute("meetings") != null) {
				List<Meeting> meetings = (ArrayList<Meeting>) session.getAttribute("meetings");
				for (Meeting m : meetings) {
					out.println("<tr>");
					out.println("<td>" + m.getName() + "</td>");
					out.println("<td>" + m.getDate() + "</td>");
					out.println("<td>" + m.getTopic() + "</td>");
					out.println("<td>" + m.getLocation() + "</td>");
					out.println("</tr>");
				}
			}
			%>
		</tbody>
	</table>
</body>
</html>
