package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.User;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecondServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("first.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success = new Random().nextBoolean();
		boolean discount = false;
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		User user = (User) request.getSession().getAttribute("user");
		List<Book> books = (List<Book>) request.getSession().getAttribute("books");
		int index = Integer.parseInt(request.getParameter("index"));
		Book book = books.get(index);
		int price = Integer.parseInt(book.getPrice());
		if (month == Integer.parseInt(user.getMonth())) {
			price = (int) ((int) price * 0.75);
			discount = true;
		}

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		if (success) {
			pw.println("Uspjesna kupovina knjige : " + book.getTitle() + " Cijena: " + price + "KM " + (discount ? " sa" : " bez") + " popustom.");
		} else {
			response.sendRedirect("first.jsp");
		}

		pw.close();
	}

}
