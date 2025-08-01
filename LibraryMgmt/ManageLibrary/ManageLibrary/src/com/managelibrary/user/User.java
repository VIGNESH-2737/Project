package com.managelibrary.user;

import java.util.Scanner;


public class User {
	protected String userName;
	protected String password;
	static UserViewModel userViewModel;
	static Scanner scanner = new Scanner(System.in);

	public User() {
		System.out.print("Enter Your Name : ");
		userName = scanner.next();
		System.out.println("Enter Password : ");
		password = scanner.next();
		userViewModel = new UserViewModel(this);
	}
	public void addUser() {
		userViewModel.addUser(this);
	}
}
