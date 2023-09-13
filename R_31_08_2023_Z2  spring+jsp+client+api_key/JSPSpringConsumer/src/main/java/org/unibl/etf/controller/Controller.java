package org.unibl.etf.controller;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.unibl.etf.beans.EmployeeBean;
import org.unibl.etf.dto.Employee;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String baseUrl = "http://localhost:9000/employees";
	private static final String endpointUrl = baseUrl + "/hired";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/index.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		// Setting bean in session to retrieve employees in JSP 
		EmployeeBean employeeBean = new EmployeeBean();
		session.setAttribute("employeeBean", employeeBean);

		if (action == null || action.equals("")) {
			address = "/WEB-INF/index.jsp";
		} else if (action.equals("search")) {
			try {
				// Getting values from date inputs
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");

				// Making DateRangeRequest object that will be passed inside body of request
				DateRangeRequest dateReq = new DateRangeRequest();
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				dateReq.setStart(sdf.parse(startDate));
				dateReq.setEnd(sdf.parse(endDate));

				// Making POST request and reading response (JSON serialization/ deserialization included)
				Client client = ClientBuilder.newClient();
				URI uri = new URI(endpointUrl);
				WebTarget target = client.target(uri);
				ObjectMapper objectMapper = new ObjectMapper();
				Response targetResponse = target.request(MediaType.APPLICATION_JSON).post(Entity.json(objectMapper.writeValueAsString(dateReq)));
				String jsonResponse = targetResponse.readEntity(String.class);
				List<Employee> employees = objectMapper.readValue(jsonResponse, new TypeReference<List<Employee>>() {
				});
				
				// Setting employees to employeeBean
				employeeBean.setEmployees(employees);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
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

class DateRangeRequest {
	private Date start;
	private Date end;

	public DateRangeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateRangeRequest(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
}