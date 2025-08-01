package com.admin;

import com.model.Book;
import com.model.Repository;

public class BookCRUDViewModel {

	private BookCRUDView bookView;
	Repository repository = Repository.getRepository();

	public BookCRUDViewModel(BookCRUDView bookView) {
		this.bookView = bookView;
	}

	void addBook(String bookName, String isbn, String author) {
		Book book = new Book(isbn, bookName, author, true);
		repository.addBook(book);

	}

	public void getBooksDetails() {
		if (repository.getBooks() == null) {
			System.out.println("No books are Added");
			return;
		}
		for (Book book : repository.getBooks()) {
			System.out
					.println("\nBook Name: " + book.getBookName() + "\nBook ISBN: " + book.getISBN() + "\nBook Buthor: "
							+ book.getAuthor() + "\nBook Status: " + (book.isStatus() ? "Available" : "Not Available"));
			System.out.println("--------------------------------------------------");
		}
	}

	public void removeBook() {
		System.out.println("\nEnter the book name: ");
		String name = repository.sc.next();
		repository.removeBook(name);

	}

}
