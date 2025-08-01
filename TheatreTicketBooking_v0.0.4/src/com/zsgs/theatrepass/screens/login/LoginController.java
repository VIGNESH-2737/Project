package com.zsgs.theatrepass.screens.login;

import com.zsgs.theatrepass.datalayer.LoginModel;
import com.zsgs.theatrepass.datalayer.TheatrePassRepository;
import com.zsgs.theatrepass.dto.User;

class LoginController {

	private LoginView view;

	public LoginController(LoginView screen) {
		view = screen;
	}

	public void validateUser(String userName, String password) {
		User loggedInUser = LoginModel.getInstance().validate(userName,password);
		if (loggedInUser!=null) {
			view.navigateMovieList(loggedInUser);
		} else {
			view.showAlertMessage("Invalid User name or Password");
		}
	}
}
