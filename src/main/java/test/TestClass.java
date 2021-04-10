package test;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Scanner;

import dbConfig.DatabaseConnector;
import model.AppUserDAO;
import service.AppUserService;

public class TestClass {

	public static void main(String[] args) {
		int choice = 0;
		int mainpage = 0;
		int operation = 0;

		DatabaseConnector connector = new DatabaseConnector();
		Connection connection = connector.getConnection();

		System.out.println("WELCOME TO THE APPLICATION");

		System.out.println("Press 1 to register and 2 to login(if already registered)");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();

		switch (choice) {
		case 1: {
			registerUser(connection, sc);
			break;
		}

		case 2: {

			int userId = loginUser(connection, sc);
			if (userId > 0) {

				System.out.println("press 1 to make changes to a user and 2 to return to the main page ");
				mainpage = sc.nextInt();

				if (mainpage == 1) {
					while (true) {
						System.out.println(
								"press 1 to update details, 2 to delete, 3 to get all details of a user and 4 to exit");
						operation = sc.nextInt();

						switch (operation) {

						case 1: {
							updateUser(connection, sc, userId);
							break;
						}
						case 2: {
							deleteUser(connection, userId);
							System.out.println(" Thank You for using the application");
							System.exit(0);
						}
						case 3: {
							getUserDetails(connection, userId);
							break;
						}
						case 4: {
							System.out.println("Application Exited . Thank You for using the application");
							System.exit(0);
						}

						}
					}
				} else {
					System.out.println("thank you for being a valuable user");
				}
				break;
			}

		}

		}

	}

	private static void getUserDetails(Connection connection, int userId) {
		AppUserService appUserService = new AppUserService();
		AppUserDAO appUser = appUserService.getAppUser(connection, userId);

		System.out.println(appUser);
	}

	private static void deleteUser(Connection connection, int userId) {

		AppUserService appUserService = new AppUserService();
		appUserService.deleteAppUser(connection, userId);
	}

	private static void updateUser(Connection connection, Scanner sc, int userId) {
		System.out.println("Enter the following details");
		sc.nextLine();
		System.out.println("Enter first name");
		String firstName = sc.nextLine();

		System.out.println("Enter last name");

		String lastName = sc.nextLine();

		System.out.println("Enter your emial");

		String userEmail = sc.nextLine();

		System.out.println("Choose password");

		String password = sc.nextLine();

		System.out.println("Enter your Phone Number");

		String userPhoneNumber = sc.nextLine();

		System.out.println("Enter your address");

		String userAddress = sc.nextLine();

		AppUserDAO appUser = new AppUserDAO();
		AppUserService appUserService = new AppUserService();

		appUser.setFirstName(firstName);
		appUser.setLastName(lastName);
		appUser.setEmail(userEmail);
		appUser.setUserName(userEmail);
		appUser.setPassword(password);
		appUser.setPhoneNumber(userPhoneNumber);
		appUser.setAddress(userAddress);
		appUser.setModifiedDate(LocalDateTime.now());

		appUserService.updateAppUser(connection, appUser, userId);

	}

	private static int loginUser(Connection connection, Scanner sc) {

		System.out.println("Enter the following details");
	
		sc.nextLine();
		System.out.println("Enter Username");
		String userName = sc.nextLine();

		System.out.println("Enter your Password");
		
		String password = sc.nextLine();

		AppUserService appUserService = new AppUserService();
		int userId = appUserService.appUserLogin(connection, userName, password);

		return userId;

	}

	private static void registerUser(Connection connection, Scanner sc) {
		System.out.println("Enter the following details");
		sc.nextLine();
		System.out.println("Enter first name");
		String firstName = sc.nextLine();

		System.out.println("Enter last name");

		String lastName = sc.nextLine();

		System.out.println("Enter your emial");

		String userEmail = sc.nextLine();

		System.out.println("Choose password");

		String password = sc.nextLine();

		System.out.println("Enter your Phone Number");

		String userPhoneNumber = sc.nextLine();

		System.out.println("Enter your address");

		String userAddress = sc.nextLine();

		AppUserDAO appUser = new AppUserDAO();
		AppUserService appUserService = new AppUserService();
		appUser.setFirstName(firstName);
		appUser.setLastName(lastName);
		appUser.setEmail(userEmail);
		appUser.setUserName(userEmail);
		appUser.setPassword(password);
		appUser.setPhoneNumber(userPhoneNumber);
		appUser.setAddress(userAddress);
		appUser.setCreateDate(LocalDateTime.now());
		appUser.setActiveInd(1);

		appUserService.insertAppUser(connection, appUser);

	}
}
