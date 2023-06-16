package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import model.Book;
import model.User;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String booksPath = "." + File.separator + "WEB-INF" + File.separator + "resources"
			+ File.separator + "knjige.txt";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("first.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");

		HttpSession session = request.getSession();
		session.setAttribute("user", new User(name, lastName, day, month, year));

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		BookDAO dao;
		try {
			dao = new BookDAO(getServletContext().getResource(booksPath).toURI());
			List<Book> books = dao.getAll();
			session.setAttribute("books", books);
			
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "    <head>\r\n"
					+ "    <title>First Servlet</title>\r\n"
					+ "    </head>\r\n"
					+ "    <body>"
					+ "		<table>\r\n"
					+ "            <thead>\r\n"
					+ "                <th>Naslov</th>\r\n"
					+ "                <th>Pisac</th>\r\n"
					+ "                <th>Link za detalje</th>\r\n"
					+ "                <th>Cijena</th>\r\n"
					+ "                <th>Akcije</th>\r\n"
					+ "            </thead>\r\n"
					+ "            <tbody>");
			int i = 0;
			for(Book b: books) {
				pw.println(" <tr>\r\n"
						+ "                    <td>" + b.getTitle()+ "</td>\r\n"
						+ "                    <td>" + b.getAuthor()+ "</td>\r\n"
						+ "                    <td><a href=\""+ b.getDetails()+"\">Link</a></td>\n"
						+ "                    <td>"+ b.getPrice() + "</td>\r\n"
						+ "                    <td><a href=\"second.jsp?index="+ i + "\">Kupi</a></td>\r\n"
						+ "                </tr>");
				i++;
			}
			
			pw.println(" </tbody>\r\n"
					+ "        </table>\r\n"
					+ "    </body>\r\n"
					+ "</html>");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		pw.close();
	}

}
