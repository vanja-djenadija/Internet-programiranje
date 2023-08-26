<%@page import="model.User"%>
<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second JSP</title>
</head>
<%
List<Book> books = (List<Book>) request.getSession().getAttribute("books");
if(books == null)
	response.sendRedirect("first.jsp");
int index = Integer.parseInt(request.getParameter("index"));
Book book = books.get(index);
User user = (User) request.getSession().getAttribute("user");
%>
<body>
	<h1><%=book.getTitle()%></h1>
	<img src="<%=book.getImageURL()%>" alt="Book image" width="200px"
		height="200px" />
	<br />
	<p><%=user.getName() + " " + user.getLastName() + " " + user.getDay() + "-" + user.getMonth() + "-" + user.getYear() %></p>
	<form action="SecondServlet?index=<%= index %>" method="post">
		<input type="submit" value="Potvrdi kupovinu" />
	</form>
	</p>
</body>
</html>