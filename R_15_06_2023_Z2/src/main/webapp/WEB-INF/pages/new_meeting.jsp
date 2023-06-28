<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New meeting</title>
</head>
<body>
	<h1>New meeting</h1>
	<a href="?action=logout">Odjava sa sistema</a>
	<hr />
	<form method="POST" action="?action=newMeeting">
		Naziv: <br /> <input type="text" name="name" id="name" />
		<br /> 
		Datum: <br /> <input type="date" name="date" id="date" />
		<br /> 
		Tema: <br /> <input type="text" name="topic" id="topic" />
		<br /> 
		Lokacija: <br /> <input type="text" name="location" id="location" />
		<br /> 
		<input type="submit" value="Kreiraj sastanak" name="submit" /><br />
		
		<h3><%=session.getAttribute("notification").toString()%></h3>
		<br /> <a href="?action=meetings">Pregled sastanaka &gt;&gt;&gt;</a>
	</form>
</body>
</html>