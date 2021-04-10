package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConfig.DatabaseConnector;
import service.AppUserService;

@WebServlet(name = "ApplicationServlet", urlPatterns = { "/app" })
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private AppUserService appUserService;

	public void init(ServletConfig config) {
		System.out.println("Servlet has been initialised!!!");
		DatabaseConnector connector = new DatabaseConnector();
		connection = connector.getConnection();
	}
	
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login-success.jsp");
		requestDispatcher.forward(request, response);
}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		appUserService = new AppUserService();

//	        writer.println("Creation Time: " + new Date(session.getCreationTime()));
//	        writer. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		int result = appUserService.appUserLogin(connection, userName, password);

		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("session is active");

			session.setMaxInactiveInterval(900);

			if (result == -1) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login-success.jsp");
				String sessionId = session.getId();

				System.out.println("Session Id for the cureent session is" + sessionId);

				request.setAttribute("USERNAME", userName);
				session.setAttribute("userid", result);
				System.out.println("id for user is" + result);
				requestDispatcher.forward(request, response);

			}
		} else {
			System.out.println("session doesnot exist!!");
		}
	}

}
