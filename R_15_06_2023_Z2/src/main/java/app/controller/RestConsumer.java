package app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import app.beans.MeetingBean;
import app.dto.Meeting;

/**
 * Servlet implementation class RestConsumer
 */
@WebServlet("/rest/*")
public class RestConsumer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger("RestConsumer");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestConsumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pathInfo = request.getPathInfo();
		String pathUri = request.getRequestURI();
		logger.info("CONSUMER" + pathInfo);
		logger.info("CONSUMER" + pathUri);
		if (pathInfo != null) {
			String[] pathParts = pathInfo.split("/");
			if (pathParts.length >= 3) {
				String username = pathParts[1];
				String date = pathParts[2];

				ArrayList<Meeting> filtered = new ArrayList<Meeting>();
				try {
					ArrayList<Meeting> meetings = (ArrayList<Meeting>) new MeetingBean().getAll(username);
					//Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
					for (Meeting m : meetings) {
						if (m.getDate().equals(date))
							filtered.add(m);
					}
					Gson gson = new Gson();
					JsonArray jsonArray = gson.toJsonTree(filtered).getAsJsonArray();
					response.setContentType("application/json");

					try (PrintWriter out = response.getWriter()) {
						out.print(jsonArray);
						out.flush(); // Make sure the response is sent
						logger.info("JSON ARRAY " + jsonArray);
					    System.out.println("Response: " + jsonArray); // Print the response for debugging
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
