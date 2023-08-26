package org.unibl.etf.ip.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!"http://localhost:8080/K12020_Z02/IndexServlet".equals(request.getHeader("referer"))) {
			response.sendRedirect("IndexServlet");
			return;
		}
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Drugi</title>\r\n"
					+ "    <script>\r\n"
					+ "        const next = () => {\r\n"
					+ "            const username = document.getElementById(\"form\")[\"username\"].value;\r\n"
					+ "            console.log([...username].reverse().join(\"\") + \" \" + username);\r\n"
					+ "            if ([...username].reverse().join(\"\") === username)\r\n"
					+ "                return true;\r\n"
					+ "            else {\r\n"
					+ "                location.href = \"IndexServlet\";\r\n"
					+ "                return false;\r\n"
					+ "            }\r\n"
					+ "        };\r\n"
					+ "    </script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <form onsubmit=\"return next()\" action=\"ShowBookServlet\" method=\"post\" id=\"form\">\r\n"
					+ "        <label>Korisnicko ime: </label>\r\n"
					+ "        <input type=\"text\" name=\"username\" />\r\n"
					+ "        <br />\r\n"
					+ "        <input type=\"submit\" value=\"Dalje\" />\r\n"
					+ "    </form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("IndexServlet");
	}

}
