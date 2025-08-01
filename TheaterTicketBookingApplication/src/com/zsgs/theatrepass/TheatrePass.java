package com.zsgs.theatrepass;

import com.zsgs.theatrepass.screens.LoginScreen;

public class TheatrePass { //Application Class : Starting point of an application
	public static void main(String arg[]) {
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.onCreate(); //Launching the first screen as an instance(login screen)
	}
}
