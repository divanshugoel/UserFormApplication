package service;

import java.sql.Connection;
import java.util.List;

import model.AppUserDAO;
import repository.AppUserRepository;

public class AppUserService {

	public void insertAppUser(Connection conn, AppUserDAO appUser) {
		AppUserRepository appUserRepository = new AppUserRepository();
		appUserRepository.addUser(conn, appUser);

	}

	public void updateAppUser(Connection conn, AppUserDAO updatedAppUser, int userId) {
		AppUserRepository appUserRepository = new AppUserRepository();
		appUserRepository.updateUser(conn, updatedAppUser, userId);

	}

	public AppUserDAO getAppUser(Connection conn, int id) {
		AppUserRepository appUserRepository = new AppUserRepository();
		AppUserDAO appUser = appUserRepository.getUserById(conn, id);
		return appUser;

	}

	public void deleteAppUser(Connection conn, int id) {
		AppUserRepository appUserRepository = new AppUserRepository();
		appUserRepository.deleteUser(conn, id);

	}

	public List<AppUserDAO> getAllAppUsers(Connection conn) {
		AppUserRepository appUserRepository = new AppUserRepository();
		List<AppUserDAO> allAppUsers = appUserRepository.getAllUsers(conn);
		return allAppUsers;
	}
	public int appUserLogin(Connection conn, String userName, String password) {
		AppUserRepository appUserRepository = new AppUserRepository();
		if(appUserRepository.checkUserExists(conn,userName,password)) {
			AppUserDAO userByUserName = appUserRepository.getUserByUserName(conn, userName);
			System.out.println("User is logged successfully");
			System.out.println("Hello "+ userByUserName.getFirstName() + " !");
			return userByUserName.getId();
		}else {
			System.out.println("Login failed. Username or password is incorrect");
			return -1;
		}
	}

}
