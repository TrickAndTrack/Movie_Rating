package com.movie.Service;

import java.util.List;

import com.movie.Exceptions.MovieExceptions;
import com.movie.Exceptions.RatingExceptions;
import com.movie.Models.Movies;
import com.movie.Models.longestDurationMovieDTO;
import com.movie.Models.sumVotesDTO;


public interface MoviesService {
	
	public List<longestDurationMovieDTO> maxDurationMovies() throws MovieExceptions;
	
	public Movies createMovies(Movies movie) throws MovieExceptions;
	
	public void getUpdatedRuntimeMovies() throws MovieExceptions,RatingExceptions;
	
	public List<sumVotesDTO> calculateVotes() throws MovieExceptions,RatingExceptions;
	

}
