package com.zsgs.librarymanagement.login;

public interface LoginModel {

	void retriveNeededData();

	void validateUser(String userName, String password);

}
