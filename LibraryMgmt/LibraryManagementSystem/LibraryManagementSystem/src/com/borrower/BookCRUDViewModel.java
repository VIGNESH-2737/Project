package com.borrower;

import java.util.List;

import com.model.Book;
import com.model.Borrower;
import com.model.Repository;

class BookCRUDViewModel {
	private BookCRUDView bookView;
	Repository repository = Repository.getRepository();

	public BookCRUDViewModel(BookCRUDView bookView) {
		this.bookView = bookView;
	}

	void borrowBook() {
		System.out.println("Enter the book name: ");
		String bookName = repository.sc.next();

		Book book = repository.getBookIfAvailable(bookName);

		if (book == null) {
			System.out.println("Entered Book is not available!");
		} else {
			System.out.println("Book Borrowed Successfully!");
			book.setStatus(false);
			repository.loggedInUser.addBook(book);
		}
	}
	void  returnBook() {
		System.out.println("Enter the book name: ");
		String bookName = repository.sc.next();
		
		List<Book> borrowedBooks = repository.loggedInUser.getBorrowedBooks();
		
		if(borrowedBooks==null || borrowedBooks.size() == 0) {
			System.out.println("\nNo books borrowed from this account!.");
		}else {
			for(Book book:borrowedBooks) {
				if(book.getBookName().equals(bookName)) {
					book.setStatus(true);
					repository.loggedInUser.removeBook(book);
					System.out.println("\nBook returned Successfully!");
					return;
				}
			}
			System.out.println("\nInvalid book name");
		}
	}
	void showBooks() {
		if(repository.getBooks().size()==0) System.out.println("Books are not available!");
		for (Book book : repository.getBooks()) {
			System.out
					.println("\nBook Name: " + book.getBookName() + "\nBook ISBN: " + book.getISBN() + "\nBook Author: "
							+ book.getAuthor() + "\nStatus : " + (book.isStatus() ? "Available" : "Not Available"));

			System.out.println("----------------------------------------------");
		}
	}
}
