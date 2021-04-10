package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.AppUserDAO;

public class AppUserRepository {

	private int checkUserExistsByEmail(Connection connection, String email) {

		try {
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM appusers where email = ? ");

			prepareStatement.setString(1, email);

			System.out.println(prepareStatement);

			ResultSet rs = prepareStatement.executeQuery();
			if (rs.first()) {

				return 1;
			} else {
				return 0;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void addUser(Connection connection, AppUserDAO appUser) {

		if (connection != null) {

			int result = checkUserExistsByEmail(connection, appUser.getEmail());
			if (result == 0) {

				try {
					PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO appusers "
							+ "(username,firstname,lastname,user_password,"
							+ "email,address,phone_number,created_dt,active_ind)" + " VALUES (?,?,?,?,?,?,?,?,?)");

					prepareStatement.setString(1, appUser.getUserName());
					prepareStatement.setString(2, appUser.getFirstName());
					prepareStatement.setString(3, appUser.getLastName());
					prepareStatement.setString(4, appUser.getPassword());
					prepareStatement.setString(5, appUser.getEmail());
					prepareStatement.setString(6, appUser.getAddress());
					prepareStatement.setString(7, appUser.getPhoneNumber());
					prepareStatement.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
					prepareStatement.setInt(9, 1);

					System.out.println(prepareStatement);
					prepareStatement.executeUpdate();
					System.out.println("User with username " + appUser.getUserName() + " added successfully!!");

				} catch (SQLException e) {
					System.out.println("Unable to add app user details");
					e.printStackTrace();
				}
			} else {
				System.out.println("connection failed or user already exists");
			}
		} else {
			System.out.println("connection cannot be established");
		}

	}

	public void updateUser(Connection connection, AppUserDAO updateAppUser, int userId) {

		if (connection != null) {

			try {
				PreparedStatement prepareStatement = connection.prepareStatement(
						"UPDATE appusers SET username = ?,firstname = ?,lastname = ?, user_password = ?,"
								+ "email = ?,address = ?,phone_number = ?,modified_dt = ?" + "where id =? ");

				prepareStatement.setString(1, updateAppUser.getUserName());
				prepareStatement.setString(2, updateAppUser.getFirstName());
				prepareStatement.setString(3, updateAppUser.getLastName());
				prepareStatement.setString(4, updateAppUser.getPassword());
				prepareStatement.setString(5, updateAppUser.getEmail());
				prepareStatement.setString(6, updateAppUser.getAddress());
				prepareStatement.setString(7, updateAppUser.getPhoneNumber());
				prepareStatement.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
				prepareStatement.setInt(9, userId);

				System.out.println(prepareStatement);
				prepareStatement.executeUpdate();
				System.out.println("User " + updateAppUser.getFirstName() + " updated successfully!!");

			} catch (SQLException e) {
				System.out.println("Unable to updated user");
				e.printStackTrace();
			}

		}

		else {
			System.out.println("Connection cannot be established");
		}

	}

	public AppUserDAO getUserById(Connection connection, int userId) {
		AppUserDAO appUser = new AppUserDAO();

		if (connection != null) {
			try {
				PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM appusers where id = ?");

				prepareStatement.setInt(1, userId);

//				System.out.println(prepareStatement);

				ResultSet rs = prepareStatement.executeQuery();
				if (rs.next()) {
					appUser.setId(rs.getInt("id"));
					appUser.setUserName(rs.getString("username"));
					appUser.setFirstName(rs.getString("firstname"));
					appUser.setLastName(rs.getString("lastname"));
					appUser.setEmail(rs.getString("email"));
					appUser.setPassword(rs.getString("user_password"));
					appUser.setCreateDate(rs.getTimestamp("created_dt").toLocalDateTime());
					appUser.setPhoneNumber(rs.getString("phone_number"));
					appUser.setAddress(rs.getString("address"));
					appUser.setActiveInd(rs.getInt("active_ind"));
				}

			} catch (SQLException e) {
				System.out.println("Unable to get user by id");
				e.printStackTrace();
			}

		} else {
			System.out.println("connection cannot be established");
		}

		return appUser;
	}

	public void deleteUser(Connection connection, int userId) {

		if (connection != null) {
			try {
				PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM appusers where id = ?");

				prepareStatement.setInt(1, userId);

				System.out.println(prepareStatement);
				prepareStatement.executeUpdate();
				System.out.println("User with userId " + userId + " deleted successfully!!");

			} catch (SQLException e) {
				System.out.println("Unable to delete user");
				e.printStackTrace();
			}

		} else {
			System.out.println("connection cannot be established");
		}

	}

	public List<AppUserDAO> getAllUsers(Connection connection) {

		List<AppUserDAO> appUserList = new ArrayList<AppUserDAO>();

		if (connection != null) {
			try {
				PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM appusers");

				ResultSet rs = prepareStatement.executeQuery();
				while (rs.next()) {
					AppUserDAO appUser = new AppUserDAO();
					appUser.setId(rs.getInt("id"));
					appUser.setUserName(rs.getString("username"));
					appUser.setFirstName(rs.getString("firstname"));
					appUser.setLastName(rs.getString("lastname"));
					appUser.setPassword(rs.getString("user_password"));
					appUser.setCreateDate(rs.getTimestamp("created_dt").toLocalDateTime());
					appUser.setPhoneNumber(rs.getString("phone_number"));
					appUser.setAddress(rs.getString("address"));
					appUser.setActiveInd(rs.getInt("active_ind"));

					appUserList.add(appUser);

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("connection cannot be established");
		}

		return appUserList;
	}

	public boolean checkUserExists(Connection connection, String userName, String password) {
		if (connection != null) {
			try {
				PreparedStatement prepareStatement = connection
						.prepareStatement("SELECT * FROM appusers where username = ? and user_password = ?");

				prepareStatement.setString(1, userName);
				prepareStatement.setString(2, password);

//			System.out.println(prepareStatement);

				ResultSet rs = prepareStatement.executeQuery();
				if (rs.first()) {

					return true;
				} else {
					return false;

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;
	}

	public AppUserDAO getUserByUserName(Connection connection, String userName) {
		AppUserDAO appUser = new AppUserDAO();

		if (connection != null) {
			try {
				PreparedStatement prepareStatement = connection
						.prepareStatement("SELECT * FROM appusers where username = ?");

				prepareStatement.setString(1, userName);

				System.out.println(prepareStatement);

				ResultSet rs = prepareStatement.executeQuery();
				if (rs.next()) {
					appUser.setId(rs.getInt("id"));
					appUser.setUserName(rs.getString("username"));
					appUser.setFirstName(rs.getString("firstname"));
					appUser.setLastName(rs.getString("lastname"));
					appUser.setPassword(rs.getString("user_password"));
					appUser.setCreateDate(rs.getTimestamp("created_dt").toLocalDateTime());
					appUser.setPhoneNumber(rs.getString("phone_number"));
					appUser.setAddress(rs.getString("address"));
					appUser.setActiveInd(rs.getInt("active_ind"));

				}

			} catch (SQLException e) {
				System.out.println("Unable to get user");
				e.printStackTrace();
			}

		} else {
			System.out.println("connection cannot be established");
		}

		return appUser;

	}

}
