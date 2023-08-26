<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="app.dto.Meeting"%>
<%@page import="app.dto.User"%>
<%@page import="app.beans.MeetingBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meetings</title>
</head>
<body>
	<h1>Meetings</h1>

	<%@include file="header.jsp"%>

	<a href="?action=logout">Odjava sa sistema</a>
	<hr />
	<a href="?action=newMeeting">Kreiraj novi sastanak &gt;&gt;&gt;</a>
	<hr />
	<a href="?action=restConsumer">Rest Consumer &gt;&gt;&gt;</a>
	<hr />
	<%
	int i = 0;
	for (Meeting m : meetingBean.getAll(userBean.getUser().getUsername())) {
		out.println("<br />Naziv: " + m.getName() + "<br />");
		out.println("Datum: " + m.getDate()+ "<br />");
		out.println("Tema: " + m.getTopic() + "<br />");
		out.println("Lokacija: " + m.getLocation());
		out.println("<a href=\"?action=deleteMeeting&id=" + i + "\">Obrisi</a>");
		out.println("<hr />" + "<br />");
		i++;
	}
	%>
	<h3><%=session.getAttribute("notification").toString()%></h3>
</body>
</html>