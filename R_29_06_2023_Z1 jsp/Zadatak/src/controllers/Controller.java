package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BookBean;
import beans.UserBean;
import models.Book;
import models.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static boolean isLoaded = false;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(!isLoaded) {
			loadBooksFromTxt();
			isLoaded = true;
		}
		
		String action = request.getParameter("action");
		
		String address = "/WEB-INF/pages/registration.jsp";
		
		if(action == null || "".equals(action)) {
			action = "registration";
		} else if("registration".equals(action)) {
				UserBean userBean = new UserBean();
				String username = request.getParameter("username");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String dateOfBirth = request.getParameter("dateOfBirth");
				
				if(userBean.registrationSucessfull(username, dateOfBirth)) {
					BookBean bookBean = new BookBean();
					userBean.addUser(new User(firstName, lastName, username, dateOfBirth));
					session.setAttribute("bookBean", bookBean);
					session.setAttribute("userBean", userBean);
					session.setAttribute("user", userBean.findUser(username));
					address = "/WEB-INF/pages/showBooks.jsp";
				} else {
					session.setAttribute("registration", "Nevalidni podaci");
				}
		} else if("showBooks".equals(action)) {
			address = "/WEB-INF/pages/showBooks.jsp";
		} else if("buyBook".equals(action)) {
			BookBean bookBean = (BookBean) session.getAttribute("bookBean");
			String bookName = request.getParameter("bookName");
			session.setAttribute("bookToBuy", bookBean.findBook(bookName));
			address = "/WEB-INF/pages/buyBook.jsp";
		} else if("finalBuy".equals(action)) {
			Book book = (Book) session.getAttribute("bookToBuy");
			Integer bookPrice = book.getCijena();
			boolean pom = isUserBirthday();
			if(pom) {
				// TODO AKO MU JE RODJENDAN	
				// ONDA JE POTREBNO SAMO UMANJITI CIJENU KNJGIE ZA 25%
			}
			int num = (new Random().nextInt(1));
			if(num == 0) {
				session.setAttribute("buy", "Uspjesno ste kupili knjigu ciji je naslov " + book.getNaslov() + " pri cemu " + (pom? "jeste": "niste") + "ostvarili popust. Konacna cijena knjige je " + bookPrice);
			} else if(num == 1){
				address = "/WEB-INF/pages/showBooks.jsp";
			}
			address = "/WEB-INF/pages/buyBook.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void loadBooksFromTxt() {
		BookBean bookBean = new BookBean();
		File file = new File(getServletContext().getRealPath("knjigeIP.txt"));
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = "";
			while((line = br.readLine()) != null) {
				String[] parts = line.split("#");
				bookBean.addBook(new Book(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4])));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private boolean isUserBirthday() {
		//TODO Provjeriti da li je korisniku rodjendan ovog mjeseca
		return true;
	}

}
