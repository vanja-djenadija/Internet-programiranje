<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="?action=login" method="post">
		<label for="username">Korisnicko ime:</label> <input type="text"
			id="username" name="username" required> <input type="submit"
			value="Prijavi se">

		<h3><%=session.getAttribute("notification") != null ? session.getAttribute("notification").toString() : ""%></h3>
		<br> <a href="?action=register">Kreiraj novi nalog
			&gt;&gt;&gt;</a>
	</form>

</body>
</html>