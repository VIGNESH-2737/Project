package com.zsgs.theatrepass.screens.login;

import java.util.Scanner;

import com.zsgs.theatrepass.BaseScreen;
import com.zsgs.theatrepass.TheatrePass;
import com.zsgs.theatrepass.dto.User;
import com.zsgs.theatrepass.screens.movielist.MovieListScreen;

public class LoginView extends BaseScreen {
	private LoginController controller;

	public LoginView() {
		controller = new LoginController(this);
	}

	public void onCreate() {
		if (TheatrePass.getInstance().hasNetworkConnection()) {
			System.out.println("Welcome to theatre "+ TheatrePass.getInstance().appName);
			
			System.out.println("\n\nPlease login to proceed.");
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nEnter the user name:");
			String userName = scanner.next();
			System.out.println("Enter the password:");
			String password = scanner.next();
			
			controller.validateUser(userName, password);
		} else {
			showAlertMessage("Please check internet connection");
		}
	}

	public void navigateMovieList(User loggedInUser) {
		System.out.println("Welcome "+loggedInUser.getName());
		MovieListScreen movieListScreen = new MovieListScreen();
		movieListScreen.onCreate();
	}
}
