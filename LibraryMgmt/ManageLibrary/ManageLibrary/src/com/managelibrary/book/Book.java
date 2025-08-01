package com.managelibrary.book;

import java.util.Scanner;

public class Book {
	protected String bookTitle;
	protected int isbn;
	protected String authorName;
	protected boolean isBookAvailable;
	
	private BookViewModel bookViewModel ;
	Scanner scanner = new Scanner(System.in);
	
	public Book(){
		
		System.out.print("Enter Book Name : ");
		bookTitle = scanner.next();
		System.out.print("Enter ISBN : ");
		isbn = scanner.nextInt();
		System.out.print("Enter Author Name : ");
		authorName = scanner.next();
		isBookAvailable = true;
		bookViewModel  = new BookViewModel(this);
		addBook();
	}
	
	public void addBook() {
		bookViewModel.addBookList(this);
		System.out.println("Book Added Successfully!");
	}
	
	public void removeBook() {
		System.out.print("Enter Book Name : ");
		if(bookViewModel.removeFromBookList(scanner.next())) {
			System.out.println("Book Removed Successfully!");
		}else {
			System.out.println("Sorry! Book Not found.");
		}
	}
	
	public void borrowBook() {
		bookViewModel.displayBook();
		System.out.println("Choose The Book you Need : ");
		if(bookViewModel.borrowBook(scanner.next())){
			System.out.println("Book Borrowed Successfully!");
		}else {
			System.out.println("You Have Choosen Wrong or Unavailable Book!");
		}
	}
	
	public void returnBook() {
		System.out.println("Enter Book Name That you want to Return : ");
		if(bookViewModel.returnBook(scanner.next())) {
			System.err.println("Book Returned Successfully");
		}else {
			System.out.println("Sorry Unable to Find Book!");
		}
	}
	public void viewBook() {
		bookViewModel.displayBook();
	}
	public void searchBook() {
		System.out.print("Enter Book Name : ");
		if(bookViewModel.isBookAvailable(scanner.next())) {
			System.err.println("Book is AVailable,Grab it soon...");
		}else {
			System.out.println("Sorry Unable to Find Book!");
		}
	}
	
}
