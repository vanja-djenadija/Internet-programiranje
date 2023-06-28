package app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import app.beans.MeetingBean;
import app.beans.UserBean;
import app.dto.Meeting;
import app.dto.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REST = "/rest";
	private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
	private static final String REGISTER_PAGE = "/WEB-INF/pages/register.jsp";
	private static final String MEETINGS_PAGE = "/WEB-INF/pages/meetings.jsp";
	private static final String NEW_MEETING_PAGE = "/WEB-INF/pages/new_meeting.jsp";
	private static final String REST_CONSUMER_PAGE = "/WEB-INF/pages/restConsumer.jsp";
	private static final String NOT_FOUND_PAGE = "/WEB-INF/pages/404.jsp";
	private static final String ADD_SUCCESS_MSG = "Uspjesno dodan sastanak";
	private Logger logger = Logger.getLogger("Controller");

	/**
	 * Default constructor.
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = REST_CONSUMER_PAGE;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		session.setAttribute("notification", "");

		if (action == null || action.equals("")) {
			System.err.println(" action == null ");
			address = LOGIN_PAGE;
		} else if (action.equals("logout")) {
			session.invalidate();
			address = LOGIN_PAGE;
		} else if (action.equals("login")) {
			String username = request.getParameter("username");
			UserBean userBean = new UserBean();
			if (userBean.login(username)) {
				session.setAttribute("userBean", userBean);
				MeetingBean meetingBean = new MeetingBean();
				session.setAttribute("meetingBean", meetingBean);
				address = MEETINGS_PAGE;
			} else {
				session.setAttribute("notification", "Pogresni parametri za pristup");
			}
		} else if (action.equals("register")) {
			String username = request.getParameter("username");
			UserBean userBean = new UserBean();
			try {
				if (username != null) {
					if (userBean.isUsernameAllowed(request.getParameter("username"))) {
						if (userBean.register(username)) {
							MeetingBean meetingBean = new MeetingBean();
							session.setAttribute("meetingBean", meetingBean);
							address = LOGIN_PAGE;
						}
					} else {
						session.setAttribute("notification", "Username je zauzet");
						address = REGISTER_PAGE;
					}
				} else {
					address = REGISTER_PAGE;
				}
			} catch (Exception e) {
				session.setAttribute("notification", "ERROR: " + e.getMessage());
			}
		} else {
			System.err.println("ETF 0 ");
			UserBean userBean = (UserBean) session.getAttribute("userBean");
			MeetingBean meetingBean = (MeetingBean) session.getAttribute("meetingBean");
			if (userBean == null || !userBean.isLoggedIn()) {
				System.err.println("ETF 1 ");
				address = LOGIN_PAGE;
			} else {
				if (action.equals("meetings")) {
					System.err.println("ETF 2 ");
					address = MEETINGS_PAGE;
				} else if (action.equals("restConsumer")) {
					System.err.println("ETF 3 ");
					address = REST_CONSUMER_PAGE;
				} else if (action.equals("konzumirajServis")) {
					System.err.println("ETF 4 ");
					// TODO: Not finished
					String username = request.getParameter("username");
					String date = request.getParameter("date");
					session.setAttribute("response", response);
		
					// NOT WORKING EXCEPTION WHILE PARSING
					Gson gson = new Gson();
					TypeToken<List<Meeting>> typeToken = new TypeToken<List<Meeting>>() {};
					ArrayList<Meeting> list = gson.fromJson(response.toString(), typeToken.getType());
					session.setAttribute("meetings", list);
					
					sendRequest(session, username, date);
				} else if (action.equals("newMeeting")) {
					address = NEW_MEETING_PAGE;

					if (request.getParameter("submit") != null && request.getParameter("name") != null
							&& request.getParameter("date") != null && request.getParameter("topic") != null
							&& request.getParameter("location") != null) {
						try {
							String name = request.getParameter("name");
							String date = request.getParameter("date");
							String topic = request.getParameter("topic");
							String location = request.getParameter("location");
							Meeting newMeeting = new Meeting(name, date, topic, location);
							if (meetingBean.add(userBean.getUser().getUsername(), newMeeting)) {
								session.setAttribute("notification", ADD_SUCCESS_MSG);
								address = MEETINGS_PAGE;
							}
						} catch (Exception e) {
							session.setAttribute("notification", "ERROR: " + e.getMessage());
						}
					}

				} else if (action.equals("deleteMeeting")) {
					int id = Integer.parseInt(request.getParameter("id"));
					Meeting meetingToDelete = meetingBean.getAll(userBean.getUser().getUsername()).get(id);
					if (meetingBean.remove(userBean.getUser().getUsername(), meetingToDelete)) {
						address = MEETINGS_PAGE;
					} else {
						session.setAttribute("notification", "Ne moze se obrisati sastanak.");
					}

				} else {
					address = NOT_FOUND_PAGE;
				}
			}

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void sendRequest(HttpSession session, String username, String date) {

		logger.info("ETF usao ");
		try {
			java.net.URL url = new java.net.URL("http://localhost:8080/R_15_06_2023_Z2/rest/" + username + "/" + date);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			session.setAttribute("response", response.toString());
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
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
