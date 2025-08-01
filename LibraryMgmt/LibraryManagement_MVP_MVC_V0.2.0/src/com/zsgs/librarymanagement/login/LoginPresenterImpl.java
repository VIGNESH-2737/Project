package com.zsgs.librarymanagement.login;

public class LoginPresenterImpl implements LoginPresenter, LoginModelPresenter {

	private LoginView loginView;
	private LoginModel loginModel;

	//called from LoginView
	public LoginPresenterImpl(LoginView loginView) {
		this.loginView = loginView;
		loginModel = new LoginModelImpl(this);
	}

	//called from LoginView
	public void retriveNeededData() {
		loginModel.retriveNeededData();
	}
	
	//called from LoginView
	public void validateUser(String userName, String password) {
		loginModel.validateUser(userName, password);
	}

	//called from LoginModel
	public void onSuccess() {
		loginView.onSuccess();
	}

	//called from LoginModel
	public void onLoginFailed(String string) {
		loginView.onLoginFailed(string);
		
	}
}
