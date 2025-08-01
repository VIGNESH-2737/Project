package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase {

	private static LibraryDatabase libraryDatabase;

	private Library library;
	private List<Book> bookList = new ArrayList();
	private List<User> userList = new ArrayList();

	public static LibraryDatabase getInstance() {

		if (libraryDatabase == null) {
			libraryDatabase = new LibraryDatabase();
		}
		return libraryDatabase;
	}

	public Library getLibrary() {
		return library;// SQL query and it's result here.
	}

	public Library insertLibrary(Library library2) {
		this.library = library2;
		this.library.setLibraryId(1);
		return library;
	}

	public List<Book> getAllBooks() {
		return bookList;
	}

	public Book getBook(int bookId) {
		for (Book book : bookList) {
			if (book.getId() == bookId) {
				return book;
			}
		}
		// select query with where condition.
		return null;
	}

	public List<Book> searchBooks(String bookName) {
		List<Book> searchResult = new ArrayList();
		for (Book book : bookList) {
			if (book.getName().contains(bookName)) {
				searchResult.add(book);
			}
		}
		// select query with where condition.
		return searchResult;
	}

	public boolean insertBook(Book book) {
		boolean hasBook = false;
		for (Book addedBook : bookList) {
			if (addedBook.getName().equals(book.getName()) && addedBook.getAuthor().equals(book.getAuthor())) {
				hasBook = true;
				break;
			}
		}
		if (hasBook) {
			return false;
		} else {
			bookList.add(book);
			return true;
		}
	}

	public boolean insertUser(User user) {
		boolean hasUser = false;
		for (User addedUser : userList) {
			if (addedUser.getEmailId().equals(user.getEmailId())) {
				hasUser = true;
				break;
			}
		}
		if (hasUser) {
			return false;
		} else {
			userList.add(user);
			return true;
		}
	}

	public void retriveData() {
		// read data from Database/file/ open database connection here.
		
	}

	public void retriveBookAndUserInfo() {
		// Books and user info
		
	}
}
