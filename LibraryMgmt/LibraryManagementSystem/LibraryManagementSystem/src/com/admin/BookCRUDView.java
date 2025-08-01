package com.admin;

import com.model.Repository;

public class BookCRUDView {

	private BookCRUDViewModel bookModel;

	BookCRUDView() {
		bookModel = new BookCRUDViewModel(this);
	}

	public void addBook() {

		System.out.println("Enter the Book Name: ");
		String bookName = Repository.sc.next();

		System.out.println("Enter the ISBN: ");
		String isbn = Repository.sc.next();

		System.out.println("Enter the Author: ");
		String author = Repository.sc.next();
		
		bookModel.addBook(bookName, isbn, author);
	}
	public void showBook() {
		bookModel.getBooksDetails();
	}

	public void removeBook() {
		bookModel.removeBook();	
	}
}
