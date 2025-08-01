package com.zsgs.theatrepass.screens.movielist;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.theatrepass.TheatrePass;
import com.zsgs.theatrepass.datalayer.TheatrePassRepository;
import com.zsgs.theatrepass.dto.Movie;

class MovieListViewModel {

	private MovieListScreen view;
	private Movie SelectedMovie;

	public MovieListViewModel(MovieListScreen view) {
		this.view = view;
	}

	public void onCreate() {
		if (TheatrePass.getInstance().hasNetworkConnection()) {
			view.showMovieList(TheatrePassRepository.getInstance().getMovieList());
		}
	}

	public List<String> getMovieList() {
		List<String> movieName = new ArrayList<String>();
		movieName.add("Jailer");
		movieName.add("Goat");
		return movieName;
	}

	public void onMovieSelected(Movie movie) {
		// getting movie details
		// return movie details.
		view.navigateToMovieDetails(movie);
		SelectedMovie = movie;
	}
}
