package com.admin;

import java.util.ArrayList;
import java.util.List;

import com.model.Borrower;
import com.model.Repository;

class BorrowerCRUDViewModel {

	BorrowerCRUDView borrowerView;
	private Repository repository = Repository.getRepository();

	BorrowerCRUDViewModel(BorrowerCRUDView view) {
		this.borrowerView = view;
	}

	void addUser(String name, String userId, String password, int isAdmin) {
		Borrower borrower = new Borrower(name, userId, password, isAdmin == 1 ? true : false);
		repository.addUser(borrower);
		System.out.println(isAdmin);
		System.out.println((isAdmin == 1 ? "Admin" : "Borrower ") + " Added Successfully!");
	}

	List<Borrower> getBorrowers() {
		List<Borrower> list = new ArrayList<>();
		for (Borrower b : repository.getUsers()) {
			if (!b.isAdmin())
				list.add(b);
		}
		return list;
	}

}
