package com.zsgs.theatrepass.screens.movielist;

import java.util.List;
import java.util.Scanner;

import com.zsgs.theatrepass.BaseScreen;
import com.zsgs.theatrepass.dto.Movie;
import com.zsgs.theatrepass.screens.theatrelistscreen.TheatreListScreen;

public class MovieListScreen extends BaseScreen {

	private MovieListViewModel viewModel;

	public MovieListScreen() {
		viewModel = new MovieListViewModel(this);
	}

	public void onCreate() {
		viewModel.onCreate();
	}

	public void showMovieList(List<Movie> movieList) {
		System.out.println("List of movie");
		int index = 1;
		for (Movie movie : movieList) {
			System.out.println(index + ". " + movie.getMovieName());
			System.out.println("   Director: " + movie.getMovieDirector());
			System.out.println("   Movie Description: " + movie.getMovieDescription());
		}
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int position = scanner.nextInt();
			if (position == 0) {
				showAlertMessage("Thank You");
				System.exit(0);
			} else if (position > movieList.size()) {
				showAlertMessage("Invalid Entry, Please try again");
				continue;
			}
			break;
		}
		viewModel.onMovieSelected(movieList.get(index - 1));
	}

	public void navigateToMovieDetails(Movie movie) {
		TheatreListScreen theatreListScreen = new TheatreListScreen();
		theatreListScreen.onCreate(movie);
	}

	public void successfullyBlockListed() {
		// Movies listing without blocked movie name.
	}

}
