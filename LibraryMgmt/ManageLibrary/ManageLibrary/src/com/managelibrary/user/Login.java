package com.managelibrary.user;

import java.util.Scanner;

import com.managelibrary.dto.MainFlow;

public class Login {
	Scanner scanner = new Scanner(System.in);
	String name;
	String password;
	
	public Login() {
		if(validate()) {
			System.out.println("Successfully Loged In!");
			MainFlow flow = new MainFlow();
		}else {
			System.out.println("Invalid User Name or Password");
		}
	}

	public void removeUser() {
		UserViewModel.removeUser(name);
			
	}
	public boolean validate() {
		System.out.print("Enter User Name : ");
		name = scanner.next();
		System.out.print("Enter User Password : ");
		password = scanner.next();
		return UserViewModel.validateUser(name, password);
	}

}
