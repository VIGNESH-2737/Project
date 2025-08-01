package com.zsgs.theatrepass.screens.theatrelistscreen;

import java.util.List;

import com.zsgs.theatrepass.datalayer.TheatrePassRepository;
import com.zsgs.theatrepass.dto.Movie;
import com.zsgs.theatrepass.dto.Screen;
import com.zsgs.theatrepass.dto.Show;
import com.zsgs.theatrepass.dto.Theatre;
import com.zsgs.theatrepass.dto.User;

class TheatreListViewModel {

	private TheatreListScreen view;
	private Theatre selectedTheatre;
	private Movie selectedMovie;
	public TheatreListViewModel(TheatreListScreen theatreListScreen) {
		view = theatreListScreen;
	}
	
	public void onCreate(Movie movie) {
//		User currentUser = TheatrePassRepository.getInstance().loggedInuserDetail();
		List<Theatre> theatreList = TheatrePassRepository.getInstance().getTheatreList(movie);
		view.showTheatreList(theatreList,movie);
		selectedMovie = movie;
	}

	public void onTheatreSelected(Theatre theatre) {
		selectedTheatre = theatre;
		view.showScreensList(theatre.getScreenList());
	}

	public void onShowSelected(int position) {
		int index = 1;
		for (Screen screen :selectedTheatre.getScreenList()) {
			for (Show show : screen.getShows()) {
				if(position ==index) {
					if(screen.getCapacity() < show.getBookedTickets().size())
					view.navigateToBookingScreen();
				}
			}
		}
		
	}
}
