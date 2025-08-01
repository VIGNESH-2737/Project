package com.managelibrary.dto;

import java.util.Scanner;

import com.managelibrary.user.Login;
import com.managelibrary.user.User;

public class Main {

	public static void main(String[] args) {
		Login login = null;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("---------------");
			System.out.println(" 1.User Login \n 2.User SignUp \n 3.Delete User");
			System.out.println("---------------");
			System.out.print("Enter Your Choice : ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: 
				login = new Login();
				break;
			case 2:
				new User().addUser();
				break;
			case 3:
				if(login == null) {
					System.out.println("Kindly Login First!");
				}else {
					login.removeUser();					
				}
				break;
			default:
				System.out.println("Inavlid Choice!");
				System.exit(0);
			}
		}
		
	}

}
