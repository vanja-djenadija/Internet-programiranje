package org.unibl.etf.ip.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.unibl.etf.ip.dao.BookDAO;
import org.unibl.etf.ip.model.Book;

/**
 * Servlet implementation class ShowBookServlet
 */
@WebServlet("/ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("IndexServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!"http://localhost:8080/K12020_Z02/LoginServlet".equals(request.getHeader("referer"))) {
			response.sendRedirect("IndexServlet");
			return;
		}
		request.getSession().setAttribute("username", request.getParameter("username"));
		response.setContentType("text/html");
		List<Book> books = new BookDAO(URLDecoder.decode(getServletContext().getResource(IndexServlet.booksPath).getPath(), "UTF-8")).getAll();
		try (PrintWriter pw = response.getWriter()) {
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Treci</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <table style=\"border-collapse: collapse; border: 1px solid black\">\r\n"
					+ "        <tr>\r\n"
					+ "            <th>ISBN</th>\r\n"
					+ "            <th>Naslov</th>\r\n"
					+ "            <th>Autor</th>\r\n"
					+ "            <th>Slika</th>\r\n"
					+ "            <th>Opis</th>\r\n"
					+ "        </tr>\r\n"
					+ "        <tr>");
			for (Book book : books) {
				pw.println("<td>" + book.getIsbn() + "</td>"
						+ "<td>" + book.getTitle() + "</td>"
						+ "<td>" + book.getAuthor() + "</td>"
						+ "<td><img style=\"height:50px; width: 30px;\" src=\"" + book.getImageLink() + "\" /></td>"
						+ "<td><a href=\"" + book.getDetailsLink() + "\">Detalji</a></td>");
			}
			pw.println("</tr>\r\n"
					+ "    </table>\r\n"
					+ "    <form action=\"ScoreServlet\" method=\"post\">\r\n"
					+ "        <select name=\"isbn\">\r\n");
			for (Book book : books) {
				pw.println("<option value=\"" + book.getIsbn() + "\">" + book.getIsbn() + "</option>");
			}
			pw.println("</select>\r\n"
					+ "        <br />\r\n"
					+ "        <select name=\"score\">\r\n"
					+ "            <option value=\"1\">1</option>\r\n"
					+ "            <option value=\"2\">2</option>\r\n"
					+ "            <option value=\"3\">3</option>\r\n"
					+ "            <option value=\"4\">4</option>\r\n"
					+ "            <option value=\"5\">5</option>\r\n"
					+ "        </select>\r\n"
					+ "        <br />\r\n"
					+ "        <input type=\"submit\" value=\"Ocijeni\" />\r\n"
					+ "    </form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}

}
