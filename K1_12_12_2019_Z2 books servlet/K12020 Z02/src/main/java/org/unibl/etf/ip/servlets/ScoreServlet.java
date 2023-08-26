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
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
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
		if (!"http://localhost:8080/K12020_Z02/ShowBookServlet".equals(request.getHeader("referer"))) {
			response.sendRedirect("IndexServlet");
			return;
		}
		response.setContentType("text/html");
		String username = (String) request.getSession().getAttribute("username");
		String isbn = request.getParameter("isbn");
		String score = request.getParameter("score");
		List<Book> books = new BookDAO(URLDecoder.decode(getServletContext().getResource(IndexServlet.booksPath).getPath(), "UTF-8")).getAll();
		Book book = null;
		for (Book b : books)
			if (b.getIsbn().equals(isbn))
				book = b;
		try (PrintWriter pw = response.getWriter()) {
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Cetvrti</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <h4>Korisnik " + username + " je ocijenio knjigu " + book.getTitle() + " ocjenom " + score + "."
							+ "Vise o knjizi procitajte na <a href=\"" + book.getDetailsLink() + "\">linku</a>.</h4>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}

}
