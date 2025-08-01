package com.zsgs.theatrepass.screens.theatrelistscreen;

import java.util.List;
import java.util.Scanner;

import com.zsgs.theatrepass.BaseScreen;
import com.zsgs.theatrepass.dto.Movie;
import com.zsgs.theatrepass.dto.Screen;
import com.zsgs.theatrepass.dto.Show;
import com.zsgs.theatrepass.dto.Theatre;

public class TheatreListScreen extends BaseScreen {
	private TheatreListViewModel viewModel;

	public TheatreListScreen() {
		viewModel = new TheatreListViewModel(this);
	}

	public void onCreate(Movie movie) {
		viewModel.onCreate(movie);
	}

	public void showTheatreList(List<Theatre> theatreList, Movie movie) {
		System.out.println("Theatres screening movie:" + movie.getMovieName());
		int index = 1;
		for (Theatre theatre : theatreList) {
			System.out.println(index + ". " + theatre.getName());
			System.out.println("   Address: " + theatre.getAddress());
		
		}
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		Scanner scanner = new Scanner(System.in);
		int position;
		while (true) {
			position = scanner.nextInt();
			if (position == 0) {
				showAlertMessage("Thank You");
				System.exit(0);
			} else if (position > theatreList.size()) {
				showAlertMessage("Invalid Entry, Please try again");
				continue;
			}
			break;
		}
		viewModel.onTheatreSelected(theatreList.get(position - 1));
	}

	public void showScreensList(List<Screen> screenList) {
		int index = 1;
		for (Screen screen : screenList) {
			for (Show show : screen.getShows()) {
				System.out.println(index + "Screen No: " + screen.getScreenId());
				System.out.println("   Total Seats: " + screen.getCapacity());
				System.out.println("   ShowTiming: " + show.getShowTiming());
				System.out.println("   Available Seats: " + (screen.getCapacity() - show.getBookedTickets().size()));
				
			}
		}
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		Scanner scanner = new Scanner(System.in);
		int position;
		while (true) {
			position = scanner.nextInt();
			if (position == 0) {
				showAlertMessage("Thank You");
				System.exit(0);
			} else if (position > index) {
				showAlertMessage("Invalid Entry, Please try again");
				continue;
			}
			break;
		}
		viewModel.onShowSelected(position);
	}

	public void navigateToBookingScreen() {
		
	}
}
