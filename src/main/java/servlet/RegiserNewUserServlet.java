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

@WebServlet(name = "RegisterNewUserServlet", urlPatterns = { "/registeruser" })
public class RegiserNewUserServlet extends HttpServlet {
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
		userDAO.setCreateDate(LocalDateTime.now());
		userDAO.setActiveInd(1);

		appUserService.insertAppUser(connection, userDAO);
		request.setAttribute("message3", "User has been added successfully");
		request.setAttribute("message4", "Please Login Again To continue");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
}
