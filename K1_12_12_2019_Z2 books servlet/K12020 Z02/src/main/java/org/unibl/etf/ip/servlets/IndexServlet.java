package org.unibl.etf.ip.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.unibl.etf.ip.dao.BookDAO;
import org.unibl.etf.ip.model.Book;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String booksPath = "./WEB-INF/Resources/books.txt";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		List<Book> books = new BookDAO(URLDecoder.decode(getServletContext().getResource(booksPath).getPath(), "UTF-8")).getAll();
		int index = new Random().nextInt(books.size());
		
		try (PrintWriter pw = response.getWriter()) {
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Prva</title>\r\n"
					+ "    <script>\r\n"
					+ "        const login = () => {\r\n"
					+ "            location.href = \"LoginServlet\";\r\n"
					+ "        };\r\n"
					+ "    </script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <h5>Ukupno knjiga: " + books.size() + "</h5>\r\n"
					+ "    <h6>Naslov: " + books.get(index).getTitle() + "</h6>\r\n"
					+ "    <img src=\"" + books.get(index).getImageLink() + "\" style=\"float: left;\"/>\r\n"
					+ "    <button onclick=\"javascript:login()\">Prijava</button>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
