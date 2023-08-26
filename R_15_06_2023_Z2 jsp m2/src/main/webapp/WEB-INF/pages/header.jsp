<%@page import="app.beans.MeetingBean"%>
<%@page import="app.beans.UserBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="app.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" type="app.beans.UserBean" scope="session" />
<jsp:useBean id="meetingBean" type="app.beans.MeetingBean"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<h2>
		<%
		out.println(userBean.getUser().getUsername() + " ima sljedeci broj sastanaka: "
				+ meetingBean.numberOfMeetings(userBean.getUser().getUsername()) + " "
				+ (new SimpleDateFormat("dd.MM.yyy")).format(new Date()));
		%>
	</h2>
</body>
</html>

