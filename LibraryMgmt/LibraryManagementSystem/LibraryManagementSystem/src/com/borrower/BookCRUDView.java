package com.borrower;

import java.util.List;

import com.model.Book;
import com.model.Borrower;
import com.model.Repository;

public class BookCRUDView {
	private BookCRUDViewModel bookViewModel;

	BookCRUDView() {
		bookViewModel = new BookCRUDViewModel(this);
	}

	void borrowBook() {
		bookViewModel.borrowBook();
	}

	void showBooks() {
		bookViewModel.showBooks();
	}

	void returnBook() {
		bookViewModel.returnBook();

	}

	void viewBorrowedBooks() {
		Repository repository = Repository.getRepository();
		List<Book> borrowedBooks = repository.loggedInUser.getBorrowedBooks();

		if (borrowedBooks == null) {
			System.out.println("Borrowed list is empty");
			return;
		}
		for (Book book : borrowedBooks) {
			System.out.println("    --Book Name: " + book.getBookName());
		}
	}

}
