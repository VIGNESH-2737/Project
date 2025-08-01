package com.zsgs.theatrepass.datalayer;

import com.zsgs.theatrepass.dto.User;

public class LoginModel {
	private static LoginModel repository;

	private LoginModel() {

	}

	public static LoginModel getInstance() {
		if (repository == null) {
			repository = new LoginModel();
		}
		return repository;
	}
	
	private User loggedInuser;
	
	public User validate(String userName, String password) {
		if (userName.equals("ZSGS") && password.equals("admin")) {
			User user = new User();
			user.setName(userName);
			user.setEmailId("zsgs@zsgs.in");
			user.setPhoneNo(1234567890);
			//SQL Query 
			loggedInuser = user;
			return user;
		}
		return null;
	}
	
	public User loggedInuserDetail() {
		return loggedInuser;
	}


}
