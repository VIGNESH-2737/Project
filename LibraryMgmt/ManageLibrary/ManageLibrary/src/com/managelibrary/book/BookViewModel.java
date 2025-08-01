package com.managelibrary.book;

import java.util.ArrayList;
import java.util.List;

class BookViewModel {

	List<Book> bookList  = new ArrayList<>();
	Book book;
	BookViewModel(Book book) {
		this.book = book;
	}
	
	void addBookList(Book book) {
		bookList.add(book);
	}

	boolean removeFromBookList(String string) {
		for(Book book : bookList) {
			if(book.bookTitle == string) {
				bookList.remove(book);
				return true;
			}
		}
		return false;
	}

	public void displayBook() {
		for(Book book : bookList) {
			System.out.print(book.bookTitle +" "+ book.isbn +" "+ book.authorName +" "+  book.isBookAvailable+"\n");
		}
	}

	public boolean borrowBook(String string) {
		for(Book book : bookList) {
			if(book.bookTitle.equals(string) && book.isBookAvailable) {
				changeBookAvailablity(book);
				return true;
			}
		}
		return false;
	}
	public boolean returnBook(String string) {
		for(Book book : bookList) {
			if(book.bookTitle.equals(string) && !book.isBookAvailable) {
				changeBookAvailablity(book);
				return true;
			}
		}
		return false;
	}
	private void changeBookAvailablity(Book book) {
		book.isBookAvailable = !book.isBookAvailable;
	}

	public boolean isBookAvailable(String string) {
		for(Book book : bookList) {
			if(book.bookTitle.equals(string) && book.isBookAvailable) {
				return true;
			}
		}
		return false;
	}
}
