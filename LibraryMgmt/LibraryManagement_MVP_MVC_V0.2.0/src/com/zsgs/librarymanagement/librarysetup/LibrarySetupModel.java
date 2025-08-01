package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;

//Access modifier for this LibrarySetupModel class should be default. 
//So that outside of the package this class cannot be accessed.
class LibrarySetupModel {

	// This variable should be private.
	// so that outside of this class cannot access this variable.
	private LibrarySetupView librarySetupView;

	private Library library;

	// Access modifier for this LibrarySetupModel constructor should be default.
	// So that outside of the package this constructor cannot be accessed.
	LibrarySetupModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;
		library = LibraryDatabase.getInstance().getLibrary();
	}

	public void startSetup() {
		librarySetupView.showAlert("Fetching data, please wait...");
		LibraryDatabase.getInstance().retriveBookAndUserInfo();
		librarySetupView.showAlert("Fetching data completed");
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete(library);
		}
	}

	public void createLibrary(Library library) {
		// name, email, phone no validation here
		if (library.getLibraryName().length() <3  || library.getLibraryName().length() > 50) {
			librarySetupView.showAlert("Enter valid name");
			return;
		} else if(true/*validate email*/) {
			
		}
		this.library = LibraryDatabase.getInstance().insertLibrary(library);		
		librarySetupView.onSetupComplete(library);
	}
}
