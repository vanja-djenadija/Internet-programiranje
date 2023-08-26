<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Book" %>
<%@ page import="beans.BookBean" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Prikaz knjiga</title>
        <link rel="stylesheet" href="showBooksStyle.css">
    </head>
    <body>
    <%@ include file="/WEB-INF/pages/header.jsp" %>
        <table>
            <thead>
                <tr>
                    <th>Naslov</th>
                    <th>Pisac</th>
                    <th>Link ka detaljima</th>
                    <th>Cijena</th>
                    <th>Kupi</th>
                </tr>
            </thead>
            <tbody>
                <% 
                BookBean bookBean = (BookBean) session.getAttribute("bookBean");
                for(Book b: bookBean.getBooks()) { %>
                <tr>
                	<td><%= b.getNaslov() %></td>
                	<td><%= b.getPisac() %></td>
                	<td><a href="<%= b.getLinkKaDetaljima() %>" target="_blank">Link ka detaljima</a></td>
                	<td><%= b.getCijena() %></td>
                	<td><a href="?action=buyBook&bookName=<%= b.getNaslov() %>">Kupi knjigu</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <%@ include file="/WEB-INF/pages/footer.jsp" %>
    </body>
</html>