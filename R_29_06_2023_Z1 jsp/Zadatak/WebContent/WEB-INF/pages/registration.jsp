<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registracija</title>
        <script type="text/javascript" src="registrationScript.js"></script>
    </head>
    <body>
        <form action="?action=registration" method="post" id="form">
            <label>Korisnicko ime: </label>
            <input type="text" name="username" id="username" required autofocus>
            <br>

            <label>Ime: </label>
            <input type="text" name="firstName" id="firstName" required>
            <br>

            <label>Korisnicko ime: </label>
            <input type="text" name="lastName" id="lastName" required>
            <br>

            <label>Datum rodjenja: </label>
            <input type="date" name="dateOfBirth" id="dateOfBirth" required>
            <br>

			<a href="javascript:register()">Dalje</a>
        </form>
        <h3><%= session.getAttribute("registration") != null? session.getAttribute("registration"): "" %></h3>
    </body>
</html>