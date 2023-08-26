<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Book" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kupovina knjige</title>
        <script type="text/javascript" src="buyBookScript.js"></script>
    </head>
    <body>
    	<%@ include file="/WEB-INF/pages/header.jsp" %>
    	<%  User user = (User) session.getAttribute("user");
    		Book book = (Book) session.getAttribute("bookToBuy");
    	%>	
        <h3>Naziv knjige: <%= book.getNaslov() %></h3>
        <img src="<%= book.getLinkKaSlici() %>" alt="nema-slike">
        <h3>Podaci o korisniku: </h3>
        <p><%= user.getFirstName() %></p>
        <p><%= user.getLastName() %></p>
        <p><%= user.getDateOfBirth() %></p>
        <button onclick="javascript:buyBook()">Potvrdi kupovinu</button>
        <h2><%= session.getAttribute("buy") != null? session.getAttribute("buy"): "" %></h2>
        <%@ include file="/WEB-INF/pages/footer.jsp" %>
    </body>
</html>