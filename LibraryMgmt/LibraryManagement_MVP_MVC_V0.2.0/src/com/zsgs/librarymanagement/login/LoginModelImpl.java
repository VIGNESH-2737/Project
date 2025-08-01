package com.zsgs.librarymanagement.login;

class LoginModelImpl implements LoginModel{

	private LoginModelPresenter loginPresenter;

	LoginModelImpl(LoginModelPresenter loginPresenter) {
		this.loginPresenter = loginPresenter;
	}

	public void validateUser(String userName, String password) {
		if (isValidUserName(userName)) {
			if (isValidPassword(userName,password)) {
				loginPresenter.onSuccess();
			} else {
				loginPresenter.onLoginFailed("Invalid password");
			}
		} else {
			loginPresenter.onLoginFailed("Invalid User Name");
		}
	}

	// this method should be private because this method used only with in this
	// class.
	private boolean isValidUserName(String userName) {
		return userName.equals("zsgs")||userName.equals("zsgsAdmin");
	}

	// this method should be private because this method used only with in this
	// class.
	private boolean isValidPassword(String userName, String password) {
		return (userName.equals("zsgs")&&password.equals("admin"))||(userName.equals("zsgsAdmin")&&password.equals("admin123"));
	}

	public void retriveNeededData() {
		
	}
}
