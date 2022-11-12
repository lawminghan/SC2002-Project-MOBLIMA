package boundary;

import java.io.Serializable;
import java.util.ArrayList;

import control.InputManager;
import control.MovieManager;
import entity.Movie;

public class ReviewMovie implements Capability, Serializable {

	private static final long serialVersionUID =341L;

	private MovieManager movieMgr;
	
	public ReviewMovie(MovieManager movieMgr) {
		this.movieMgr = movieMgr;
	}


	@Override
	public void performCapability() {
		//get required inputs from user
		System.out.println("Which movie do you wish to review? Enter the movieID: ");
		int movieID = InputManager.getInt();
		
		Movie movie = movieMgr.findMovie(movieID);
		//check if movieID is valid
		if(movie == null) {
			System.out.println("Invalid movieID! Please try again!");
			return;
		}
		
		//get and update ratings
		System.out.println("How many stars (1 to 5) would you rate this movie? ");
		int rating = InputManager.getInt(1, 5);
		ArrayList<Integer> ratings = movie.getPastRatings();
		ratings.add(rating);
		movieMgr.updateMovieRating(movie.getMovieTitle(), ratings);
		
		//get and update reviews
		System.out.println("Would you like to leave a comment as well? (Y/N)");
		boolean comment = InputManager.getY_or_N();
		
		if(comment) {
			System.out.println("Please enter your review below:");
			String review = InputManager.getString();
			ArrayList<String> reviews = movie.getPastReviews();
			reviews.add(review);
			movieMgr.updateMovieReview(movie.getMovieTitle(), reviews);
		}
		
		System.out.println("Thank you for the review! What else would you like to do?");
	}

	

	
	public String toString() {
		String str = "Review Movie";
		return str;
	}
}
