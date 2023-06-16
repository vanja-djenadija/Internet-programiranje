<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP</title>
<script>
    function submitForm() {
        document.getElementById("registerForm").submit();
    }
</script>

</head>
<body>
	<form method="post" action="FirstServlet" id="registerForm">
		<label>Ime</label> 
		<input type="text" name="name" required/><br>
		<label>Prezime</label>
		<input type="text" name="lastName" required/><br>
		 <label>Datum rodjenja</label>
		 <input type="number" min="1" max="31" name="day" required/>
		 <input type="number" min="1" max="12" name="month" required/>
		 <input type="number" min="1950" max="2023" name="year" required/><br>
		 <a href="javascript:void(0)" onclick="submitForm()">Registruj se</a>
	</form>
</body>
</html>