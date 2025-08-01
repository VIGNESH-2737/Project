package com.zsgs.librarymanagement.librarysetup;

import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginViewImpl;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.manageusers.ManageUsersView;
import com.zsgs.librarymanagement.model.Library;

//Access modifier for this LibrarySetupView class should be public. 
//So that outside of the package this class can be accessed and can create instance for this class.
public class LibrarySetupView {

	// This variable should be private.
	// so that outside of this class cannot access this variable.
	private LibrarySetupModel librarySetupModel;

	// This Constructor should be public.
	// so that all classes can create instance of this class.
	public LibrarySetupView() {
		librarySetupModel = new LibrarySetupModel(this);
	}

	public void init() {
		librarySetupModel.startSetup();
	}

	public void onSetupComplete(Library library) {
		System.out.println("\nLibrary setup completed\n");
		System.out.println("\nCurrent Library Name - " + library.getLibraryName());
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(
					"\n 1. Add Book\n 2. Add user \n 3. Search Book \n 9. Logout \n 0. Exit \n Enter your Choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new ManageBookView().initAdd();
				break;
			case 2:
				new ManageUsersView().initAdd();
				break;
			case 3:
				System.out.println("\nSearch Book Feature is under development\nPlease choose some other option.\n");
				// new SearchBook().initSearch();
				break;
			case 9:
				System.out.println("\n-- You are logged out successfully -- \n\n");
				new LoginViewImpl().init();
				return; // Exit from the current session
			case 0:
				System.out.println("\n-- Thanks for using " + LibraryManagement2024.getInstance().getAppName() + " --");
				return; // Exit from the application
			default:
				System.out.println("\nPlease Enter valid choice\n");
			}
		}
	}

	public void showAlert(String alert) {
		System.out.println(alert);
		initiateSetup();
	}

	public void initiateSetup() {
		System.out.println("\n\nEnter library details:");
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		System.out.println("\nEnter library name:");
		library.setLibraryName(scanner.nextLine());
		System.out.println("\nEnter library email:");
		library.setEmailId(scanner.nextLine());
		librarySetupModel.createLibrary(library);
	}
}
