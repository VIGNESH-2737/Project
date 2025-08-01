package com.zsgs.theatrepass.datalayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zsgs.theatrepass.dto.Movie;
import com.zsgs.theatrepass.dto.User;
import com.zsgs.theatrepass.dto.Theatre;

public class TheatrePassRepository {
	
	private static TheatrePassRepository repository;
	
	private TheatrePassRepository() {
		
	}
	
	public static TheatrePassRepository getInstance() {
		
		if(repository == null) {
			repository = new TheatrePassRepository();
		}
		
		return repository;
	}


	public List<Movie> getMovieList() {
		 Movie movie = new Movie();
		 movie.setMovieName("GOAT");
		 movie.setMovieDirector("Venkat Prabu");
		 movie.setMovieDescription("New tamil movie starrer by vijay");
		 return Arrays.asList(movie);
	}

	public List<Theatre> getTheatreList(Movie movie) {
		Theatre theatre = new Theatre();
		 theatre.setName("pss mall");
		 theatre.setNoOfScreens("1");
		 theatre.setAddress("Near Railway station, Tenkasi");
		 theatre.setTheatreId(1);
		 return Arrays.asList(theatre);
	}

	public boolean isLoggedIn() {
		return false;
	}
}
