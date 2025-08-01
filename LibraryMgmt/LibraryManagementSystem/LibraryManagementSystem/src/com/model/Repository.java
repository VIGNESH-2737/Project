package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {

	public Borrower loggedInUser;
	private static Repository repository;
	private ArrayList<Borrower> users = new ArrayList<>();
	private ArrayList<Book> books = new ArrayList<>();
	Borrower sample = new Borrower("surya", "surya", "123", true);

	public static Scanner sc = new Scanner(System.in);

	private Repository() {

	}

	public List<Borrower> getUsers() {
		if (users.size() == 0)
			users.add(sample);
		return users;
	}

	public List<Book> getBooks() {

		return books;
	}

	public void addUser(Borrower b) {
		users.add(b);
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public static Repository getRepository() {

		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public Borrower validateUser(String userId, String password) {
		if (users.size() == 0)
			users.add(sample);
		for (Borrower user : users) {
			if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
				loggedInUser = user;
				break;
			}
		}
		return loggedInUser;
	}

	public Book getBookIfAvailable(String bookName) {
		for (Book book : books) {
			if (book.getBookName().equals(bookName) && book.isStatus()) {
				return book;
			}
		}
		return null;
	}

	public void removeBook(String bookName) {
		for (Book book : books) {
			if (book.getBookName().equals(bookName)) {
				if (book.isStatus()) {
					books.remove(book);
					System.out.println("\nBook removed successfully!");
				}else {
					System.out.println("\nBook is borrowed by someone.");
				}
				return;
			}
		}
		System.out.println("Entered Book is not available!");
	}
}
