package dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javaappdb?useSSL=false";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "root@9003700657";

	public Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection failed");

			e.printStackTrace();
		}
//		} finally {
//			try {
//				connection.close();
//				System.out.println("Connection  has been succesfully closed");
//
//			} catch (SQLException e) {
//				System.out.println("unabble to close connection");
//				e.printStackTrace();
//			}
//		}
		if (connection != null) {
			System.out.println("Connection Success");
		}

		return connection;
	}

}