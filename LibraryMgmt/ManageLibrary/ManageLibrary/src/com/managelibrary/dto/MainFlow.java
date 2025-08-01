package com.managelibrary.dto;

import java.util.Scanner;

import com.managelibrary.book.Book;

public class MainFlow {
	Book book;
	Scanner scanner = new Scanner(System.in);
	public MainFlow() {
 outer : while(true) {
	 		System.out.println("---------------");
			System.out.println(" 1.Add Book\n 2.Remove Book\n 3.Search Book\n 4.View Books\n 5.Borrow Book\n 6.Return Book\n 7.Exit");
			System.out.println("---------------");
			System.out.print("Enter Your Choice : ");
			
			int choice = scanner.nextInt();
			switch (choice) {
			case 1 -> book = new Book();
			case 2 -> book.removeBook();
			case 3 -> book.searchBook();
			case 4 -> book.viewBook();
			case 5 -> book.borrowBook();
			case 6 -> book.returnBook();	
			case 7 -> {
				break outer;
			}
			default -> 
			{
				System.out.println("Invalid Choice");
			}
			}
		}
	}
	
}
