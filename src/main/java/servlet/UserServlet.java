package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConfig.DatabaseConnector;
import model.AppUserDAO;
import service.AppUserService;

@WebServlet(name = "UserServlet", urlPatterns = { "/" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private AppUserService appUserService;
	private AppUserDAO userDAO;

	public void init(ServletConfig config) {
		System.out.println("Servlet has been initialised!!!");
		DatabaseConnector connector = new DatabaseConnector();
		connection = connector.getConnection();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		int appUserId = (int) request.getSession(false).getAttribute("userid");

		switch (action) {
		case "/update": {
			updateUser(request, response, appUserId);
			break;
		}
		case "/delete": {
			deleteUser(request, response, appUserId);
			break;
		}
		case "/getuserdetails": {
			getuser(request, response, appUserId);
			break;
		}

		}
	}

	private void getuser(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		appUserService = new AppUserService();
		AppUserDAO appUser = appUserService.getAppUser(connection, id);

		String firstName = appUser.getFirstName();
		String lastName = appUser.getLastName();
		String email = appUser.getEmail();
		String address = appUser.getAddress();
		String phoneNumber = appUser.getPhoneNumber();

		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		request.setAttribute("email", email);
		request.setAttribute("address", address);
		request.setAttribute("phonenumber", phoneNumber);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("getuserdetails.jsp");
		requestDispatcher.forward(request, response);

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		appUserService = new AppUserService();
		System.out.println("id for the current user is " + id);
		appUserService.deleteAppUser(connection, id);

		request.setAttribute("message2", "user has been deleted successfully");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Append.jsp");
		requestDispatcher.forward(request, response);

	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		appUserService = new AppUserService();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phonenumber");

		userDAO = new AppUserDAO();

		userDAO.setFirstName(firstName);
		userDAO.setLastName(lastName);
		userDAO.setEmail(email);
		userDAO.setUserName(email);
		userDAO.setPassword(password);
		userDAO.setAddress(address);
		userDAO.setPhoneNumber(phoneNumber);
		userDAO.setModifiedDate(LocalDateTime.now());

		appUserService.updateAppUser(connection, userDAO, id);
		request.setAttribute("message1", "user has been updated successfully");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);

	}

}
