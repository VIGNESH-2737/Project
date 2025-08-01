package com.zsgs.theatrepass;

import com.zsgs.theatrepass.datalayer.TheatrePassRepository;
import com.zsgs.theatrepass.screens.login.LoginView;
import com.zsgs.theatrepass.screens.movielist.MovieListScreen;

public class TheatrePass { // Application Class : Starting point of an application

	private static TheatrePass sTheatrePass;

	private TheatrePass() {

	}

	public String appName = "Theatre Pass Application";

	public String appVersion = "0.0.4";

	public int appVersionCode = 4;

	public static TheatrePass getInstance() {
		if (sTheatrePass == null) {
			sTheatrePass = new TheatrePass();
		}
		return sTheatrePass;
	}

	public static void main(String arg[]) {
		TheatrePass.getInstance().onCreate();
	}

	public void onCreate() {
		if (TheatrePassRepository.getInstance().isLoggedIn()) {
			MovieListScreen movieListScreen = new MovieListScreen();
			movieListScreen.onCreate();			
		} else {
			LoginView loginScreen = new LoginView();
			loginScreen.onCreate(); // Launching the first screen as an instance(login screen)
		}
	}

	public boolean hasNetworkConnection() {
		return checkConnection(); // Write logic for checking Internet access
	}

	private boolean checkConnection() {
		return true; // Write logic for check Internet access
	}
}
