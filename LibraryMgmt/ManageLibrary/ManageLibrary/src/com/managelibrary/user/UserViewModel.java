package com.managelibrary.user;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel {
	User user;
	static List<User> userList = new ArrayList<>();

	public UserViewModel(User user) {
		this.user = user;
	}

	boolean addUser(User user) {
		return userList.add(user);
	}

	static boolean removeUser(String userName) {
		for (User user : userList) {
			if (user.userName.equals(userName)) {
				userList.remove(user);
				return true;
			}
		}
		return false;
	}

	public static boolean validateUser(String name, String password) {
		for (User user : userList) {
			if (user.userName.equals(name) && user.password.equals(password)) {
				return true;
			}
		}
		return false;
	}
}
