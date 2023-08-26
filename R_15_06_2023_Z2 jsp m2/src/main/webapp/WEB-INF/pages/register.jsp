<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration</h1>
	<form action="?action=register" method="post">
		<label for="username">Korisnicko ime:</label> <input type="text"
			id="username" name="username" required> <input type="submit"
			value="Registruj se">

		<h3><%=session.getAttribute("notification") != null ? session.getAttribute("notification").toString() : ""%></h3>
		<a href="?action=login">Prijavi se &gt;&gt;&gt;</a>
	</form>

</body>
</html>