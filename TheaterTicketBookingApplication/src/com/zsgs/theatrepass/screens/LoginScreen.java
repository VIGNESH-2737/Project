package com.zsgs.theatrepass.screens;

import com.zsgs.theatrepass.BaseScreen;

public class LoginScreen extends BaseScreen {

	public void onCreate() {
		if (hasNetworkConnection()) {
			System.out.println("Proceed to Login");
			MovieListScreen movieListScreen = new MovieListScreen();
			movieListScreen.onCreate();
		} else {
			System.out.println("Please check internet connection");
		}
	}
}
